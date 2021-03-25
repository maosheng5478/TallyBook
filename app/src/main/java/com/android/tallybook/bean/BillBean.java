package com.android.tallybook.bean;

public class BillBean {
    private Integer id;
    private String billname;
    private String cost;
    private String flow;

    private String time;
    private String remarks;

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }
    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBillname() {
        return billname;
    }

    public void setBillname(String billname) {
        this.billname = billname;
    }


    public String getFlow() {
        return flow;
    }

    public void setFlow(String flow) {
        this.flow = flow;
    }

    @Override
    public String toString() {
        return "BillBean{" +
                "id=" + id +
                ", billname='" + billname + '\'' +
                ", cost='" + cost + '\'' +
                ", flow='" + flow + '\'' +
                ", time='" + time + '\'' +
                ", remarks='" + remarks + '\'' +
                '}';
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
