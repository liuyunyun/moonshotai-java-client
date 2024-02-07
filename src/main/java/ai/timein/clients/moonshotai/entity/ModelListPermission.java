package ai.timein.clients.moonshotai.entity;

public class ModelListPermission {
    private Long created;
    private String id;
    private String object;
    private Boolean allow_create_engine;
    private Boolean allow_sampling;
    private Boolean allow_logprobs;
    private Boolean allow_search_indices;
    private Boolean allow_view;
    private Boolean allow_fine_tuning;
    private String organization;
    private String group;
    private Boolean is_blocking;

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

    public Boolean getAllow_create_engine() {
        return allow_create_engine;
    }

    public void setAllow_create_engine(Boolean allow_create_engine) {
        this.allow_create_engine = allow_create_engine;
    }

    public Boolean getAllow_sampling() {
        return allow_sampling;
    }

    public void setAllow_sampling(Boolean allow_sampling) {
        this.allow_sampling = allow_sampling;
    }

    public Boolean getAllow_logprobs() {
        return allow_logprobs;
    }

    public void setAllow_logprobs(Boolean allow_logprobs) {
        this.allow_logprobs = allow_logprobs;
    }

    public Boolean getAllow_search_indices() {
        return allow_search_indices;
    }

    public void setAllow_search_indices(Boolean allow_search_indices) {
        this.allow_search_indices = allow_search_indices;
    }

    public Boolean getAllow_view() {
        return allow_view;
    }

    public void setAllow_view(Boolean allow_view) {
        this.allow_view = allow_view;
    }

    public Boolean getAllow_fine_tuning() {
        return allow_fine_tuning;
    }

    public void setAllow_fine_tuning(Boolean allow_fine_tuning) {
        this.allow_fine_tuning = allow_fine_tuning;
    }

    public String getOrganization() {
        return organization;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public Boolean getIs_blocking() {
        return is_blocking;
    }

    public void setIs_blocking(Boolean is_blocking) {
        this.is_blocking = is_blocking;
    }
}
