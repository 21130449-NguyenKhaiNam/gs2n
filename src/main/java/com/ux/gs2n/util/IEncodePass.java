package com.ux.gs2n.util;

public interface IEncodePass extends IUtil {
    String encodePass(String password);
    boolean verifyPassword(String password, String hashedPassword);
}
