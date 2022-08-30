package com.example.modulepaidservice.modulepaid.service.impl;

import com.example.modulepaidservice.modulepaid.dto.ModulePaidReq;
import com.example.modulepaidservice.modulepaid.dto.ModulePaidSearchReq;
import com.example.modulepaidservice.modulepaid.dto.ModulePaidUpdateReq;
import com.example.modulepaidservice.modulepaid.enums.Status;
import com.example.modulepaidservice.modulepaid.exception.ApplicationException;
import com.example.modulepaidservice.modulepaid.model.JpaModulePaid;
import com.example.modulepaidservice.modulepaid.repository.ModulePaidRepository;
import com.example.modulepaidservice.modulepaid.response.ModulePaidRes;
import com.example.modulepaidservice.modulepaid.service.ModulePaidService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static com.example.modulepaidservice.modulepaid.exception.BusinessErrorCode.ModulePaidErrorCode.*;

@Service
@Slf4j
@AllArgsConstructor
public class ModulePaidServiceImpl implements ModulePaidService {

    private final ObjectMapper mapper;
    private final ModulePaidRepository modulePaidRepository;


    @Override
    public ModulePaidRes create(ModulePaidReq req) {
        try{
            log.info("[ModulePaidServiceImpl] Start create module paid with clientTin: {}", req.getClientTin());
            var jpaModuleOpt = modulePaidRepository.findFirstByClientTin(req.getClientTin());
            if(jpaModuleOpt.isPresent()){
                throw new ApplicationException(MODULE_PAID_CLIENT_TIN_EXISTED);
            }
            JpaModulePaid jpaModulePaid = mapper.readValue(mapper.writeValueAsString(req), JpaModulePaid.class);
            if(StringUtils.isBlank(req.getStatus())){
                jpaModulePaid.setStatus(Status.PENDING.toString());
            }
            DateFormat df = new SimpleDateFormat("MM-dd-yyyy");
            jpaModulePaid.setDate(df.format(new Date()));
            jpaModulePaid = modulePaidRepository.save(jpaModulePaid);
            return mapper.readValue(mapper.writeValueAsString(jpaModulePaid), ModulePaidRes.class);
        }catch (Exception e){
            log.error("[ModulePaidServiceImpl] Create module paid error: {}",e.getMessage());
            throw new ApplicationException(MODULE_PAID_CREATE_ERROR, e.getMessage());
        }
    }

    @Override
    public ModulePaidRes get(String clientTin) {
        try{
            log.info("[ModulePaidServiceImpl] Start get module paid with clientTin: {}", clientTin);
            var jpaModuleOpt = modulePaidRepository.findFirstByClientTin(clientTin);
            if(jpaModuleOpt.isEmpty()){
                throw new ApplicationException(MODULE_PAID_NOT_FOUND_ERROR);
            }
            var jpaModulePaid = jpaModuleOpt.get();
            var res =  mapper.readValue(mapper.writeValueAsString(jpaModulePaid), ModulePaidRes.class);
            res.setCreatedDate(jpaModulePaid.getCreatedDate());
            res.setLastModifiedDate(jpaModulePaid.getLastModifiedDate());
            return res;
        }catch (Exception e){
            log.error("[ModulePaidServiceImpl] Get module paid error: {}",e.getMessage());
            throw new ApplicationException(MODULE_PAID_GET_ERROR, e.getMessage());
        }
    }

    @Override
    public Page<ModulePaidRes> search(ModulePaidSearchReq req, Integer pageNo, Integer pageSize, String sort, String sortDir) {
        try{
            pageNo = (Objects.nonNull(pageNo) && pageNo > 0) ? pageNo - 1 : 0;

            Pageable paging = "DESC".equalsIgnoreCase(sortDir) ? PageRequest.of(pageNo, pageSize, Sort.by(sort).descending()) : PageRequest.of(pageNo, pageSize, Sort.by(sort).ascending());
            Page<JpaModulePaid> jpaModulePaidPage = modulePaidRepository.search(
                    req.getOrderNo(),
                    req.getClientTin(),
                    req.getDeviceNo(),
                    req.getLink(),
                    req.getStatus(),
                    req.getDate()
                    , paging);

            List<ModulePaidRes> res = jpaModulePaidPage.getContent().stream().map(m -> {
                return ModulePaidRes.builder()
                        .id(m.getId())
                        .orderNo(m.getOrderNo())
                        .clientTin(m.getClientTin())
                        .deviceNo(m.getDeviceNo())
                        .link(m.getLink())
                        .status(m.getStatus())
                        .date(m.getDate())
                        .createdDate(m.getCreatedDate())
                        .lastModifiedDate(m.getLastModifiedDate())
                        .build();
            }).collect(Collectors.toList());
            return new PageImpl<>(res, paging,
                    jpaModulePaidPage.getTotalElements());
        }catch (Exception e){
            log.error("[ModulePaidServiceImpl] Search module paid error: {}",e.getMessage());
            throw new ApplicationException(MODULE_PAID_SEARCH_ERROR, e.getMessage());
        }
    }

    @Override
    public ModulePaidRes update(ModulePaidUpdateReq req) {
        try{
            log.info("[ModulePaidServiceImpl] Start Update module paid with id: {}", req.getId());
            var jpaModuleOpt = modulePaidRepository.findById(req.getId());
            if(jpaModuleOpt.isEmpty()){
                throw new ApplicationException(MODULE_PAID_NOT_FOUND_ERROR);
            }
            JpaModulePaid jpaModulePaid = jpaModuleOpt.get();
            jpaModulePaid.setStatus(req.getStatus());
            jpaModulePaid = modulePaidRepository.save(jpaModulePaid);
            return mapper.readValue(mapper.writeValueAsString(jpaModulePaid), ModulePaidRes.class);
        }catch (Exception e){
            log.error("[ModulePaidServiceImpl] Update module paid error: {}",e.getMessage());
            throw new ApplicationException(MODULE_PAID_SEARCH_ERROR, e.getMessage());
        }
    }

    @Override
    public ModulePaidRes get(Long id) {
        try {
            var jpaModuleOpt = modulePaidRepository.findById(id);
            if (jpaModuleOpt.isEmpty()) {
                throw new ApplicationException(MODULE_PAID_NOT_FOUND_ERROR);
            }
            JpaModulePaid jpaModulePaid = jpaModuleOpt.get();
            return mapper.readValue(mapper.writeValueAsString(jpaModulePaid), ModulePaidRes.class);
        } catch (Exception e) {
            log.error("[ModulePaidServiceImpl] Update module paid error: {}", e.getMessage());
            throw new ApplicationException(MODULE_PAID_SEARCH_ERROR, e.getMessage());
        }
    }
}
