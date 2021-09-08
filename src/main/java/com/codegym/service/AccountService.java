package com.codegym.service;

import com.codegym.models.Account;
import com.codegym.repository.IAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AccountService implements UserDetailsService {
    @Autowired
    private IAccountRepository accountRepository;
    public Account findAccountByUsername(String username){
        return accountRepository.findAccountsByUsername(username);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Account account=accountRepository.findAccountsByUsername(username);
        List<GrantedAuthority> auth=new ArrayList<>();
        auth.add(account.getRole());
        UserDetails userDetails=new User(
                account.getUsername(),
                account.getPasswd(),
                auth
        );
        return userDetails;
    }
}
