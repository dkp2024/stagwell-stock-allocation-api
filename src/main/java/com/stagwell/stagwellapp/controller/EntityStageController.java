/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.stagwell.stagwellapp.dto.UserEntityDto
 *  com.stagwell.stagwellapp.service.EntityService
 *  org.modelmapper.ModelMapper
 *  org.springframework.beans.factory.annotation.Autowired
 *  org.springframework.web.bind.annotation.PostMapping
 *  org.springframework.web.bind.annotation.RequestAttribute
 *  org.springframework.web.bind.annotation.RequestBody
 *  org.springframework.web.bind.annotation.RequestMapping
 *  org.springframework.web.bind.annotation.RequestParam
 *  org.springframework.web.bind.annotation.RestController
 */
package com.stagwell.stagwellapp.controller;

import com.stagwell.stagwellapp.Constants;
import com.stagwell.stagwellapp.dto.UserEntityDto;
import com.stagwell.stagwellapp.service.EntityService;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.stagwell.stagwellapp.util.CookieUtils;
import com.stagwell.stagwellapp.util.ValidateCookie;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value={"entity"})
@Slf4j
public class EntityStageController {
    @Autowired
    private EntityService entityService;
    ModelMapper modelMapper = new ModelMapper();

    @RequestMapping(value={"list"})
    public List<UserEntityDto> getListOfEntitiesByAgency(HttpServletRequest request) throws Exception {
        log.info("getListOfEntitiesByAgency(-) in list");
        Map<String,String > map = CookieUtils.getCookie(request, Constants.COOKIENAME);
        if(!ValidateCookie.validateCookies(map,new String[]{"email","userId"})){
            throw new Exception("User session is not validated, Please login again!");
        }
        String email= map.get("email");
        String userId= map.get("userId");
        log.info("User email: {} userId: {}",email,userId);
        return this.entityService.getEntityListByAgency(email, Integer.parseInt(userId));
    }
/*
    @RequestMapping(value={"listofagency"})
    public List<UserEntityDto> getListOfEntitiesByAgencies(HttpServletRequest request) throws Exception {
        log.info("getListOfEntitiesByAgencies(-) in listofagency");
        Map<String,String > map = CookieUtils.getCookie(request, Constants.COOKIENAME);
        if(!ValidateCookie.validateCookies(map,new String[]{"email","userId"})){
            throw new Exception("User session is not validated, Please login again!");
        }
        String email= map.get("email");
        String userId= map.get("userId");
        log.info("User email: {} userId: {}, agencyId",email,userId);
        List<UserEntityDto> entityList = this.entityService.getEntityListByAgency(email, Integer.parseInt(userId));
        return entityList.stream().filter(a -> a.getAgencyId() == 104).collect(Collectors.toList());
    }*/

    @PostMapping(value={"save"})
    public void saveEntities(@RequestBody List<UserEntityDto> userEntityDtoList) {
        userEntityDtoList.forEach(userEntityDto -> {
            this.entityService.saveEntity(userEntityDto);
            this.entityService.updateStageOfEntity("Stage 2", userEntityDto.getEntityId());
        });
    }
}
