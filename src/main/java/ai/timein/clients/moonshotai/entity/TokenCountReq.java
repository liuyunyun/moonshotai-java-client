package ai.timein.clients.moonshotai.entity;

import java.util.List;

public class TokenCountReq {
    private String model;
    private List<Message> messages;

    public static TokenCountReq create(String model, List<Message> messages) {
        TokenCountReq tokenCountReq = new TokenCountReq();
        tokenCountReq.setModel(model);
        tokenCountReq.setMessages(messages);
        return tokenCountReq;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }
}
