package com.example.jpa_03_khoahoc.service.interfaceservice;

import com.example.jpa_03_khoahoc.entity.HocVien;
import com.example.jpa_03_khoahoc.entity.NgayHoc;
import com.example.jpa_03_khoahoc.payload.dto.HocVienDTO;
import com.example.jpa_03_khoahoc.payload.dto.KhoaHocDTO;
import com.example.jpa_03_khoahoc.payload.dto.NgayHocDTO;
import com.example.jpa_03_khoahoc.payload.request.HocVienRequest;
import com.example.jpa_03_khoahoc.payload.request.NgayHocRequest;
import com.example.jpa_03_khoahoc.payload.response.ResponseObject;

import java.util.List;

public interface iKhoaHocService {
    public ResponseObject<NgayHocDTO> themNgayHoc(int khoaHocID, NgayHocRequest request);

    public ResponseObject<HocVienDTO> suaThongTinHocVien(int hocVienID, HocVienRequest request);

    public ResponseObject<KhoaHocDTO> xoaKhoaHoc(int khoaHocID);

    public List<HocVien> layHocVien(String tenHocVien, int khoaHocID);

    public List<String> tinhDoanhThu();
}
