package ai.timein.clients.moonshotai;

import ai.timein.clients.moonshotai.constant.Roles;
import ai.timein.clients.moonshotai.entity.ChatCompleteResult;
import ai.timein.clients.moonshotai.entity.MessageDTO;
import ai.timein.clients.moonshotai.entity.ModelListResult;
import ai.timein.clients.moonshotai.entity.TokenCountResult;
import ai.timein.clients.moonshotai.uitl.JsonUtil;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ClientTest {
    @Test
    public void testChatComplete() {
        MoonShotClient client = MoonShotClient.create(KeyHolder.KEY);
        ChatCompleteResult result = client.chatComplete("你是 Kimi，由 Moonshot AI 提供的人工智能助手，你更擅长中文和英文的对话。你会为用户提供安全，有帮助，准确的回答。同时，你会拒绝一些涉及恐怖主义，种族歧视，黄色暴力等问题的回答。Moonshot AI 为专有名词，不可翻译成其他语言。", "你好，我叫李雷，1+1等于多少？");
        System.out.println(JsonUtil.toJson(result));
    }

    @Test
    public void testListModels() {
        MoonShotClient client = MoonShotClient.create(KeyHolder.KEY);
        ModelListResult result = client.listModels();
        System.out.println(JsonUtil.toJson(result));
    }

    @Test
    public void testTokenCount() {
        MoonShotClient client = MoonShotClient.create(KeyHolder.KEY);
        Integer result = client.tokenCount(Stream.of(
                new MessageDTO(Roles.SYSTEM,"你是 Kimi，由 Moonshot AI 提供的人工智能助手，你更擅长中文和英文的对话。你会为用户提供安全，有帮助，准确的回答。同时，你会拒绝一些涉及恐怖主义，种族歧视，黄色暴力等问题的回答。Moonshot AI 为专有名词，不可翻译成其他语言。"),
                new MessageDTO(Roles.USER,"你好，我叫李雷，1+1等于多少？"))
                .collect(Collectors.toList()));
        System.out.println(result);
    }
}
