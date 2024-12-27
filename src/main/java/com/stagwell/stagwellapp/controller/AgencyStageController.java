/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.stagwell.stagwellapp.dto.UserAgencyDto
 *  com.stagwell.stagwellapp.service.AgencyService
 *  org.springframework.beans.factory.annotation.Autowired
 *  org.springframework.web.bind.annotation.GetMapping
 *  org.springframework.web.bind.annotation.RequestAttribute
 *  org.springframework.web.bind.annotation.RequestMapping
 *  org.springframework.web.bind.annotation.RestController
 */
package com.stagwell.stagwellapp.controller;

import com.stagwell.stagwellapp.Constants;
import com.stagwell.stagwellapp.dto.UserAgencyDto;
import com.stagwell.stagwellapp.service.AgencyService;
import java.util.List;
import java.util.Map;

import com.stagwell.stagwellapp.util.CookieUtils;
import com.stagwell.stagwellapp.util.ValidateCookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.websocket.server.PathParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value={"agency"})
@Slf4j
public class AgencyStageController {
    @Autowired
    AgencyService agencyService;

    @GetMapping("list")
    public List<UserAgencyDto> getAllUserAgency(HttpServletRequest request) throws Exception {
       log.info("getAllUserAgency(-) in");
       Map<String,String> map= CookieUtils.getCookie(request, Constants.COOKIENAME);
        if(!ValidateCookie.validateCookies(map,new String[]{"email"})){
         throw new Exception("User session is not validated, Please login again!");
        }
        String email= map.get("email");

        log.info("User email: {}",email);
        return this.agencyService.getAllSwmUsers(email);
    }
}
