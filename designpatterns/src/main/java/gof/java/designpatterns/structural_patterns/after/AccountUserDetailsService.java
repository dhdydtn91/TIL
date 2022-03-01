package gof.java.designpatterns.structural_patterns.after;

import gof.java.designpatterns.structural_patterns.after.security.UserDetails;
import gof.java.designpatterns.structural_patterns.after.security.UserDetailsService;

public class AccountUserDetailsService implements UserDetailsService {
    
    private AccountService accountService;

    public AccountUserDetailsService(AccountService accountService) {
        this.accountService = accountService;
    }

    @Override
    public UserDetails loadUser(String username) {
        Account accountByUsername = accountService.findAccountByUsername(username);
        return new AccountUserDetails(accountByUsername);
    }
}
