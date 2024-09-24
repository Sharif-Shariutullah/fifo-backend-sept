package com.example.fifotech.dto;

import com.example.fifotech.enums.UserRole;
import lombok.Data;

@Data
public class UserDto {

private Long id;
private String email;
private  String name;
private UserRole userRole;


}
