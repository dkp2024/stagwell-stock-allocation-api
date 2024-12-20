package com.stagwell.stagwellapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserLeastInfoDto {
    private  Integer userId;
    private  String userType;
    private  String userName;

}
