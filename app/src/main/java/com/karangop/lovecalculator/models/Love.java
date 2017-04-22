package com.karangop.lovecalculator.models;

import java.io.Serializable;

public class Love implements Serializable {
    private String result;
    private String fname;
    private String sname;
    private String percentage;

    public Love(String result, String fname, String sname, String percentage) {
        this.result = result;
        this.fname = fname;
        this.sname = sname;
        this.percentage = percentage;
    }

    public Love() {
    }

    public String getResult() {
        return this.result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getFname() {
        return this.fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getSname() {
        return this.sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getPercentage() {
        return this.percentage;
    }

    public void setPercentage(String percentage) {
        this.percentage = percentage;
    }
}
