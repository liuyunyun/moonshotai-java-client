package ai.timein.clients.moonshotai;

import ai.timein.clients.moonshotai.constant.ApiUrls;
import ai.timein.clients.moonshotai.entity.ChatCompleteDTO;
import ai.timein.clients.moonshotai.entity.ChatCompleteResult;
import ai.timein.clients.moonshotai.uitl.HttpUtil;

public class MoonShotClient {
    private final String baseUrl;
    private final String[] headers;

    private MoonShotClient(String key, String baseUrl) {
        this.baseUrl = baseUrl;
        this.headers = new String[]{
                "Content-Type", "application/json",
                "Authorization", "Bearer " + key
        };
    }

    public static MoonShotClient create(String key, String baseUrl) {
        return new MoonShotClient(key, baseUrl);
    }

    public static MoonShotClient create(String key) {
        return new MoonShotClient(key, ApiUrls.DEFAULT_BASE);
    }

    public ChatCompleteResult chatComplete(String systemPrompt, String userPrompt) {
        ChatCompleteDTO dto = ChatCompleteDTO.create().addMessage(systemPrompt, userPrompt);
        return HttpUtil.request(baseUrl+ApiUrls.CHAT_COMPLETE, "POST",dto, ChatCompleteResult.class, headers);
    }
}
