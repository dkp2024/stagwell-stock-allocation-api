package com.stagwell.stagwellapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ValidateUserDto implements Serializable {
    private  String email;
    private  String []  roles;

}
