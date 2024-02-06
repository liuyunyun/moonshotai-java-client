package ai.timein.clients.moonshotai.entity;

import ai.timein.clients.moonshotai.constant.Constant;

public class MessageDTO {
    private String role;
    private String content;

    public static MessageDTO createSystemRole(String content) {
        return new MessageDTO(Constant.ROLE_SYSTEM, content);
    }

    public static MessageDTO createUserRole(String content) {
        return new MessageDTO(Constant.ROLE_USER, content);
    }

    public MessageDTO() {
    }

    public MessageDTO(String role, String content) {
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
