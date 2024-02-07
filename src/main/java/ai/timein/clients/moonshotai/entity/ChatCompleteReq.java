package ai.timein.clients.moonshotai.entity;

import ai.timein.clients.moonshotai.constant.Models;

import java.util.ArrayList;
import java.util.List;


public class ChatCompleteReq {
    /**
     * Model ID, 可以通过 List Models 获取
     * 目前是 moonshot-v1-8k,moonshot-v1-32k,moonshot-v1-128k 其一
     * @see Models
     */
    private String model;
    /**
     * 包含迄今为止对话的消息列表。
     */
    private List<Message> messages;
    /**
     * 聊天完成时生成的最大 token 数。如果到生成了最大 token 数个结果仍然没有结束，finish reason 会是 “length”, 否则会是 “stop”
     *
     * 这个值建议按需给个合理的值，如果不给的话，我们会给一个不错的整数比如 1024。特别要注意的是，这个 max_tokens 是指您期待我们返回的 token 长度，
     * 而不是输入 + 输出的总长度。比如对一个 moonshot-v1-8k 模型，它的最大输入 + 输出总长度是 8192，当输入 messages 总长度为 4096 的时候，
     * 您最多只能设置为 4096，否则我们服务会返回不合法的输入参数（ invalid_request_error ），并拒绝回答。如果您希望获得“输入的精确 token 数”，
     * 可以使用下面的“计算 Token” API 使用我们的计算器获得计数。
     */
    private Integer max_tokens;
    /**
     * 使用什么采样温度，介于 0 和 1 之间。较高的值（如 0.7）将使输出更加随机，而较低的值（如 0.2）将使其更加集中和确定性。
     *
     * 如果设置，值域须为 [0, 1] 我们推荐 0.3，以达到较合适的效果。
     */
    private Float temperature;
    /**
     * 另一种采样温度
     * 默认 1.0
     */
    private Float top_p;
    /**
     * 为每条输入消息生成多少个结果
     *
     * 默认 1，不得大于 5 特别的，当 temperature 非常小靠近 0 的时候，我们只能返回 1 个结果，如果这个时候 n 设置并 > 1，
     * 我们服务会返回不合法的输入参数（ invalid_request_error ）。
     */
    private Integer n;
    /**
     * 是否流式返回
     * 默认 false, 可选 true
     */
    private Boolean stream;

    public static ChatCompleteReq create(String model, Float temperature) {
        ChatCompleteReq dto= new ChatCompleteReq();
        dto.setModel(model);
        dto.setTemperature(temperature);
        return dto;
    }

    public ChatCompleteReq() {
        messages = new ArrayList<>();
        stream=false;
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

    public Float getTemperature() {
        return temperature;
    }

    public void setTemperature(Float temperature) {
        this.temperature = temperature;
    }

    public Integer getMax_tokens() {
        return max_tokens;
    }

    public void setMax_tokens(Integer max_tokens) {
        this.max_tokens = max_tokens;
    }

    public Float getTop_p() {
        return top_p;
    }

    public void setTop_p(Float top_p) {
        this.top_p = top_p;
    }

    public Integer getN() {
        return n;
    }

    public void setN(Integer n) {
        this.n = n;
    }

    public Boolean getStream() {
        return stream;
    }

    public void setStream(Boolean stream) {
        this.stream = stream;
    }

    public ChatCompleteReq addMessage(String systemPrompt, String userPrompt) {
        this.messages.add(Message.createSystemRole(systemPrompt));
        this.messages.add(Message.createUserRole(userPrompt));
        return this;
    }
}
