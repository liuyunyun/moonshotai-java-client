package ai.timein.clients.moonshotai.constant;

public interface ApiUrls {
    String BASE="https://api.moonshot.cn";

    String CHAT_COMPLETE = BASE + "/v1/chat/completions";

    String LIST_MODELS = BASE + "/v1/models";

    String TOKEN_COUNT = BASE + "/v1/tokenizers/estimate-token-count";
}
