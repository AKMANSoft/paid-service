package com.example.modulepaidservice.modulepaid.service;

import com.example.modulepaidservice.modulepaid.dto.ModulePaidReq;
import com.example.modulepaidservice.modulepaid.response.ModulePaidRes;

public interface ModulePaidService {

    ModulePaidRes create(ModulePaidReq req);

}
