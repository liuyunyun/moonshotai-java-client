package ai.timein.clients.moonshotai;

import ai.timein.clients.moonshotai.constant.ApiUrls;
import ai.timein.clients.moonshotai.constant.Constant;
import ai.timein.clients.moonshotai.constant.Models;
import ai.timein.clients.moonshotai.entity.*;
import ai.timein.clients.moonshotai.entity.ModelListResult;
import ai.timein.clients.moonshotai.err.ClientException;
import ai.timein.clients.moonshotai.uitl.HttpUtil;
import ai.timein.clients.moonshotai.uitl.JsonUtil;

import java.util.List;

/**
 * MoonShot AI 的Java Client
 *
 * 代码地址：https://github.com/liuyunyun/moonshotai-java-client
 * 参照MoonShot AI的接口文档：https://moonshotai.com/docs
 *
 * 需自行注册用户、申请key
 * 将key通过配置文件在项目中使用，并传入MoonShotClient.create(key)方法中
 *
 * @author liuyunyun
 * @date 2024/2/6
 */
public class MoonShotClient {
    private final String baseUrl;
    private final String model;
    private final String[] headers;

    private MoonShotClient(String model, String key, String baseUrl) {
        this.baseUrl = baseUrl;
        this.model = model;
        this.headers = new String[]{
                "Content-Type", "application/json",
                "Authorization", "Bearer " + key
        };
    }

    public static MoonShotClient create(String model, String key, String baseUrl) {
        return new MoonShotClient(model, key, baseUrl);
    }

    /**
     * 典型情况下使用本方法，使用默认的baseUrl
     * @param key
     * @return
     */
    public static MoonShotClient create(String key) {
        return new MoonShotClient(Models.moonshot_v1_8k, key, ApiUrls.DEFAULT_BASE);
    }

    /**
     * 对话接口
     * @param systemPrompt
     * @param userPrompt
     * @return
     */
    public ChatCompleteResult chatComplete(String systemPrompt, String userPrompt) {
        ChatCompleteDTO dto = ChatCompleteDTO.create(model, Constant.TEMPERATURE).addMessage(systemPrompt, userPrompt);
        return HttpUtil.request(baseUrl+ApiUrls.CHAT_COMPLETE, "POST",dto, ChatCompleteResult.class, headers);
    }

    /**
     * 列出模型接口
     * @return
     */
    public ModelListResult listModels() {
        return HttpUtil.request(baseUrl+ApiUrls.LIST_MODELS, "GET", null, ModelListResult.class, headers);
    }

    public Integer tokenCount(List<MessageDTO> messages) {
        TokenCountDTO dto = TokenCountDTO.create(model, messages);
        TokenCountResult result= HttpUtil.request(baseUrl+ApiUrls.TOKEN_COUNT, "POST", dto, TokenCountResult.class, headers);
        if(result != null && result.getCode()==0 && result.getStatus() && result.getData()!=null && result.getData().getTotal_tokens()!=null){
            return result.getData().getTotal_tokens();
        }else{
            throw new ClientException("tokenCount error:"+ JsonUtil.toJson(result));
        }
    }
}
