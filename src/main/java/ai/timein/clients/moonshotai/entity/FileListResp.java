package ai.timein.clients.moonshotai.entity;

import java.util.List;

public class FileListResp {
    List<FileInfoResp> data;

    public List<FileInfoResp> getData() {
        return data;
    }

    public void setData(List<FileInfoResp> data) {
        this.data = data;
    }
}
