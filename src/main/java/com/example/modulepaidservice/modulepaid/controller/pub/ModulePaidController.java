package com.example.modulepaidservice.modulepaid.controller.pub;

import com.example.modulepaidservice.modulepaid.dto.ModulePaidReq;
import com.example.modulepaidservice.modulepaid.response.ModulePaidRes;
import com.example.modulepaidservice.modulepaid.service.ModulePaidService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/public/module-paid")
@RequiredArgsConstructor
public class ModulePaidController {

    private final ModulePaidService modulePaidService;

    @PostMapping
    public ResponseEntity<ModulePaidRes> query(@RequestBody @Validated ModulePaidReq req) {
        return new ResponseEntity<>(modulePaidService.create(req), HttpStatus.OK);
    }

    @GetMapping("/{clientTin}")
    public ResponseEntity<ModulePaidRes> get(@PathVariable String clientTin) {
        return new ResponseEntity<>(modulePaidService.get(clientTin), HttpStatus.OK);
    }

}
