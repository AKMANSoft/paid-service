package com.example.modulepaidservice.modulepaid.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@Builder
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
