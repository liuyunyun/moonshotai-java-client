package ai.timein.clients.moonshotai.entity;

import ai.timein.clients.moonshotai.constant.Constant;

import java.util.ArrayList;
import java.util.List;


public class ChatCompleteDTO {
    private String model;
    private List<MessageDTO> messages;
    private double temperature;

    public static ChatCompleteDTO create(double temperature) {
        ChatCompleteDTO dto= new ChatCompleteDTO();
        dto.setModel(Constant.MODEL);
        dto.setTemperature(temperature);
        return dto;
    }

    public static ChatCompleteDTO create() {
        return create(Constant.TEMPERATURE);
    }

    public ChatCompleteDTO() {
        messages = new ArrayList<>();
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

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public ChatCompleteDTO addMessage(String systemPrompt, String userPrompt) {
        this.messages.add(MessageDTO.createSystemRole(systemPrompt));
        this.messages.add(MessageDTO.createUserRole(userPrompt));
        return this;
    }
}
