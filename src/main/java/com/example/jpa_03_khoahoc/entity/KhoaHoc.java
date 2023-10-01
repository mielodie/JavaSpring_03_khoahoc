package com.example.jpa_03_khoahoc.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "khoahoc")
public class KhoaHoc {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int khoaHocId;
    @Column(name = "tenkhoahoc")
    private String tenKhoaHoc;
    @Column(name = "mota")
    private String moTa;
    @Column(name = "hocphi")
    private double hocPhi;
    @Column(name = "ngaybatdau")
    private LocalDate ngayBatDau;
    @Column(name = "ngayketthuc")
    private LocalDate ngayKetThuc;
    @OneToMany(mappedBy = "khoaHoc")
    @JsonManagedReference
    private List<HocVien> hocViens;
    @OneToMany(mappedBy = "khoaHoc")
    @JsonManagedReference
    private List<NgayHoc> ngayHocs;

    public int getKhoaHocId() {
        return khoaHocId;
    }

    public void setKhoaHocId(int khoaHocId) {
        this.khoaHocId = khoaHocId;
    }

    public String getTenKhoaHoc() {
        return tenKhoaHoc;
    }

    public void setTenKhoaHoc(String tenKhoaHoc) {
        this.tenKhoaHoc = tenKhoaHoc;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public double getHocPhi() {
        return hocPhi;
    }

    public void setHocPhi(double hocPhi) {
        this.hocPhi = hocPhi;
    }

    public LocalDate getNgayBatDau() {
        return ngayBatDau;
    }

    public void setNgayBatDau(LocalDate ngayBatDau) {
        this.ngayBatDau = ngayBatDau;
    }

    public LocalDate getNgayKetThuc() {
        return ngayKetThuc;
    }

    public void setNgayKetThuc(LocalDate ngayKetThuc) {
        this.ngayKetThuc = ngayKetThuc;
    }

    public List<HocVien> getHocViens() {
        return hocViens;
    }

    public void setHocViens(List<HocVien> hocViens) {
        this.hocViens = hocViens;
    }

    public List<NgayHoc> getNgayHocs() {
        return ngayHocs;
    }

    public void setNgayHocs(List<NgayHoc> ngayHocs) {
        this.ngayHocs = ngayHocs;
    }
}
