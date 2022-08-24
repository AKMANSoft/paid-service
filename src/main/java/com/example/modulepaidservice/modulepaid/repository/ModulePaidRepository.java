package com.example.modulepaidservice.modulepaid.repository;


import com.example.modulepaidservice.modulepaid.model.JpaModulePaid;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ModulePaidRepository extends JpaRepository<JpaModulePaid, Long> {
}
