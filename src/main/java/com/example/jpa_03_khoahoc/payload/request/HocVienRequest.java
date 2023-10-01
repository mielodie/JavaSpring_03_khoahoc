package com.example.jpa_03_khoahoc.payload.request;

import java.time.LocalDate;

public class HocVienRequest {
    private int khoaHocID;
    private String hoTen;
    private LocalDate ngaySinh;
    private String queQuan;
    private String diaChi;
    private String soDienThoai;

    public int getKhoaHocID() {
        return khoaHocID;
    }

    public void setKhoaHocID(int khoaHocID) {
        this.khoaHocID = khoaHocID;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public LocalDate getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(LocalDate ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getQueQuan() {
        return queQuan;
    }

    public void setQueQuan(String queQuan) {
        this.queQuan = queQuan;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }
}
