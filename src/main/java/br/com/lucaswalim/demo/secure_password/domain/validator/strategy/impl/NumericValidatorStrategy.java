package br.com.lucaswalim.demo.secure_password.domain.validator.strategy.impl;

import br.com.lucaswalim.demo.secure_password.domain.validator.strategy.PasswordValidator;
import org.springframework.stereotype.Component;

@Component
public class NumericValidatorStrategy implements PasswordValidator {

    @Override
    public boolean validate(String password) {
        return password != null && password.chars().anyMatch(Character::isDigit);
    }

    @Override
    public String getErrorMessage() {
        return "A senha deve possuir pelo menos 1 caractere NÚMERICO";
    }
}
