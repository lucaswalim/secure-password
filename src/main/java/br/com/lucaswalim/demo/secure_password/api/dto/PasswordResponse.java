package br.com.lucaswalim.demo.secure_password.api.dto;

import java.util.List;

public class PasswordResponse {

    private boolean valid;
    private List<String> messages;

    public PasswordResponse(boolean valid, List<String> messages) {
        this.valid = valid;
        this.messages = messages;
    }

    public boolean isValid() {
        return valid;
    }

    public void setValid(boolean valid) {
        this.valid = valid;
    }

    public List<String> getMessages() {
        return messages;
    }

    public void setMessages(List<String> messages) {
        this.messages = messages;
    }
}
