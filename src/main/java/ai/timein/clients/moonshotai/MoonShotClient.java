package ai.timein.clients.moonshotai;

import ai.timein.clients.moonshotai.constant.ApiUrls;
import ai.timein.clients.moonshotai.constant.Constant;
import ai.timein.clients.moonshotai.constant.Models;
import ai.timein.clients.moonshotai.entity.*;
import ai.timein.clients.moonshotai.entity.ModelListResp;
import ai.timein.clients.moonshotai.err.ClientException;
import ai.timein.clients.moonshotai.uitl.HttpUtil;
import ai.timein.clients.moonshotai.uitl.JsonUtil;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * MoonShot AI 的Java Client
 *
 * 代码地址：<a href="https://github.com/liuyunyun/moonshotai-java-client">...</a>
 * 参照MoonShot AI的接口文档：<a href="https://moonshotai.com/docs">...</a>
 *
 * 需自行注册用户、申请key
 * 将key通过配置文件在项目中使用，并传入MoonShotClient.create(key)方法中
 *
 * @author liuyunyun
 *  2024/2/6
 */
public class MoonShotClient {
    private final String baseUrl;
    private final String model;
    private final Map<String,String> authHeaders;

    private MoonShotClient(String model, String key, String baseUrl) {
        this.baseUrl = baseUrl;
        this.model = model;
        this.authHeaders = new HashMap<String,String>() {{
                put("Authorization", "Bearer " + key);
        }};
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
    public ChatCompleteResp chatComplete(String systemPrompt, String userPrompt) {
        ChatCompleteReq dto = ChatCompleteReq.create(model, Constant.TEMPERATURE).addMessage(systemPrompt, userPrompt);
        return HttpUtil.requestJson(baseUrl+ApiUrls.CHAT_COMPLETE, "POST",dto, ChatCompleteResp.class, authHeaders);
    }

    /**
     * 列出模型接口
     * @return
     */
    public ModelListResp listModels() {
        return HttpUtil.requestJson(baseUrl+ApiUrls.LIST_MODELS, "GET", null, ModelListResp.class, authHeaders);
    }

    public Integer tokenCount(List<Message> messages) {
        TokenCountReq dto = TokenCountReq.create(model, messages);
        TokenCountResp result= HttpUtil.requestJson(baseUrl+ApiUrls.TOKEN_COUNT, "POST", dto, TokenCountResp.class, authHeaders);
        if(result != null && result.getCode()==0 && result.getStatus() && result.getData()!=null && result.getData().getTotal_tokens()!=null){
            return result.getData().getTotal_tokens();
        }else{
            throw new ClientException("tokenCount error:"+ JsonUtil.toJson(result));
        }
    }

    public FileInfoResp uploadFile(String localPath, String remoteFileName, String fileContentType){
        return HttpUtil.uploadFile(baseUrl+ApiUrls.FILES, localPath, remoteFileName, fileContentType, FileInfoResp.class, authHeaders);
    }

    public FileListResp listFiles(){
        return HttpUtil.requestJson(baseUrl+ApiUrls.FILES, "GET", null, FileListResp.class, authHeaders);
    }

    public FileInfoResp getFileInfo(String fileId){
        return HttpUtil.requestJson(String.format(baseUrl+ApiUrls.FILES_ID, fileId), "GET", null, FileInfoResp.class, authHeaders);
    }

    public boolean deleteFile(String fileId){
        FileDelResp resp= HttpUtil.requestJson(String.format(baseUrl+ApiUrls.FILES_ID, fileId), "DELETE", null, FileDelResp.class, authHeaders);
        return resp!=null && resp.getDeleted();
    }

    public FileContentResp getFileContent(String fileId){
        return HttpUtil.requestJson(String.format(baseUrl+ApiUrls.FILES_ID_CONTENT, fileId), "GET", null, FileContentResp.class, authHeaders);
    }
}
