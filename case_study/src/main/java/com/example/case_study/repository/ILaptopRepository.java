package com.example.case_study.repository;

import com.example.case_study.model.Laptop;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ILaptopRepository extends JpaRepository<Laptop, Long> {

    Page<Laptop> findByTenLaptopContainingIgnoreCase(String tenLaptop, Pageable pageable);

    @Query("SELECT l FROM Laptop l WHERE " +
            "(:tenLaptop IS NULL OR LOWER(l.tenLaptop) LIKE LOWER(CONCAT('%', :tenLaptop, '%'))) AND " +
            "(:thuongHieuId IS NULL OR l.thuongHieu.idThuongHieu = :thuongHieuId)")
    Page<Laptop> filterByTenLaptopAndThuongHieu(@Param("tenLaptop") String tenLaptop,
                                                @Param("thuongHieuId") Integer thuongHieuId,
                                                Pageable pageable);

}
