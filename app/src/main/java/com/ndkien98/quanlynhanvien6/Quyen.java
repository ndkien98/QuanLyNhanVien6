package com.ndkien98.quanlynhanvien6;

public class Quyen {

    private int id;
    private String name;

    public Quyen(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Quyen() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
