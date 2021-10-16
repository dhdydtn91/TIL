package com.security.basic.config.oauth;

import com.security.basic.config.auth.PrincipalDetails;
import com.security.basic.config.oauth.provider.FacebookUserInfo;
import com.security.basic.config.oauth.provider.GoogleUserInfo;
import com.security.basic.config.oauth.provider.Oauth2UserInfo;
import com.security.basic.model.User;
import com.security.basic.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class PrincipalOauth2UserService extends DefaultOAuth2UserService {

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private UserRepository userRepository;

    // 구글로 부터 받은 userRequest 데이터에 대한 후처리되는 함수
    // @AuthenticationPrincipal 어노테이션이 만들어진다.
    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
        // 구글로그인 버튼 클릭 -> 구글 로그인 창 -> 로그인을 완료 -> code를 리턴(OAuth-Client라이브러리)-> AccessToken요청
        // userRequest 정보 -> loadUser 함수 호출 -> 구글로부터 회원프로필 받아준다.

        OAuth2User oAuth2User = super.loadUser(userRequest);
        System.out.println("oAuth2User = " + oAuth2User.getAttributes());

        Oauth2UserInfo oauth2UserInfo = null;
        if(userRequest.getClientRegistration().getRegistrationId().equals("google")){
            oauth2UserInfo = new GoogleUserInfo(oAuth2User.getAttributes());
        }else if(userRequest.getClientRegistration().getRegistrationId().equals("facebook")){
            oauth2UserInfo = new FacebookUserInfo(oAuth2User.getAttributes());
        }else if(userRequest.getClientRegistration().getRegistrationId().equals("naver")){
            oauth2UserInfo = new FacebookUserInfo((Map)oAuth2User.getAttributes().get("response"));
        }
        User byUsername = null;

        if(oauth2UserInfo != null){
            String provider = oauth2UserInfo.getProvider();
            String providerId = oauth2UserInfo.getProviderId();
            String username = provider+"_"+providerId;
            String password = bCryptPasswordEncoder.encode("oauth로그인");
            String email = oauth2UserInfo.getEmail();
            String role = "ROLE_USER";

            byUsername = userRepository.findByUsername(username);

            if(byUsername == null){
                byUsername = User.builder()
                        .username(username)
                        .password(password)
                        .email(email)
                        .role(role)
                        .provider(provider)
                        .providerId(providerId)
                        .build();
                userRepository.save(byUsername);
            }
        }
        return new PrincipalDetails(byUsername,oAuth2User.getAttributes());
    }
}
