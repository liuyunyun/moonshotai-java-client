package ai.timein.clients.moonshotai.uitl;

import okhttp3.*;

import java.io.IOException;

abstract public class HttpUtil {
    private final static OkHttpClient client = new OkHttpClient();

    public static String get(String url){
        Request request = new Request.Builder()
            .url(url)
            .build();
        try (Response response = client.newCall(request).execute()) {
            return response.body().string();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static<T> T post(String url, Object requestObj, Class<T> clazz, String... headersNamesAndValues){
        Request request = new Request.Builder()
            .url(url)
            .headers(Headers.of(headersNamesAndValues))
            .post(RequestBody.create(JsonUtil.toJson(requestObj), MediaType.parse("application/json")))
            .build();
        try (Response response = client.newCall(request).execute()) {
            return JsonUtil.fromJson(response.body().string(),clazz);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
