package com.microservices.userservice.VO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class Department {

    private String id;
    private String name;
    private String address;
    private String code;
}
