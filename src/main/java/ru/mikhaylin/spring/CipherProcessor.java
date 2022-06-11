package ru.mikhaylin.spring;

import java.security.NoSuchAlgorithmException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CipherProcessor {
    private static RSA rsa;
    private static CipherProcessor cipherProcessor;

    private CipherProcessor() {
    }

    public static CipherProcessor getCipherProcessor() {
        if (cipherProcessor == null) {
            rsa = new RSA();
            try {
                rsa.init();
            } catch (NoSuchAlgorithmException ignored) {

            }
            return new CipherProcessor();
        } else {
            return cipherProcessor;
        }
    }

    public String processingChangePin(String encryptedPin) {
        String decryptedPin = null;
        try {
            decryptedPin = rsa.decrypt(encryptedPin);
        } catch (Exception exception) {
            return "Exception";
        }
        Pattern pattern = Pattern.compile("^\\d{4}$");
        Matcher matcher = pattern.matcher(decryptedPin);
        if (matcher.find()) {
            return "Successful";
        }
        return "Exception";
    }

    public String getPublicKey() {
        return rsa.getPublicKeyString();
    }
}
