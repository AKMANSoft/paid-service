package com.example.modulepaidservice.modulepaid.service;

import com.example.modulepaidservice.modulepaid.dto.ModulePaidReq;
import com.example.modulepaidservice.modulepaid.dto.ModulePaidSearchReq;
import com.example.modulepaidservice.modulepaid.dto.ModulePaidUpdateReq;
import com.example.modulepaidservice.modulepaid.response.ModulePaidRes;
import org.springframework.data.domain.Page;

public interface ModulePaidService {

    ModulePaidRes create(ModulePaidReq req);

    ModulePaidRes get(String clientTin);

    Page<ModulePaidRes> search(ModulePaidSearchReq req, Integer pageNo, Integer pageSize, String sort, String sortDir);

    ModulePaidRes update(ModulePaidUpdateReq req);

    ModulePaidRes get(Long id);
}
