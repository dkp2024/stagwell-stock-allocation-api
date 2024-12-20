package com.stagwell.stagwellapp.util;
import lombok.extern.slf4j.Slf4j;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;
@Slf4j
public class AESUtils {


    // Base64 Encryption (Encrypt a string)
    public static String encrypt(String plainText) throws Exception {
        return Base64.getEncoder().encodeToString(plainText.getBytes());

    }

    //  Decryption (Decrypt a string)
    public static String decrypt(String encoded) throws Exception {
        byte[] decodedBytes = Base64.getDecoder().decode(encoded);
       return  new String(decodedBytes);
    }



}
