package com.witsafe.contracts.model;

public class ConfDictitem {
    private Integer id;

    private String code;

    private String description;

    private String name;

    private Integer orderby;

    private Integer dictionary;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getOrderby() {
        return orderby;
    }

    public void setOrderby(Integer orderby) {
        this.orderby = orderby;
    }

    public Integer getDictionary() {
        return dictionary;
    }

    public void setDictionary(Integer dictionary) {
        this.dictionary = dictionary;
    }
}