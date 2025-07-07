package com.example.case_study.service;

import com.example.case_study.model.ThuongHieu;

import java.util.List;

public interface IThuongHieuService {
     List<ThuongHieu> findAll();
     ThuongHieu findById(Integer id);
     ThuongHieu save(ThuongHieu thuongHieu);
     void deleteById(Integer id);
}
