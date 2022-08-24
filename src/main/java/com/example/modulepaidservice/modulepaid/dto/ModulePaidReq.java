package com.example.modulepaidservice.modulepaid.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;


@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ModulePaidReq {

    String orderNo;

    String clientTin;

    String deviceNo;

    String link;

    String status;

}
