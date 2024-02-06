package ai.timein.clients.moonshotai;

import ai.timein.clients.moonshotai.constant.Constant;
import ai.timein.clients.moonshotai.entity.ChatCompleteDTO;
import ai.timein.clients.moonshotai.entity.ChatCompleteResult;
import ai.timein.clients.moonshotai.uitl.HttpUtil;

public class MoonShotClient {
    private final String key;
    private final String url;
    private MoonShotClient(String key, String url) {
        this.key = key;
        this.url = url;
    }

    public static MoonShotClient create(String key, String url) {
        return new MoonShotClient(key, url);
    }

    public static MoonShotClient create(String key) {
        return new MoonShotClient(key, Constant.API_URL);
    }

    public ChatCompleteResult chatComplete(String systemPrompt, String userPrompt) {
        ChatCompleteDTO dto = ChatCompleteDTO.create().addMessage(systemPrompt, userPrompt);
        return HttpUtil.post(url, dto, ChatCompleteResult.class, "Content-Type", "application/json", "Authorization", "Bearer " + key);
    }
}
