package com.security.basic.config.auth;

//시큐리티가 /login 주소 요청이 오면 낚아채서 로그인을 진행시킨다.
//로그인을 진행이 완료가 되면 시큐리티 세선을 만들어줍니다. (Security ContextHolder)
//오브젝트 => Authentication 타입 객체
//Authentication 안에 User 정보가 있어야됨
//User 오브젝트 타입 => UserDetails타입 객체

//Security Session => Authentication => UserDetails(PrincipalDetails)

import com.security.basic.model.User;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.core.user.OAuth2User;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

@Getter
public class PrincipalDetails implements UserDetails, OAuth2User {

    private final User user;
    private Map<String, Object> attributes;

    public PrincipalDetails(User user) {
        this.user = user;
    }

    public PrincipalDetails(User user, Map<String, Object> attributes) {
        this.user = user;
        this.attributes = attributes;
    }

    @Override
    public Map<String, Object> getAttributes() {
        return attributes;
    }

    @Override
    public String getName() {
        return null;
    }

    //해당 User의 권한을 리턴하는 곳
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Collection<GrantedAuthority> collect = new ArrayList<>();
        collect.add((GrantedAuthority) user::getRole);
        return collect;
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() { //비밀번호 기간이 지났는지
        return true;
    }

    @Override
    public boolean isEnabled() { // 활성화 되었는지
        //우리 사이트!! 1년동안 회원이 로그인을 안하면 휴먼계정으로 하기로 함.
        return true;
    }

}
