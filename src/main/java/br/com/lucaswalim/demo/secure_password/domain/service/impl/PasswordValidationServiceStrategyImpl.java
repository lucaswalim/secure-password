package br.com.lucaswalim.demo.secure_password.domain.service.impl;

import br.com.lucaswalim.demo.secure_password.api.dto.PasswordRequest;
import br.com.lucaswalim.demo.secure_password.api.dto.PasswordResponse;
import br.com.lucaswalim.demo.secure_password.domain.service.PasswordValidationService;
import br.com.lucaswalim.demo.secure_password.domain.validator.strategy.PasswordValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service("passwordValidationStrategy")
public class PasswordValidationServiceStrategyImpl implements PasswordValidationService {
    private final List<PasswordValidator> validators;

    @Autowired
    public PasswordValidationServiceStrategyImpl(List<PasswordValidator> validators) {
        this.validators = validators;
    }

    @Override
    public PasswordResponse validatePassword(PasswordRequest passwordRequest) {
        List<String> errorMessages = validators.stream()
                .filter(validator -> !validator.validate(passwordRequest.getPassword()))
                .map(PasswordValidator::getErrorMessage)
                .collect(Collectors.toList());

        boolean isValid = errorMessages.isEmpty();
        return new PasswordResponse(isValid, errorMessages);
    }

}
