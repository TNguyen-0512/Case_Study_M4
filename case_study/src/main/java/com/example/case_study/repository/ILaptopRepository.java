package com.example.case_study.repository;

import com.example.case_study.model.Laptop;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;

public interface ILaptopRepository extends JpaRepository<Laptop, Long> {

    Page<Laptop> findByTenLaptopContainingIgnoreCase(String tenLaptop, Pageable pageable);

    // Tìm theo tên thương hiệu (dựa trên entity ThuongHieu)
    Page<Laptop> findByThuongHieu_TenThuongHieuContainingIgnoreCase(String tenThuongHieu, Pageable pageable);

    // Tìm theo tên laptop và tên thương hiệu
    Page<Laptop> findByTenLaptopContainingIgnoreCaseAndThuongHieu_TenThuongHieuContainingIgnoreCase(
            String tenLaptop, String tenThuongHieu, Pageable pageable);
    @Query("SELECT l FROM Laptop l WHERE " +
            "(:tenLaptop IS NULL OR LOWER(l.tenLaptop) LIKE LOWER(CONCAT('%', :tenLaptop, '%'))) AND " +
            "(:thuongHieuId IS NULL OR l.thuongHieu.idThuongHieu = :thuongHieuId) AND " +
            "(:giaMin IS NULL OR l.giaBan >= :giaMin) AND " +
            "(:giaMax IS NULL OR l.giaBan <= :giaMax) AND " +
            "(:cpu IS NULL OR l.cpu LIKE %:cpu%) AND " +
            "(:ram IS NULL OR l.ram LIKE %:ram%) AND " +
            "(:oCung IS NULL OR l.oCung LIKE %:oCung%)")
    Page<Laptop> filterLaptops(@Param("tenLaptop") String tenLaptop,
                               @Param("thuongHieuId") Integer thuongHieuId,
                               @Param("giaMin") BigDecimal giaMin,
                               @Param("giaMax") BigDecimal giaMax,
                               @Param("cpu") String cpu,
                               @Param("ram") String ram,
                               @Param("oCung") String oCung,
                               Pageable pageable);


}

