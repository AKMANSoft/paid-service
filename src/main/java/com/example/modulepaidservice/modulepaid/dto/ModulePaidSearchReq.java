package com.example.modulepaidservice.modulepaid.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.validation.constraints.NotBlank;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ModulePaidSearchReq {

    String orderNo;

    String clientTin;

    String deviceNo;

    String link;

    String status;

    String date;

}
