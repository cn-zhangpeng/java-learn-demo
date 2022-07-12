package com.learn.java.nacosinfoencrypt.common.config;

import org.jasypt.encryption.StringEncryptor;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

@Component("desencrypt")
public class MyStringEncryptor implements StringEncryptor {

    private final EncryptDecrypt encryptDecryptService = new EncryptDecrypt();

    @Override
    public String encrypt(String message) {
        if (!ObjectUtils.isEmpty(message)){
            try {
                message = encryptDecryptService.encrypt(message);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return message;
    }

    @Override
    public String decrypt(String encryptedMessage) {
        if (!ObjectUtils.isEmpty(encryptedMessage)){
            try {
                encryptedMessage = encryptDecryptService.decrypt(encryptedMessage);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return encryptedMessage;
    }
}
