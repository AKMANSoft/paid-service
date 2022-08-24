package com.example.modulepaidservice.modulepaid.response;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;


@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ModulePaidRes {

    Long id;

    String orderNo;

    String clientTin;

    String deviceNo;

    String link;

    String date;

    String status;

}
