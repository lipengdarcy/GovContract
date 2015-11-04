package com.witsafe.model;

import java.util.Date;

public class SysParam {
    private Integer id;

    private String paramtypecode;

    private String paramtypename;

    private String paramfathertype;

    private String paramcode;

    private String paramname;

    private String paramvalue;

    private Date publishDate;

    private Boolean isvalid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getParamtypecode() {
        return paramtypecode;
    }

    public void setParamtypecode(String paramtypecode) {
        this.paramtypecode = paramtypecode == null ? null : paramtypecode.trim();
    }

    public String getParamtypename() {
        return paramtypename;
    }

    public void setParamtypename(String paramtypename) {
        this.paramtypename = paramtypename == null ? null : paramtypename.trim();
    }

    public String getParamfathertype() {
        return paramfathertype;
    }

    public void setParamfathertype(String paramfathertype) {
        this.paramfathertype = paramfathertype == null ? null : paramfathertype.trim();
    }

    public String getParamcode() {
        return paramcode;
    }

    public void setParamcode(String paramcode) {
        this.paramcode = paramcode == null ? null : paramcode.trim();
    }

    public String getParamname() {
        return paramname;
    }

    public void setParamname(String paramname) {
        this.paramname = paramname == null ? null : paramname.trim();
    }

    public String getParamvalue() {
        return paramvalue;
    }

    public void setParamvalue(String paramvalue) {
        this.paramvalue = paramvalue == null ? null : paramvalue.trim();
    }

    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }

    public Boolean getIsvalid() {
        return isvalid;
    }

    public void setIsvalid(Boolean isvalid) {
        this.isvalid = isvalid;
    }
}