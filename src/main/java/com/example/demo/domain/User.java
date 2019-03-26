package com.example.demo.domain;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection="user")
public class User {
private static final long serialVersionUID = 1L;
private String firstName;
private String lastName;
private String password;
private String address;
private String userName;

}
