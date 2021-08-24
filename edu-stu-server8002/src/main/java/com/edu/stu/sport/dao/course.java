package com.edu.stu.sport.dao;

import lombok.Data;


public class course {
    private int id;
    private String c_name;
    private String c_nianji;
    private int status;
    public int getC_id() {
        return id;
    }

    public void setC_id(int c_id) {
        this.id = c_id;
    }

    public String getC_name() {
        return c_name;
    }

    public void setC_name(String c_name) {
        this.c_name = c_name;
    }

    public String getC_nianji() {
        return c_nianji;
    }

    public void setC_nianji(String c_nianji) {
        this.c_nianji = c_nianji;
    }

    public int getC_status() {
        return status;
    }

    public void setC_status(int c_status) {
        this.status = c_status;
    }


}
