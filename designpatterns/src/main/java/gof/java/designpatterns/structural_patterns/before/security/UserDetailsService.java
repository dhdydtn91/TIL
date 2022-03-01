package gof.java.designpatterns.structural_patterns.before.security;

import gof.java.designpatterns.structural_patterns.after.security.UserDetails;

public interface UserDetailsService {

    UserDetails loadUser(String username);

}
