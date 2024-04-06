package com.ux.gs2n.controller.api.auth;

import com.ux.gs2n.controller.IPathApi;
import com.ux.gs2n.dao.account.AccountDaoImp;
import com.ux.gs2n.services.auth.AccountServiceImp;
import com.ux.gs2n.util.EncodePass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(IPathApi.PATH_AUTH)
public class Login {
    @Autowired
    private AccountServiceImp accountService;

    @PostMapping( "/login")
    public String getAccount(@Param("email") String email,@Param("pass") String pass) {
        return accountService.getAccount(email, EncodePass.getInstance().encodePass(pass));
    }

}
