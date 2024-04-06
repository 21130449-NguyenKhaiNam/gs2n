package com.ux.gs2n.dao.account;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ux.gs2n.model.account.Account;
import jakarta.persistence.EntityManager;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AccountDaoImp implements IAccountDao {
    @Autowired
    private EntityManager entityManager;

    @Override
    public String getAccount(String email, String encodePass) {
        Session currentSession = entityManager.unwrap(Session.class);
        Query<Account> query = currentSession.createQuery("from Account where email = :email", Account.class);
        query.setParameter("email", email);
        List<Account> result = query.getResultList();
        if (result.size() == 1) {
            return "Chua xac dinh";
        } else {
            return null;
        }
    }
}
