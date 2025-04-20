package com.ithema.pojo;

// pojo是用来放实体类的

public class T {
    private String name;
    private String tnum;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTnum() {
        return tnum;
    }

    public void setTnum(String tnum) {
        this.tnum = tnum;
    }

    @Override
    public String toString() {
        return "T{" +
                "name='" + name + '\'' +
                ", tnum='" + tnum + '\'' +
                '}' + '\n';
    }
}
