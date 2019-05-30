package com.example.shymkomaksym.Model;

public class Model {

    private String message;
    private String date;
    private int type;
    public static final int ONE_TYPE = 1;
    public static final int TWO_TYPE = 2;
    public static final int THREE_TYPE = 3;

    public Model(String message, String date, int type) {
        this.message = message;
        this.date = date;
        this.type = type;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
