package com.Menu;

public class MenuInput {
    private Integer num;
    private String spec;
    private String date;
    private String policy;

    public MenuInput(Integer id, String spec, String date, String policy) {
        this.num = id;
        this.spec = spec;
        this.date = date;
        this.policy = policy;
    }

    public MenuInput() {
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
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
