package com.example.modulepaidservice.modulepaid.controller.pri;

import com.example.modulepaidservice.modulepaid.dto.ModulePaidSearchReq;
import com.example.modulepaidservice.modulepaid.response.ModulePaidRes;
import com.example.modulepaidservice.modulepaid.service.ModulePaidService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/private/module-paid")
@RequiredArgsConstructor
public class ModulePaidSearchController {

    private final ModulePaidService modulePaidService;

    @GetMapping("/search")
    public ResponseEntity<Page<ModulePaidRes>> search(ModulePaidSearchReq req,
                                                      @RequestParam(defaultValue = "0") Integer pageNo,
                                                      @RequestParam(defaultValue = "20") Integer pageSize,
                                                      @RequestParam(defaultValue = "created_date") String sort) {

        return new ResponseEntity<>(modulePaidService.search(req, pageNo, pageSize, sort), HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<ModulePaidRes> update(@PathVariable Long id,
                                                @RequestParam String status) {
        return new ResponseEntity<>(modulePaidService.update(id, status), HttpStatus.OK);
    }

}
