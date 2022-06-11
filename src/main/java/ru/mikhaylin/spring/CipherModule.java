package ru.mikhaylin.spring;

public class CipherModule {
    private static CipherProcessor cipherProcessor;

    public static String processingChangePin(String encryptedPin, String encryptedPan) {
        return cipherProcessor.processingChangePin(encryptedPin, encryptedPan);
    }

    public static String getPublicKey() {
        return cipherProcessor.getPublicKey();
    }

    public static void setCipherProcessor(CipherProcessor settableCipherProcessor) {
        cipherProcessor = settableCipherProcessor;
    }
}
