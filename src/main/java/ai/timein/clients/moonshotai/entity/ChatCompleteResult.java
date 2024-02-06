package ai.timein.clients.moonshotai.entity;

import java.util.List;

public class ChatCompleteResult {
    private String id;
    private String object;
    private String created;
    private String model;

    private List<ChatCompleteResultChoice> choices;

    private ChatCompleteResultUsage usage;

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

    public List<ChatCompleteResultChoice> getChoices() {
        return choices;
    }

    public void setChoices(List<ChatCompleteResultChoice> choices) {
        this.choices = choices;
    }

    public ChatCompleteResultUsage getUsage() {
        return usage;
    }

    public void setUsage(ChatCompleteResultUsage usage) {
        this.usage = usage;
    }
}
