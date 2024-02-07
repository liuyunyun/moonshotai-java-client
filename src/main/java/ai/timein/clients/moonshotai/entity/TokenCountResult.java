package ai.timein.clients.moonshotai.entity;

public class TokenCountResult {
    private Integer code;
    private TokenCountData data;
    private String scode;
    private Boolean status;

    public TokenCountData getData() {
        return data;
    }

    public void setData(TokenCountData data) {
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
