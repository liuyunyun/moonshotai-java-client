package ai.timein.clients.moonshotai.entity;

import ai.timein.clients.moonshotai.constant.Models;

import java.util.List;

public class TokenCountDTO {
    private String model;
    private List<MessageDTO> messages;

    public static TokenCountDTO create(String model, List<MessageDTO> messages) {
        TokenCountDTO tokenCountDTO = new TokenCountDTO();
        tokenCountDTO.setModel(model);
        tokenCountDTO.setMessages(messages);
        return tokenCountDTO;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public List<MessageDTO> getMessages() {
        return messages;
    }

    public void setMessages(List<MessageDTO> messages) {
        this.messages = messages;
    }
}
