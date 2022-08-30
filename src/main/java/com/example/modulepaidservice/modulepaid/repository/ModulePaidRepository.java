package com.example.modulepaidservice.modulepaid.repository;


import com.example.modulepaidservice.modulepaid.model.JpaModulePaid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ModulePaidRepository extends JpaRepository<JpaModulePaid, Long> {

    Optional<JpaModulePaid> findFirstByClientTin(String clientTin);


    @Query("SELECT a FROM module_paid as a " +
            " WHERE (:orderNo IS NULL OR a.orderNo = :orderNo)" +
            " AND (:clientTin IS NULL OR a.clientTin = :clientTin)" +
            " AND (:deviceNo IS NULL OR a.deviceNo = :deviceNo)" +
            " AND (:link IS NULL OR a.link = :link)" +
            " AND (:date IS NULL OR a.date = :date)" +
            " AND (:status IS NULL OR a.status = :status)")
    Page<JpaModulePaid> search(
            @Param("orderNo") String orderNo,
            @Param("clientTin") String clientTin,
            @Param("deviceNo") String deviceNo,
            @Param("link") String link,
            @Param("status") String status,
            @Param("date") String date,
            Pageable pageable);
}
