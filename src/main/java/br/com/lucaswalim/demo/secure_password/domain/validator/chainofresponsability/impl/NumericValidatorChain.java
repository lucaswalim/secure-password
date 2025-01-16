package br.com.lucaswalim.demo.secure_password.domain.validator.chainofresponsability.impl;

import br.com.lucaswalim.demo.secure_password.domain.validator.chainofresponsability.PasswordValidator;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class NumericValidatorChain implements PasswordValidator {

    public static final String NUMERIC = ".*\\d.*";
    private PasswordValidator nextValidator;

    @Override
    public List<String> validate(String password) {
        List<String> errors = new ArrayList<>();

        if (password == null || !password.matches(NUMERIC)) {
            errors.add("A senha deve possuir pelo menos 1 caractere NUMÈRICO");
        }

        if (nextValidator != null) {
            errors.addAll(nextValidator.validate(password));
        }

        return errors;
    }

    @Override
    public void setNext(PasswordValidator nextValidator) {
        this.nextValidator = nextValidator;
    }
}
