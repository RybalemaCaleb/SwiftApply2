package com.example.rcaleb.swiftapply;

import org.json.JSONArray;

public class StatusDataHolder {
    private String name;
    private int img;
    private String sex;
    private String Date;
    private String Class_to_go_to;
    private String Term_to_go_to;
    private String parent_name;
    private String parent_no;
    private String district_name;
    private String village_name;
    private JSONArray marks;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public String getClass_to_go_to() {
        return Class_to_go_to;
    }

    public void setClass_to_go_to(String class_to_go_to) {
        Class_to_go_to = class_to_go_to;
    }

    public String getTerm_to_go_to() {
        return Term_to_go_to;
    }

    public void setTerm_to_go_to(String term_to_go_to) {
        Term_to_go_to = term_to_go_to;
    }

    public String getParent_name() {
        return parent_name;
    }

    public void setParent_name(String parent_name) {
        this.parent_name = parent_name;
    }

    public String getParent_no() {
        return parent_no;
    }

    public void setParent_no(String parent_no) {
        this.parent_no = parent_no;
    }

    public String getDistrict_name() {
        return district_name;
    }

    public void setDistrict_name(String district_name) {
        this.district_name = district_name;
    }

    public String getVillage_name() {
        return village_name;
    }

    public void setVillage_name(String village_name) {
        this.village_name = village_name;
    }

    public JSONArray getMarks() {
        return marks;
    }

    public void setMarks(JSONArray marks) {
        this.marks = marks;
    }
}
