package com.example.modulepaidservice.modulepaid.response;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.Instant;


@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class ModulePaidRes {

    Long id;

    String orderNo;

    String clientTin;

    String deviceNo;

    String link;

    String date;

    Instant createdDate;

    Instant lastModifiedDate;

    String status;

}
