package br.com.lucaswalim.demo.secure_password.domain.validator.strategy;

public interface PasswordValidator {

    boolean validate(String password);

    String getErrorMessage();
}
