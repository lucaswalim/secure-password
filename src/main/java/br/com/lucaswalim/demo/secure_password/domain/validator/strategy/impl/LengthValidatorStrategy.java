package br.com.lucaswalim.demo.secure_password.domain.validator.strategy.impl;

import br.com.lucaswalim.demo.secure_password.domain.validator.strategy.PasswordValidator;
import org.springframework.stereotype.Component;

@Component
public class LengthValidatorStrategy implements PasswordValidator {

    @Override
    public boolean validate(String password) {
        return password.length() >= 8;
    }

    @Override
    public String getErrorMessage() {
        return "A senha deve possuir pelo menos 8 caracteres";
    }
}
