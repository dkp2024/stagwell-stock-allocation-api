package com.stagwell.stagwellapp.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.core.SpringVersion;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class APIResponse {
    private  String message;
    private  String statusCode;
}
