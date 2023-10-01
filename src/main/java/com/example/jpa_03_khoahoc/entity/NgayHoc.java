package com.example.jpa_03_khoahoc.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import org.hibernate.annotations.Comment;

@Entity
@Table(name = "ngayhoc")
public class NgayHoc {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int ngayHocId;
    @ManyToOne
    @JoinColumn(name = "khoahocid", insertable = false, updatable = false)
    @JsonBackReference
    private KhoaHoc khoaHoc;
    @Column(name = "khoahocid")
    private int khoaHocId;
    @Column(name = "noidung")
    private String noiDung;
    @Column(name = "ghichu")
    private String ghiChu;

    public int getNgayHocId() {
        return ngayHocId;
    }

    public void setNgayHocId(int ngayHocId) {
        this.ngayHocId = ngayHocId;
    }

    public KhoaHoc getKhoaHoc() {
        return khoaHoc;
    }

    public void setKhoaHoc(KhoaHoc khoaHoc) {
        this.khoaHoc = khoaHoc;
    }

    public int getKhoaHocId() {
        return khoaHocId;
    }

    public void setKhoaHocId(int khoaHocId) {
        this.khoaHocId = khoaHocId;
    }

    public String getNoiDung() {
        return noiDung;
    }

    public void setNoiDung(String noiDung) {
        this.noiDung = noiDung;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }
}
