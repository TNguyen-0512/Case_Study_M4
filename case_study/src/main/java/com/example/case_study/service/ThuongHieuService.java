package com.example.case_study.service;

import com.example.case_study.model.ThuongHieu;
import com.example.case_study.repository.IThuongHieuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ThuongHieuService implements IThuongHieuService {
    @Autowired
    private IThuongHieuRepository thuongHieuRepository;
    @Override
    public List<ThuongHieu> findAll() {
        return thuongHieuRepository.findAll();
    }

    @Override
    public ThuongHieu findById(Integer id) {
        return thuongHieuRepository.findById(id).orElse(null);
    }

    @Override
    public ThuongHieu save(ThuongHieu thuongHieu) {
        return thuongHieuRepository.save(thuongHieu);
    }

    @Override
    public void deleteById(Integer id) {
        thuongHieuRepository.deleteById(id);
    }
}
