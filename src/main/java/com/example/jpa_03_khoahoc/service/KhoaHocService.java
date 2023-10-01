package com.example.jpa_03_khoahoc.service;

import com.example.jpa_03_khoahoc.entity.HocVien;
import com.example.jpa_03_khoahoc.entity.KhoaHoc;
import com.example.jpa_03_khoahoc.entity.NgayHoc;
import com.example.jpa_03_khoahoc.payload.converter.KhoaHocConverter;
import com.example.jpa_03_khoahoc.payload.dto.HocVienDTO;
import com.example.jpa_03_khoahoc.payload.dto.KhoaHocDTO;
import com.example.jpa_03_khoahoc.payload.dto.NgayHocDTO;
import com.example.jpa_03_khoahoc.payload.request.HocVienRequest;
import com.example.jpa_03_khoahoc.payload.request.NgayHocRequest;
import com.example.jpa_03_khoahoc.payload.response.ResponseObject;
import com.example.jpa_03_khoahoc.repository.HocVienRepository;
import com.example.jpa_03_khoahoc.repository.KhoaHocRepository;
import com.example.jpa_03_khoahoc.repository.NgayHocRepository;
import com.example.jpa_03_khoahoc.service.interfaceservice.iKhoaHocService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.net.HttpURLConnection;
import java.time.Duration;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class KhoaHocService implements iKhoaHocService {
    @Autowired
    private HocVienRepository hocVienRepository;
    @Autowired
    private KhoaHocRepository khoaHocRepository;
    @Autowired
    private NgayHocRepository ngayHocRepository;

    public KhoaHocConverter _khoaHocConverter;

    public ResponseObject<NgayHocDTO> _ngayHocResponseObject;
    public ResponseObject<KhoaHocDTO> _khoaHocResponseObject;
    public ResponseObject<HocVienDTO> _hocVienResponseObject;
    public KhoaHocService(){
        _hocVienResponseObject = new ResponseObject<HocVienDTO>();
    }

    private static int layKhoangThoiGian(LocalDate ld1, LocalDate ld2) {
        Period khoangThoiGian = Period.between(ld1, ld2);
        int days = Math.abs(khoangThoiGian.getDays());
        return days;
    }

    public ResponseObject<NgayHocDTO> themNgayHoc(int khoaHocID, NgayHocRequest request)
    {
        var khoaHoc = khoaHocRepository.findById(khoaHocID);
        if (khoaHoc.isEmpty()) {
            return _ngayHocResponseObject.responseError(HttpURLConnection.HTTP_NOT_FOUND, "Khoa hoc khong ton tai", null);
        }
        else {
            if (layKhoangThoiGian(khoaHoc.get().getNgayBatDau(), khoaHoc.get().getNgayKetThuc()) >= 15) {
                return _ngayHocResponseObject.responseError(HttpURLConnection.HTTP_BAD_REQUEST, "Khoa hoc chi toi da la 15 ngay hoc", null);
            } else {
                NgayHoc ngayHoc = new NgayHoc();
                ngayHoc.setKhoaHoc(khoaHoc.get());
                ngayHoc.setNoiDung(request.getNoiDung());
                ngayHoc.setGhiChu(request.getGhiChu());
                ngayHocRepository.save(ngayHoc);
                return _ngayHocResponseObject.responseSuccess("Them ngay hoc thanh cong", _khoaHocConverter.entityToNgayHocDTO(ngayHoc));
            }
        }
    }

    public ResponseObject<HocVienDTO> suaThongTinHocVien(int hocVienID, HocVienRequest request) {
        var checkHocVien = hocVienRepository.findById(hocVienID);
        if (checkHocVien.isPresent()) {
            return _hocVienResponseObject.responseError(HttpURLConnection.HTTP_BAD_REQUEST, "Hoc vien khong ton tai", null);
        } else {
            HocVien hocVien = _khoaHocConverter.suaHocVien(checkHocVien.get(), request);
            hocVien.setKhoaHocID(request.getKhoaHocID());
            hocVienRepository.save(hocVien);
            return _hocVienResponseObject.responseSuccess("Sua thong tin hoc vien thanh cong", _khoaHocConverter.entityToHocVienDTO(hocVien));
        }
    }

    public ResponseObject<KhoaHocDTO> xoaKhoaHoc(int khoaHocID) {
        var checkKhoaHoc = khoaHocRepository.findById(khoaHocID);
        if (checkKhoaHoc.isPresent()) {
            return _khoaHocResponseObject.responseError(HttpURLConnection.HTTP_BAD_REQUEST, "Khoa hoc khong ton tai", null);
        } else {
            khoaHocRepository.delete(checkKhoaHoc.get());
            return _khoaHocResponseObject.responseSuccess("Xoa khoa hoc thanh cong", _khoaHocConverter.entityToKhoaHocDTO(checkKhoaHoc.get()));
        }
    }

    public List<HocVien> layHocVien(String tenHocVien, int khoaHocID) {
        return hocVienRepository.findAll().stream()
                .filter(x -> x.getHoTen().trim().toLowerCase().contains(tenHocVien.trim().toLowerCase()) && x.getKhoaHocID() == khoaHocID)
                .toList();
    }

    private int demSoLuongHocVien(int khoaHocID) {
        return (int) hocVienRepository.findAll().stream().count();
    }

    public List<String> tinhDoanhThu() {
        var listKhoaHoc = khoaHocRepository.findAll();
        List<String> list = new ArrayList<>();
        double doanhThu = 0;
        Map<Integer, List<KhoaHoc>> groupByMonth = listKhoaHoc.stream().collect(Collectors.groupingBy(khoaHoc -> khoaHoc.getNgayBatDau().getMonthValue()));
        for (Map.Entry<Integer, List<KhoaHoc>> entry : groupByMonth.entrySet()) {
            int monthValue = entry.getKey();
            List<KhoaHoc> khoaHocList = entry.getValue();

            doanhThu = 0;

            for (KhoaHoc khoaHoc : khoaHocList) {
                int soHocVien = demSoLuongHocVien(khoaHoc.getKhoaHocId());
                doanhThu += soHocVien * khoaHoc.getHocPhi();
            }
            list.add("Thang " + monthValue + "co doanh thu la: " + doanhThu);
        }
        return list;
    }
}
