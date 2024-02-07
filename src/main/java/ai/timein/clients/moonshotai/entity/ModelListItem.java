package ai.timein.clients.moonshotai.entity;

import java.util.List;

public class ModelListItem {
    private Long created;
    private String id;
    private String object;
    private String owned_by;
    private List<ModelListPermission> permission;
    private String root;
    private String parent;

    public Long getCreated() {
        return created;
    }

    public void setCreated(Long created) {
        this.created = created;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getObject() {
        return object;
    }

    public void setObject(String object) {
        this.object = object;
    }

    public String getOwned_by() {
        return owned_by;
    }

    public void setOwned_by(String owned_by) {
        this.owned_by = owned_by;
    }

    public List<ModelListPermission> getPermission() {
        return permission;
    }

    public void setPermission(List<ModelListPermission> permission) {
        this.permission = permission;
    }

    public String getRoot() {
        return root;
    }

    public void setRoot(String root) {
        this.root = root;
    }

    public String getParent() {
        return parent;
    }

    public void setParent(String parent) {
        this.parent = parent;
    }
}
