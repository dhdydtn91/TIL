package gof.java.designpatterns.structural_patterns.before.security;

import gof.java.designpatterns.structural_patterns.after.security.UserDetails;
import gof.java.designpatterns.structural_patterns.after.security.UserDetailsService;

public class LoginHandler {

    UserDetailsService userDetailsService;

    public LoginHandler(UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    public String login(String username, String password) {
        UserDetails userDetails = userDetailsService.loadUser(username);
        if (userDetails.getPassword().equals(password)) {
            return userDetails.getUsername();
        } else {
            throw new IllegalArgumentException();
        }
    }
}
