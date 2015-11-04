package com.witsafe.model;

import java.util.Date;

public class Nationstandard {
    private Integer id;

    private String standardno;

    private String nameCh;

    private String nameEn;

    private Date publishDate;

    private Date effectDate;

    private String nameReplace;

    private String typeCh;

    private String typeIso;

    private String publisher;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStandardno() {
        return standardno;
    }

    public void setStandardno(String standardno) {
        this.standardno = standardno == null ? null : standardno.trim();
    }

    public String getNameCh() {
        return nameCh;
    }

    public void setNameCh(String nameCh) {
        this.nameCh = nameCh == null ? null : nameCh.trim();
    }

    public String getNameEn() {
        return nameEn;
    }

    public void setNameEn(String nameEn) {
        this.nameEn = nameEn == null ? null : nameEn.trim();
    }

    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }

    public Date getEffectDate() {
        return effectDate;
    }

    public void setEffectDate(Date effectDate) {
        this.effectDate = effectDate;
    }

    public String getNameReplace() {
        return nameReplace;
    }

    public void setNameReplace(String nameReplace) {
        this.nameReplace = nameReplace == null ? null : nameReplace.trim();
    }

    public String getTypeCh() {
        return typeCh;
    }

    public void setTypeCh(String typeCh) {
        this.typeCh = typeCh == null ? null : typeCh.trim();
    }

    public String getTypeIso() {
        return typeIso;
    }

    public void setTypeIso(String typeIso) {
        this.typeIso = typeIso == null ? null : typeIso.trim();
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher == null ? null : publisher.trim();
    }
}