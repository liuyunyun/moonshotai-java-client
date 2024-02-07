package ai.timein.clients.moonshotai.entity;

import java.util.List;

public class ChatCompleteResp {
    private String id;
    private String object;
    private String created;
    private String model;

    private List<ChatCompleteRespChoice> choices;

    private ChatCompleteRespUsage usage;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getObject() {
        return object;
    }

    public void setObject(String object) {
        this.object = object;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public List<ChatCompleteRespChoice> getChoices() {
        return choices;
    }

    public void setChoices(List<ChatCompleteRespChoice> choices) {
        this.choices = choices;
    }

    public ChatCompleteRespUsage getUsage() {
        return usage;
    }

    public void setUsage(ChatCompleteRespUsage usage) {
        this.usage = usage;
    }
}
