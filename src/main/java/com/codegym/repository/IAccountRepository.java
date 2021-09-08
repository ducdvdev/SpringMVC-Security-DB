package com.codegym.repository;

import com.codegym.models.Account;
import org.springframework.data.repository.Repository;

public interface IAccountRepository extends Repository<Account, Long> {
    Account findAccountsByUsername(String username);
}
