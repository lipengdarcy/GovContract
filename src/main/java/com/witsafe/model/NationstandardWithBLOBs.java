package com.witsafe.model;

public class NationstandardWithBLOBs extends Nationstandard {
    private String validRange;

    private String standardnoReplace;

    public String getValidRange() {
        return validRange;
    }

    public void setValidRange(String validRange) {
        this.validRange = validRange == null ? null : validRange.trim();
    }

    public String getStandardnoReplace() {
        return standardnoReplace;
    }

    public void setStandardnoReplace(String standardnoReplace) {
        this.standardnoReplace = standardnoReplace == null ? null : standardnoReplace.trim();
    }
}