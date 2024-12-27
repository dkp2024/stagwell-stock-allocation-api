/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.stagwell.stagwellapp.dto.EmployeeDto
 *  com.stagwell.stagwellapp.service.EmployeeService
 *  org.springframework.beans.factory.annotation.Autowired
 *  org.springframework.web.bind.annotation.PostMapping
 *  org.springframework.web.bind.annotation.RequestAttribute
 *  org.springframework.web.bind.annotation.RequestBody
 *  org.springframework.web.bind.annotation.RequestMapping
 *  org.springframework.web.bind.annotation.RestController
 */
package com.stagwell.stagwellapp.controller;

import com.stagwell.stagwellapp.Constants;
import com.stagwell.stagwellapp.dto.EmployeeDto;
import com.stagwell.stagwellapp.service.EmployeeService;
import java.util.List;
import java.util.Map;

import com.stagwell.stagwellapp.util.CookieUtils;
import com.stagwell.stagwellapp.util.ValidateCookie;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value={"employee"})
@Slf4j
public class EmployeeStageController {
    @Autowired
    EmployeeService employeeService;

    @RequestMapping(value={"list"})
    public List<EmployeeDto> getListOfEmployeesByEntity(HttpServletRequest request) throws Exception {
        log.info("getListOfEntitiesByAgency(-) in");
        Map<String,String> map= CookieUtils.getCookie(request, Constants.COOKIENAME);
        if(!ValidateCookie.validateCookies(map,new String[]{"userId"})){
            throw new Exception("User session is not validated, Please login again!");
        }
        String userId= map.get("userId");
        log.info("userId: {}",userId);
        return this.employeeService.getEmployeeByEntity(userId);
    }

    @PostMapping(value={"save"})
    public void saveEmployees(@RequestBody List<EmployeeDto> employeeDtoList) {
        log.info("saveEmployees(-) in");
        this.employeeService.saveEmployees(employeeDtoList);
    }
}
