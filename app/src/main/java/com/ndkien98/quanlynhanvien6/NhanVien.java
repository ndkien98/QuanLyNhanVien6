package com.ndkien98.quanlynhanvien6;

public class NhanVien {

    private int id;
    private String hoTen,username,password;
    private String diaChi;
    private String phongBan;
    private int namSinh;
    private int luong;
    private int quyen_id;

    public NhanVien(int id, String hoTen, String username, String password, String diaChi, String phongBan, int namSinh, int luong, int quyen_id) {
        this.id = id;
        this.hoTen = hoTen;
        this.username = username;
        this.password = password;
        this.diaChi = diaChi;
        this.phongBan = phongBan;
        this.namSinh = namSinh;
        this.luong = luong;
        this.quyen_id = quyen_id;
    }

    @Override
    public String toString() {
        return "NhanVien{" +
                "id=" + id +
                ", hoTen='" + hoTen + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", diaChi='" + diaChi + '\'' +
                ", phongBan='" + phongBan + '\'' +
                ", namSinh=" + namSinh +
                ", luong=" + luong +
                ", quyen_id=" + quyen_id +
                '}';
    }

    public NhanVien() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getPhongBan() {
        return phongBan;
    }

    public void setPhongBan(String phongBan) {
        this.phongBan = phongBan;
    }

    public int getNamSinh() {
        return namSinh;
    }

    public void setNamSinh(int namSinh) {
        this.namSinh = namSinh;
    }

    public int getLuong() {
        return luong;
    }

    public void setLuong(int luong) {
        this.luong = luong;
    }

    public int getQuyen_id() {
        return quyen_id;
    }

    public void setQuyen_id(int quyen_id) {
        this.quyen_id = quyen_id;
    }
}
