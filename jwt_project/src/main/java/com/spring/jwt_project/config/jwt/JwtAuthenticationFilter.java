package com.spring.jwt_project.config.jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.spring.jwt_project.config.auth.PrincipalDetails;
import com.spring.jwt_project.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;

//스프링 시큐리티에서 UsernamePasswordAuthenticationFilter가 있음
// /login 요청해서 username, password 전송하면(post)
// UsernamePasswordAuthenticationFilter 동작을 함,
@RequiredArgsConstructor
public class JwtAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    private final AuthenticationManager authenticationManager;

    //login 요청을 하면 로그인 시도를 위해서 실행되는 함수

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        //1.username password 받아서
        //2.정상적인지 로그인 시도를 해봄. authenticationManager로 로그인 시도를 하면 PrincipalDetailsService가 호출

        //3.PrincipalDetails를 세션에 담고
        //4.JWT토큰을 만들어서 응답해주면됨됨
        System.out.println("JwtAuthenticationFilter : 로그인 시도중");

        //1.username , password 받아서
        try {
            ObjectMapper om = new ObjectMapper();
            User user = om.readValue(request.getInputStream(), User.class);
            System.out.println(user);

            UsernamePasswordAuthenticationToken authenticationToken =
                    new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword());

            //PrincipalDetailsService의 loadUserByUsername() 함수가 실행됨됨
            Authentication authentication =
                    authenticationManager.authenticate(authenticationToken);

            //authentication 객체가 session영역에 저장됨 => 로그인이 되었다는 뜻 (DB에 있는 ID와 PASSWORD가 일치한다.)
            PrincipalDetails principalDetails = (PrincipalDetails) authentication.getPrincipal();
            System.out.println(principalDetails.getUser().getUsername()); //정상적으로 로그인이 되었는지 확인
            System.out.println("1===========================================");
            //authentication 객체가 session영역에 저장을 해야하고 그 방법이 return해주면 됨.
            //리턴의 이유는 권한 관리를 security가 대신 해주기 떄무에 편하려고 하는 거임.
            //굳이 JWT 토큰을 사용하면서 세션을 만들 이유가 없음. 근데 단지 권한 처리떄문에 session 넣어줍니다.

            return authentication;

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    //attemptAuthentication 실행 후 인증이 정상적으로 되었으면 successfulAuthentication 함수가 실행
    //JWT토큰을 만들어서 request요청한 사용자에게 JWT 토큰을 response해주면 됨.
    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {

        PrincipalDetails principal = (PrincipalDetails) authResult.getPrincipal();

        //RSA 방식은 아니고 hash암호방식식
        String jwtToken = JWT.create()
                .withSubject("jwt토큰")
                .withExpiresAt(new Date(System.currentTimeMillis() + (1000 * 60 * 30)))
                .withClaim("id", principal.getUser().getId())
                .withClaim("username", principal.getUser().getUsername())
                .sign(Algorithm.HMAC512("jwt"));

        response.addHeader("Authorization", "Bearer " + jwtToken);
    }
}
