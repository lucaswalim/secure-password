package br.com.lucaswalim.demo.secure_password.api.controller;

import br.com.lucaswalim.demo.secure_password.api.dto.PasswordRequest;
import br.com.lucaswalim.demo.secure_password.api.dto.PasswordResponse;
import br.com.lucaswalim.demo.secure_password.domain.service.PasswordValidationService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/password")
public class PasswordController {

    private final PasswordValidationService validatorServiceChain;
    private final PasswordValidationService validatorServiceStrategy;

    public PasswordController(@Qualifier("passwordValidationChain") PasswordValidationService validatorServiceChain,
                              @Qualifier("passwordValidationStrategy") PasswordValidationService validatorServiceStrategy) {
        this.validatorServiceChain = validatorServiceChain;
        this.validatorServiceStrategy = validatorServiceStrategy;
    }

    @PostMapping("/chain-validate")
    public ResponseEntity<PasswordResponse> validatePasswordChain(@RequestBody PasswordRequest password) {
        var passwordResponse = validatorServiceChain.validatePassword(password);

        if (passwordResponse.isValid()) {
            return ResponseEntity.ok(passwordResponse);
        }

        return ResponseEntity.badRequest().body(passwordResponse);
    }

    @PostMapping("/strategy-validate")
    public ResponseEntity<PasswordResponse> validatePasswordStrategy(@RequestBody PasswordRequest password) {
        var passwordResponse = validatorServiceStrategy.validatePassword(password);

        if (passwordResponse.isValid()) {
            return ResponseEntity.ok(passwordResponse);
        }

        return ResponseEntity.badRequest().body(passwordResponse);
    }
}
