package com.example.case_study.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "vai_tro")
@Getter
@Setter
public class VaiTro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_vai_tro")
    private Integer idVaiTro;

    @Column(name = "ten_vai_tro", length = 50, nullable = false, unique = true)
    private String tenVaiTro;
}

