/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.stagwell.stagwellapp.dto.SpecialRequestApproveDto
 *  com.stagwell.stagwellapp.dto.SpecialRequestDto
 *  com.stagwell.stagwellapp.service.EntityService
 *  com.stagwell.stagwellapp.service.SpecialRequestService
 *  org.springframework.beans.factory.annotation.Autowired
 *  org.springframework.web.bind.annotation.RequestBody
 *  org.springframework.web.bind.annotation.RequestMapping
 *  org.springframework.web.bind.annotation.RequestParam
 *  org.springframework.web.bind.annotation.RestController
 */
package com.stagwell.stagwellapp.controller;

import com.stagwell.stagwellapp.dto.SpecialRequestApproveDto;
import com.stagwell.stagwellapp.dto.SpecialRequestDto;
import com.stagwell.stagwellapp.service.EntityService;
import com.stagwell.stagwellapp.service.SpecialRequestService;
import java.util.List;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value={"sr"})
@Slf4j
public class SpecialRequestController {
    @Autowired
    SpecialRequestService specialRequestService;
    @Autowired
    private EntityService entityService;

    @RequestMapping(value={"save"})
    public void saveSR(@RequestBody SpecialRequestDto specialRequestDto) {
        log.info("saveSR(-) in");
        this.specialRequestService.saveSpecialRequest(specialRequestDto);
        List<Integer> entityByAgencyIds = this.entityService.getEntityByAgencyId(specialRequestDto.getAgencyId());
        entityByAgencyIds.forEach(e -> this.entityService.updateStageOfEntity("Stage 4", e.intValue()));
    }

    @RequestMapping(value={"approve"})
    public void saveSR(@RequestBody SpecialRequestApproveDto specialRequestApproveDto) {
        log.info("saveSR(-) approve in");
        this.specialRequestService.updateSpecialRequest(specialRequestApproveDto);
    }

    @RequestMapping(value={"list"})
    public List<SpecialRequestDto> getSrListByAgencyId(@RequestParam(value="agency_id") int agencyId) {
        return this.specialRequestService.getSRList(agencyId);
    }
}
