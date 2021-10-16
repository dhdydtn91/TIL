package com.security.basic.config.auth;


import com.security.basic.model.User;
import com.security.basic.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

// 시큐리티 설정에서 loginProcessingUrl("/login");
// /login 요청이 오면 자동으로 UserDetailsService 타입으로 Ioc 되어 있는 loadUserByUserName 함수가 실행
// @AuthenticationPrincipal 어노테이션이 만들어진다.
@Service
public class PrincipalDetailsService implements UserDetailsService {
    //web에서 넘어오는 파라미터의 name 값이 username이 아닐경우 Config에서 추가적인 설정이 필요함
    //.usernameParameter("바꾸고 싶은 파라미터 네임임)

    @Autowired
    private UserRepository userRepository;

    // 시큐리티 session = Authentication(내부 UserDeatils) = UserDetails
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User userEntity = userRepository.findByUsername(username);
        if(userEntity != null){
            return new PrincipalDetails(userEntity);
        }
        return null;
    }
}
