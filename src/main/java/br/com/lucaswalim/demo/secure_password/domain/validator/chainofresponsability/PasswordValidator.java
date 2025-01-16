package br.com.lucaswalim.demo.secure_password.domain.validator.chainofresponsability;

import java.util.List;

public interface PasswordValidator {

    List<String> validate(String password);

    void setNext(PasswordValidator nextValidator);
}
