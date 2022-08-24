package com.example.modulepaidservice.modulepaid.service.impl;

import com.example.modulepaidservice.modulepaid.dto.ModulePaidReq;
import com.example.modulepaidservice.modulepaid.exception.ApplicationException;
import com.example.modulepaidservice.modulepaid.mapper.ModulePaidMapper;
import com.example.modulepaidservice.modulepaid.repository.ModulePaidRepository;
import com.example.modulepaidservice.modulepaid.response.ModulePaidRes;
import com.example.modulepaidservice.modulepaid.service.ModulePaidService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import static com.example.modulepaidservice.modulepaid.exception.BusinessErrorCode.ModulePaidErrorCode.MODULE_PAID_CREATE_ERROR;

@Service
@Slf4j
public class ModulePaidServiceImpl implements ModulePaidService {

//    private ModulePaidMapper mapper;
//    private ModulePaidRepository modulePaidRepository;
//    public ModulePaidServiceImpl(ModulePaidMapper mapper,
//                                 ModulePaidRepository modulePaidRepository){
//        this.mapper = mapper;
//        this.modulePaidRepository = modulePaidRepository;
//    }

    @Override
    public ModulePaidRes create(ModulePaidReq req) {
        try{
//            return mapper.fromJpa(modulePaidRepository.save(mapper.fromReq(req)));
            return null;
        }catch (Exception e){
            log.error("[ModulePaidServiceImpl] Create module paid error: {}",e.getMessage());
            throw new ApplicationException(MODULE_PAID_CREATE_ERROR, e.getMessage());
        }
    }
}
