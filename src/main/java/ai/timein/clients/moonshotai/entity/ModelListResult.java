package ai.timein.clients.moonshotai.entity;

import java.util.List;

public class ModelListResult {
    private List<ModelListItem> data;

    public List<ModelListItem> getData() {
        return data;
    }

    public void setData(List<ModelListItem> data) {
        this.data = data;
    }
}
