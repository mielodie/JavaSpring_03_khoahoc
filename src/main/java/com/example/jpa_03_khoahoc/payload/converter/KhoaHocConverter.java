package com.example.jpa_03_khoahoc.payload.converter;

import com.example.jpa_03_khoahoc.entity.HocVien;
import com.example.jpa_03_khoahoc.entity.KhoaHoc;
import com.example.jpa_03_khoahoc.entity.NgayHoc;
import com.example.jpa_03_khoahoc.payload.dto.HocVienDTO;
import com.example.jpa_03_khoahoc.payload.dto.KhoaHocDTO;
import com.example.jpa_03_khoahoc.payload.dto.NgayHocDTO;
import com.example.jpa_03_khoahoc.payload.request.HocVienRequest;
import com.example.jpa_03_khoahoc.payload.request.NgayHocRequest;

public class KhoaHocConverter {
    public HocVienDTO entityToHocVienDTO(HocVien hocVien){
        HocVienDTO dto = new HocVienDTO();
        dto.setDiaChi(hocVien.getDiaChi());
        dto.setHoTen(hocVien.getHoTen());
        dto.setNgaySinh(hocVien.getNgaySinh());
        dto.setQueQuan(hocVien.getQueQuan());
        dto.setDiaChi(hocVien.getDiaChi());
        dto.setSoDienThoai(hocVien.getSoDienThoai());
        return dto;
    }
    public KhoaHocDTO entityToKhoaHocDTO(KhoaHoc khoaHoc){
        KhoaHocDTO dto = new KhoaHocDTO();
        dto.setTenKhoaHoc(khoaHoc.getTenKhoaHoc());
        dto.setHocPhi(khoaHoc.getHocPhi());
        dto.setMoTa(khoaHoc.getMoTa());
        dto.setNgayBatDau(khoaHoc.getNgayBatDau());
        dto.setNgayKetThuc(khoaHoc.getNgayKetThuc());
        return dto;
    }
    public NgayHocDTO entityToNgayHocDTO(NgayHoc ngayHoc){
        NgayHocDTO dto = new NgayHocDTO();
        dto.setGhiChu(ngayHoc.getGhiChu());
        dto.setNoiDung(ngayHoc.getNoiDung());
        return dto;
    }
    public NgayHoc themNgayHoc(NgayHocRequest request){
        NgayHoc ngayHoc = new NgayHoc();
        ngayHoc.setGhiChu(request.getGhiChu());
        ngayHoc.setNoiDung(request.getNoiDung());
        return ngayHoc;
    }
    public HocVien suaHocVien(HocVien hocVien, HocVienRequest request){
        hocVien.setHoTen(request.getHoTen());
        hocVien.setQueQuan(request.getQueQuan());
        hocVien.setDiaChi(request.getDiaChi());
        hocVien.setSoDienThoai(request.getSoDienThoai());
        hocVien.setNgaySinh(request.getNgaySinh());
        return hocVien;
    }
}
