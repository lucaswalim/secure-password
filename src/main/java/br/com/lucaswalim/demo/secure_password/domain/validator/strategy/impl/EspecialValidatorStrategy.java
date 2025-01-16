package br.com.lucaswalim.demo.secure_password.domain.validator.strategy.impl;

import br.com.lucaswalim.demo.secure_password.domain.validator.strategy.PasswordValidator;
import org.springframework.stereotype.Component;

@Component
public class EspecialValidatorStrategy implements PasswordValidator {
    @Override
    public boolean validate(String password) {
        return password != null && password.chars().anyMatch(ch -> !Character.isLetterOrDigit(ch));
    }

    @Override
    public String getErrorMessage() {
        return "A senha deve possuir pelo menos 1 caractere ESPECIAL";
    }
}
