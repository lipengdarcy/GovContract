package com.witsafe.contracts.model;

import java.io.Serializable;

public class Organization implements Serializable{


	/**
	 * 
	 */
	private static final long serialVersionUID = 189483894154439695L;

	private Integer id;

    private Integer pid;

    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }
}