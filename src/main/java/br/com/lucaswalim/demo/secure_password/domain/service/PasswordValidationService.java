package br.com.lucaswalim.demo.secure_password.domain.service;

import br.com.lucaswalim.demo.secure_password.api.dto.PasswordRequest;
import br.com.lucaswalim.demo.secure_password.api.dto.PasswordResponse;

public interface PasswordValidationService {

    PasswordResponse validatePassword(PasswordRequest passwordRequest);
}
