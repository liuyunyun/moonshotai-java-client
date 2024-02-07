package ai.timein.clients.moonshotai.entity;

import ai.timein.clients.moonshotai.constant.Roles;

public class Message {
    private String role;
    private String content;

    public static Message createSystemRole(String content) {
        return new Message(Roles.SYSTEM, content);
    }

    public static Message createUserRole(String content) {
        return new Message(Roles.USER, content);
    }

    public Message() {
    }

    public Message(String role, String content) {
        this.role = role;
        this.content = content;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
