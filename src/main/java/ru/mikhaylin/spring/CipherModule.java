package ru.mikhaylin.spring;

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CipherModule {
    private static CipherProcessor cipherProcessor;

    public static String processingChangePin(String encryptedPin, String encryptedPan) {
        Map<String, String> map = null;
        try {
            map = cipherProcessor.decryptData(encryptedPin, encryptedPan);
        } catch (Exception e) {
            return "false";
        }
        Pattern pattern = Pattern.compile("^\\d{4}$");
        Matcher matcher = pattern.matcher(map.get("decryptedPin"));
        if (matcher.find()) {
            return "Successful";
        }
        return "false";
    }

    public static String getPublicKeyString() {
        return cipherProcessor.getPublicKeyString();
    }

    public static void setCipherProcessor(CipherProcessor settableCipherProcessor) {
        cipherProcessor = settableCipherProcessor;
    }
}
