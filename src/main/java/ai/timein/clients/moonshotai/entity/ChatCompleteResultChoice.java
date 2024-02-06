package ai.timein.clients.moonshotai.entity;

public class ChatCompleteResultChoice {
    private int index;

    private MessageDTO message;

    private String finish_reason;

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public MessageDTO getMessage() {
        return message;
    }

    public void setMessage(MessageDTO message) {
        this.message = message;
    }

    public String getFinish_reason() {
        return finish_reason;
    }

    public void setFinish_reason(String finish_reason) {
        this.finish_reason = finish_reason;
    }
}
