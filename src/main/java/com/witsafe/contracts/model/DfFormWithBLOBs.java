package com.witsafe.contracts.model;

public class DfFormWithBLOBs extends DfForm {
    private String originalHtml;

    private String parseHtml;

    public String getOriginalHtml() {
        return originalHtml;
    }

    public void setOriginalHtml(String originalHtml) {
        this.originalHtml = originalHtml == null ? null : originalHtml.trim();
    }

    public String getParseHtml() {
        return parseHtml;
    }

    public void setParseHtml(String parseHtml) {
        this.parseHtml = parseHtml == null ? null : parseHtml.trim();
    }
}