package ru.mikhaylin.spring;

import java.security.NoSuchAlgorithmException;
import java.util.Map;

import static java.util.Map.entry;

public class CipherProcessor {
    private static RSA rsa;
    private static CipherProcessor cipherProcessor;

    private CipherProcessor() {
    }

    public static CipherProcessor getCipherProcessor() {
        if (cipherProcessor == null) {
            rsa = new RSA();
            try {
                rsa.initialize();
            } catch (NoSuchAlgorithmException ignored) {

            }
            return new CipherProcessor();
        } else {
            return cipherProcessor;
        }
    }

    public Map<String, String> decryptData(String encryptedPin, String encryptedPan) throws Exception {
        String decryptedPin = null;
        String decryptedPan = null;
        decryptedPin = rsa.decrypt(encryptedPin);
        decryptedPan = rsa.decrypt(encryptedPan);
        return Map.ofEntries(entry("decryptedPin", decryptedPin), entry("decryptedPan", decryptedPan));
    }

    public String getPublicKeyString() {
        return rsa.getPublicKeyString();
    }
}
