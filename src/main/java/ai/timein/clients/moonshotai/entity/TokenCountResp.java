package ai.timein.clients.moonshotai.entity;

public class TokenCountResp {
    private Integer code;
    private TokenCountRespData data;
    private String scode;
    private Boolean status;

    public TokenCountRespData getData() {
        return data;
    }

    public void setData(TokenCountRespData data) {
        this.data = data;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getScode() {
        return scode;
    }

    public void setScode(String scode) {
        this.scode = scode;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
}
