package gof.java.designpatterns.structural_patterns.after.security;

public interface UserDetailsService {

    UserDetails loadUser(String username);

}
