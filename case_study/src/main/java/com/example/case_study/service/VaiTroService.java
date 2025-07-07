package com.example.case_study.service;

import com.example.case_study.model.VaiTro;
import com.example.case_study.repository.VaiTroRepository;
import com.example.case_study.service.IVaiTroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VaiTroService implements IVaiTroService {

    @Autowired
    private VaiTroRepository vaiTroRepository;

    @Override
    public List<VaiTro> findAll() {
        return vaiTroRepository.findAll();
    }

    @Override
    public Optional<VaiTro> findById(Integer id) {
        return vaiTroRepository.findById(id);
    }

    @Override
    public VaiTro save(VaiTro vaiTro) {
        return vaiTroRepository.save(vaiTro);
    }

    @Override
    public void deleteById(Integer id) {
        vaiTroRepository.deleteById(id);
    }
}
