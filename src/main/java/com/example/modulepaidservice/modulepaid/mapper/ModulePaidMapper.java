package com.example.modulepaidservice.modulepaid.mapper;


import com.example.modulepaidservice.modulepaid.dto.ModulePaidReq;
import com.example.modulepaidservice.modulepaid.model.JpaModulePaid;
import com.example.modulepaidservice.modulepaid.response.ModulePaidRes;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ModulePaidMapper {
    JpaModulePaid fromReq(ModulePaidReq modulePaidReq);

    ModulePaidRes fromJpa(JpaModulePaid jpaModulePaid);
}
