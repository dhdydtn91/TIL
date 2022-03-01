package gof.java.designpatterns.structural_patterns.after;

import gof.java.designpatterns.structural_patterns.after.security.LoginHandler;
import gof.java.designpatterns.structural_patterns.after.security.UserDetailsService;

public class App {
    public static void main(String[] args) {
        AccountService accountService = new AccountService();
        UserDetailsService userDetailsService = new AccountUserDetailsService(accountService);
        LoginHandler loginHandler = new LoginHandler(userDetailsService);

        String login = loginHandler.login("keesun", "keesun");
        System.out.println(login);
    }
}
