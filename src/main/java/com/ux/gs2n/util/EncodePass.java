package com.ux.gs2n.util;

import at.favre.lib.crypto.bcrypt.BCrypt;

public class EncodePass implements IEncodePass {
    private static EncodePass encodePass;
    private EncodePass() {}

    public static EncodePass getInstance() {
        return encodePass == null ? (encodePass = new EncodePass()) : encodePass;
    }

    @Override
    public String encodePass(String password) {
        return BCrypt.withDefaults().hashToString(12, password.toCharArray());
    }

    @Override
    public boolean verifyPassword(String password, String hashedPassword) {
        return BCrypt.verifyer().verify(password.toCharArray(), hashedPassword).verified;
    }
}
