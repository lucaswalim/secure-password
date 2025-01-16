package br.com.lucaswalim.demo.secure_password.domain.validator.chainofresponsability.impl;

import br.com.lucaswalim.demo.secure_password.domain.validator.chainofresponsability.PasswordValidator;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class LowerCaseValidatorChain implements PasswordValidator {

    public static final String LOWER = ".*[a-z].*";
    private PasswordValidator nextValidator;

    @Override
    public List<String> validate(String password) {
        List<String> errors = new ArrayList<>();

        if (password == null || !password.matches(LOWER)) {
            errors.add("A senha deve possuir pelo menos 1 caractere MINÙSUCLO");
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
