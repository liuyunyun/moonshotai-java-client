package ai.timein.clients.moonshotai;

import ai.timein.clients.moonshotai.constant.Roles;
import ai.timein.clients.moonshotai.entity.*;
import ai.timein.clients.moonshotai.uitl.JsonUtil;
import org.junit.jupiter.api.Test;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ClientTest {
    @Test
    public void testChatComplete() {
        MoonShotClient client = MoonShotClient.create(KeyHolder.KEY);
        ChatCompleteResp result = client.chatComplete("你是 Kimi，由 Moonshot AI 提供的人工智能助手，你更擅长中文和英文的对话。你会为用户提供安全，有帮助，准确的回答。同时，你会拒绝一些涉及恐怖主义，种族歧视，黄色暴力等问题的回答。Moonshot AI 为专有名词，不可翻译成其他语言。", "你好，我叫李雷，1+1等于多少？");
        System.out.println(JsonUtil.toJson(result));
    }

    @Test
    public void testListModels() {
        MoonShotClient client = MoonShotClient.create(KeyHolder.KEY);
        ModelListResp result = client.listModels();
        System.out.println(JsonUtil.toJson(result));
    }

    @Test
    public void testTokenCount() {
        MoonShotClient client = MoonShotClient.create(KeyHolder.KEY);
        Integer result = client.tokenCount(Stream.of(
                new Message(Roles.SYSTEM,"你是 Kimi，由 Moonshot AI 提供的人工智能助手，你更擅长中文和英文的对话。你会为用户提供安全，有帮助，准确的回答。同时，你会拒绝一些涉及恐怖主义，种族歧视，黄色暴力等问题的回答。Moonshot AI 为专有名词，不可翻译成其他语言。"),
                new Message(Roles.USER,"你好，我叫李雷，1+1等于多少？"))
                .collect(Collectors.toList()));
        System.out.println(result);
    }

    @Test
    public void testUploadFile() {
        MoonShotClient client = MoonShotClient.create(KeyHolder.KEY);
        FileInfoResp result = client.uploadFile("D:/Documents/liuyunyun/lfs/LFS-BOOK-11.3.pdf", "LFS-BOOK.pdf","application/pdf");
        System.out.println(JsonUtil.toJson(result));
    }

    @Test
    public void testGetFileInfo() {
        MoonShotClient client = MoonShotClient.create(KeyHolder.KEY);
        FileInfoResp result = client.getFileInfo("cn1romqlnl9518554p30");
        System.out.println(JsonUtil.toJson(result));
    }

    @Test
    public void testListFiles() {
        MoonShotClient client = MoonShotClient.create(KeyHolder.KEY);
        FileListResp result = client.listFiles();
        System.out.println(JsonUtil.toJson(result));
    }

    @Test
    public void testDeleteFile() {
        MoonShotClient client = MoonShotClient.create(KeyHolder.KEY);
        boolean result = client.deleteFile("cn1rmfmcp7fedpl232a0");
        System.out.println(result);
    }

    @Test
    public void testGetFileContent() {
        MoonShotClient client = MoonShotClient.create(KeyHolder.KEY);
        FileContentResp result = client.getFileContent("cn1s0kecp7f6e2s951i0");
        System.out.println(JsonUtil.toJson(result));
    }

    @Test
    public void testChatFile() {
        MoonShotClient client = MoonShotClient.create(KeyHolder.KEY);
        FileContentResp contentResp = client.getFileContent("cn1s0kecp7f6e2s951i0");
        ChatCompleteResp result = client.chatComplete(contentResp.getContent().substring(0,10000), "这本书名字叫什么，请帮忙归纳一下主要内容大纲");
        System.out.println(JsonUtil.toJson(result));
    }
}
