package ai.timein.clients.moonshotai.uitl;

import ai.timein.clients.moonshotai.constant.Purposes;
import ai.timein.clients.moonshotai.err.ClientException;
import okhttp3.*;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

abstract public class HttpUtil {
    private final static OkHttpClient client = new OkHttpClient().newBuilder().connectTimeout(30, TimeUnit.SECONDS).readTimeout(30, TimeUnit.SECONDS).build();

    public static<T> T requestJson(String url, String method, Object requestObj, Class<T> clazz, Map<String,String> authHeaders){
        Map<String,String> headers = new HashMap<>(authHeaders);
        headers.put("Content-Type","application/json");
        Request request = new Request.Builder()
            .url(url)
            .headers(Headers.of(headers))
            .method(method, requestObj==null?null:RequestBody.create(JsonUtil.toJson(requestObj), MediaType.parse("application/json")))
            .build();
        try (Response response = client.newCall(request).execute()) {
            String str=checkResponse(response);
            return clazz.isAssignableFrom(String.class)?(T)str:JsonUtil.fromJson(str,clazz);
        } catch (ClientException ce){
            throw ce;
        } catch (Exception e) {
            throw new ClientException("Unknown err",e);
        }
    }

    public static<T> T uploadFile(String url, String localPath, String remoteFileName, String fileContentType, Class<T> clazz, Map<String,String> authHeaders){
        Map<String,String> headers = new HashMap<>(authHeaders);
        headers.put("Content-Type","multipart/form-data");

        RequestBody requestBody = new MultipartBody.Builder()
                .setType(MultipartBody.FORM)
                .addFormDataPart("purpose", Purposes.FILE_EXTRACT)
                .addFormDataPart("file", remoteFileName,
                        RequestBody.create(MediaType.parse(fileContentType), new File(localPath)))
                .build();

        Request request = new Request.Builder()
            .url(url)
            .headers(Headers.of(headers))
            .post(requestBody)
            .build();
        try (Response response = client.newCall(request).execute()) {
            String str=checkResponse(response);
            return clazz.isAssignableFrom(String.class)?(T)str:JsonUtil.fromJson(str,clazz);
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
