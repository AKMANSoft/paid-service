package com.example.modulepaidservice.modulepaid.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.validation.constraints.NotBlank;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ModulePaidReq {

    @NotBlank
    String orderNo;

    @NotBlank
    String clientTin;

    @NotBlank
    String deviceNo;

    @NotBlank
    String link;

    String status;

}
