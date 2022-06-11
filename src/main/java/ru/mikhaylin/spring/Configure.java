package ru.mikhaylin.spring;

public class Configure {
    public static void load() {
        CipherProcessor cipherProcessor = CipherProcessor.getCipherProcessor();
        CipherModule.setCipherProcessor(cipherProcessor);
    }
}
