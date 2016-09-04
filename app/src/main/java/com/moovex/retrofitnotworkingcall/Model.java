package com.moovex.retrofitnotworkingcall;

/**
 * Created by roy on 9/4/2016.
 */

public class Model {

    private long date;
    private String status;
    private String user;

    public Model() {
    }

    public Model(long date, String status, String user) {

        this.date = date;
        this.status = status;
        this.user = user;
    }

    public long getDate() {
        return date;
    }

    public void setDate(long date) {
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Model{" +
                "date=" + date +
                ", status='" + status + '\'' +
                ", user='" + user + '\'' +
                '}';
    }
}
