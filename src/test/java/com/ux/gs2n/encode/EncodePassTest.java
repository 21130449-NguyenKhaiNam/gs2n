package com.ux.gs2n.encode;

import com.ux.gs2n.util.EncodePass;

public class EncodePassTest {
    public static void main(String[] args) {
        String password1 = "abc@12345678";
        String password2 = "abc@12345678";

        // Hash
        String hash1 = EncodePass.getInstance().encodePass(password1);
        String hash2 = EncodePass.getInstance().encodePass(password2);
        System.out.println(hash1);
        System.out.println(hash2);

        // Check
        System.out.println(EncodePass.getInstance().verifyPassword(password1, hash2));
    }
}
