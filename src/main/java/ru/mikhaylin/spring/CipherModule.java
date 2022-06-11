package ru.mikhaylin.spring;

public class CipherModule {
    private static CipherProcessor cipherProcessor;

    public static String processingChangePin(String encryptedPin) {
        return cipherProcessor.processingChangePin(encryptedPin);
    }

    public static String getPublicKey() {
        return cipherProcessor.getPublicKey();
    }

    public static void setCipherProcessor(CipherProcessor settableCipherProcessor) {
        cipherProcessor = settableCipherProcessor;
    }
}
