package com.example.modulepaidservice.modulepaid.model;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@Getter
@Setter
@Entity(name = "module_paid")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class JpaModulePaid extends BaseModel{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    String orderNo;

    String clientTin;

    String deviceNo;

    String link;

    String status;

}
