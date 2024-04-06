package com.ux.gs2n.services.auth;

import com.ux.gs2n.dao.account.AccountDaoImp;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImp implements IAccountService {
    @Autowired
    private AccountDaoImp dao;

    @Override
    @Transactional
    public String getAccount(String email, String encodePass) {
        return dao.getAccount(email, encodePass);
    }
}
