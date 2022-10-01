package com.microservices.userservice.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(generator = "uuid-string")
    @GenericGenerator(
            name = "uuid-string",
            strategy = "org.hibernate.id.UUIDGenerator")
    private String id;
    private String firstName;
    private String lastName;
    private String username;
    private String departmentId;
}
