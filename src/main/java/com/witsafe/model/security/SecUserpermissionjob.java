package com.witsafe.model.security;

import java.util.Date;

public class SecUserpermissionjob {
    private Integer id;

    private Integer userpermissionid;

    private Date createtime;

    private Date expiretime;

    private Date updatetime;

    private Byte status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserpermissionid() {
        return userpermissionid;
    }

    public void setUserpermissionid(Integer userpermissionid) {
        this.userpermissionid = userpermissionid;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Date getExpiretime() {
        return expiretime;
    }

    public void setExpiretime(Date expiretime) {
        this.expiretime = expiretime;
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }
}