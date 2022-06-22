package ru.mikhaylin.spring;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CipherModuleController {

    @GetMapping("/changePin")
    public String changePin(Model model) {
        Configure.load();
        String publicKey = CipherModule.getPublicKeyString();
        model.addAttribute("publicKey", publicKey);
        return "changePin";
    }

    @GetMapping("/processingPinChange")
    public String processingPinChange(@RequestParam(name = "encryptedPin") String encryptedPin,
                                      @RequestParam(name = "encryptedPan") String encryptedPan, Model model) {
        String pinChangeResult = CipherModule.processingChangePin(encryptedPin, encryptedPan);
        if (pinChangeResult.equals("200")) {
            return "successful";
        } else {
            return "failed";
        }
    }
}
