package br.com.lucaswalim.demo.secure_password.domain.service.impl;

import br.com.lucaswalim.demo.secure_password.api.dto.PasswordRequest;
import br.com.lucaswalim.demo.secure_password.api.dto.PasswordResponse;
import br.com.lucaswalim.demo.secure_password.domain.service.PasswordValidationService;
import br.com.lucaswalim.demo.secure_password.domain.validator.chainofresponsability.impl.PasswordValidatorChain;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("passwordValidationChain")
public class PasswordValidationServiceChainImpl implements PasswordValidationService {

    private final PasswordValidatorChain passwordValidatorChain;

    public PasswordValidationServiceChainImpl(PasswordValidatorChain passwordValidatorChain) {
        this.passwordValidatorChain = passwordValidatorChain;
    }

    @Override
    public PasswordResponse validatePassword(PasswordRequest passwordRequest) {
        List<String> errors = passwordValidatorChain.validate(passwordRequest.getPassword());
        boolean valid = errors.isEmpty();
        return new PasswordResponse(valid, errors);
    }
}
