package com.example.jpa_03_khoahoc.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "hocvien")
public class HocVien {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int hocVienID;
    @ManyToOne
    @JoinColumn(name = "khoahocid", insertable = false, updatable = false)
    @JsonBackReference
    private KhoaHoc khoaHoc;
    @Column(name = "khoahocid")
    private int khoaHocID;
    @Column(name = "hoten")
    private String hoTen;
    @Column(name = "ngaysinh")
    private LocalDate ngaySinh;
    @Column(name = "quequan")
    private String queQuan;
    @Column(name = "diachi")
    private String diaChi;
    @Column(name = "sodienthoai")
    private String soDienThoai;

    public int getHocVienID() {
        return hocVienID;
    }

    public void setHocVienID(int hocVienID) {
        this.hocVienID = hocVienID;
    }

    public KhoaHoc getKhoaHoc() {
        return khoaHoc;
    }

    public void setKhoaHoc(KhoaHoc khoaHoc) {
        this.khoaHoc = khoaHoc;
    }

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
