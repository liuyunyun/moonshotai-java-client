package ai.timein.clients.moonshotai.entity;

import java.util.List;

public class ModelListResp {
    private List<ModelListRespItem> data;

    public List<ModelListRespItem> getData() {
        return data;
    }

    public void setData(List<ModelListRespItem> data) {
        this.data = data;
    }
}
