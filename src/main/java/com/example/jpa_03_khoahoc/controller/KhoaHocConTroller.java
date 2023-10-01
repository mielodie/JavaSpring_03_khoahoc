package com.example.jpa_03_khoahoc.controller;

import com.example.jpa_03_khoahoc.entity.HocVien;
import com.example.jpa_03_khoahoc.payload.dto.HocVienDTO;
import com.example.jpa_03_khoahoc.payload.dto.KhoaHocDTO;
import com.example.jpa_03_khoahoc.payload.dto.NgayHocDTO;
import com.example.jpa_03_khoahoc.payload.request.HocVienRequest;
import com.example.jpa_03_khoahoc.payload.request.NgayHocRequest;
import com.example.jpa_03_khoahoc.payload.response.ResponseObject;
import com.example.jpa_03_khoahoc.service.KhoaHocService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class KhoaHocConTroller {
    @Autowired
    private KhoaHocService khoaHocService;

    @RequestMapping(value = "themngayhoc", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseObject<NgayHocDTO> themNgayHoc(@RequestParam int khoaHocID, @RequestBody NgayHocRequest request) {
        return khoaHocService.themNgayHoc(khoaHocID, request);
    }

    @RequestMapping(value = "suathongtinhocvien", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseObject<HocVienDTO> suaThongTinHocVien(@RequestParam int hocVienID, @RequestBody HocVienRequest request) {
        return khoaHocService.suaThongTinHocVien(hocVienID, request);
    }

    @RequestMapping(value = "xoakhoahoc", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseObject<KhoaHocDTO> xoaKhoaHoc(@RequestParam int khoaHocID) {
        return khoaHocService.xoaKhoaHoc(khoaHocID);
    }

    @RequestMapping(value = "layhocvien", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<HocVien> layHocVien(@RequestParam String tenHocVien, @RequestParam int khoaHocID) {
        return khoaHocService.layHocVien(tenHocVien, khoaHocID);
    }

    @RequestMapping(value = "tinhdoanhthu", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<String> tinhDoanhThu() {
        return khoaHocService.tinhDoanhThu();
    }
}
