package com.example.sf900jdbctemp.dao.model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private Long id;
    private String username;
    private String email;
    private String firstname;
    private String lastname;
    private String phonenumber;
    private String picurl;

}