package ai.timein.clients.moonshotai.uitl;

import ai.timein.clients.moonshotai.err.ClientException;
import okhttp3.*;

abstract public class HttpUtil {
    private final static OkHttpClient client = new OkHttpClient();

    public static<T> T request(String url, String method, Object requestObj, Class<T> clazz, String... headersNamesAndValues){
        Request request = new Request.Builder()
            .url(url)
            .headers(Headers.of(headersNamesAndValues))
            .method(method, requestObj==null?null:RequestBody.create(JsonUtil.toJson(requestObj), MediaType.parse("application/json")))
            .build();
        try (Response response = client.newCall(request).execute()) {
            return JsonUtil.fromJson(checkResponse(response),clazz);
        } catch (ClientException ce){
            throw ce;
        } catch (Exception e) {
            throw new ClientException("Unknown err",e);
        }
    }

    private static String checkResponse(Response response) {
        if (response.isSuccessful()) {
            if(response.body()==null){
                throw new ClientException("Response body is null");
            }else{
                try(ResponseBody body = response.body()){
                    return body.string();
                }catch (Exception e){
                    throw new ClientException("Error reading response body",e);
                }
            }
        } else if(response.code()==401) {
            throw new ClientException("Unauthorized");
        } else if (response.code() == 400) {
            throw new ClientException("Bad request");
        } else if (response.code() == 429) {
            throw new ClientException("Too many requests");
        } else{
            throw new ClientException("Error response code: "+response.code());
        }
    }
}
