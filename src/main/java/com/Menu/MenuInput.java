package com.Menu;

public class MenuInput {
    private String id;
    private String spec;
    private String date;
    private String policy;

    public MenuInput(String id, String spec, String date, String policy) {
        this.id = id;
        this.spec = spec;
        this.date = date;
        this.policy = policy;
    }

    public MenuInput() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        id = id;
    }

    public String getSpec() {
        return spec;
    }

    public void setSpec(String spec) {
        this.spec = spec;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getPolicy() {
        return policy;
    }

    public void setPolicy(String policy) {
        this.policy = policy;
    }
}
