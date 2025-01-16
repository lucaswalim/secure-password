package br.com.lucaswalim.demo.secure_password.domain.validator.chainofresponsability.impl;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PasswordValidatorChain {

    public List<String> validate(String password) {
        var lengthValidator = new LengthValidatorChain();
        var upperCaseValidator = new UpperCaseValidatorChain();
        var lowerCaseValidator = new LowerCaseValidatorChain();
        var numericValidator = new NumericValidatorChain();
        var especialValidator = new EspecialValidatorChain();

        lengthValidator.setNext(upperCaseValidator);
        upperCaseValidator.setNext(lowerCaseValidator);
        lowerCaseValidator.setNext(numericValidator);
        numericValidator.setNext(especialValidator);

        return lengthValidator.validate(password);
    }
}
