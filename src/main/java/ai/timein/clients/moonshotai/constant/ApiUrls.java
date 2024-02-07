package ai.timein.clients.moonshotai.constant;

public interface ApiUrls {
    String DEFAULT_BASE="https://api.moonshot.cn/v1";

    String CHAT_COMPLETE = "/chat/completions";

    String LIST_MODELS = "/models";

    String TOKEN_COUNT = "/tokenizers/estimate-token-count";
}
