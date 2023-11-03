package com.example.sf400contactmanager.dao.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Contact {
    private Long id;
    private String firstname;
    private  String lastname;
    private String phonenumber;
    private String email;
}
