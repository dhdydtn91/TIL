package com.spring.jwt_project.config.auth;

import com.spring.jwt_project.model.User;
import com.spring.jwt_project.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

//http://localhost:8080/login => 여기서 동작안한다.
@Service
@RequiredArgsConstructor
public class PrincipalDetailService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println(username);
        User userEntity = userRepository.findByUsername(username);
        System.out.println(userEntity);
        return new PrincipalDetails(userEntity);
    }
}
