/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.stagwell.stagwellapp.dto.SpecialRequestApproveDto
 *  com.stagwell.stagwellapp.dto.SpecialRequestDto
 *  com.stagwell.stagwellapp.repo.UserRepository
 *  org.apache.logging.log4j.LogManager
 *  org.apache.logging.log4j.Logger
 *  org.springframework.beans.factory.annotation.Autowired
 *  org.springframework.beans.factory.annotation.Value
 *  org.springframework.stereotype.Service
 *  org.springframework.transaction.annotation.Transactional
 */
package com.stagwell.stagwellapp.service;

import com.stagwell.stagwellapp.dto.SpecialRequestApproveDto;
import com.stagwell.stagwellapp.dto.SpecialRequestDto;
import com.stagwell.stagwellapp.repo.UserRepository;
import com.stagwell.stagwellapp.service.AgencyService;
import com.stagwell.stagwellapp.service.EntityService;
import java.math.BigDecimal;
import java.sql.Date;
import java.time.Instant;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SpecialRequestService {
    private static final Logger log = LogManager.getLogger(SpecialRequestService.class);
    @Autowired
    UserRepository userRepository;
    @Autowired
    AgencyService agencyService;
    @Autowired
    EntityService entityService;
    @Value(value="${saveApprovedSRValues:false}")
    private boolean saveApprovedSRValues;

    @Transactional
    public void saveSpecialRequest(SpecialRequestDto specialRequestDto) {
        this.userRepository.saveSwtSpecialRequests(specialRequestDto);
    }

    public List<SpecialRequestDto> getSRList(int agencyId) {
        List<Map<String, Object>> specialRequests = this.userRepository.getSpecialRequests(agencyId);
        return specialRequests.stream().map(sr -> {
            SpecialRequestDto specialRequestDto = new SpecialRequestDto();
            specialRequestDto.setSpecialRequestId(((Integer)sr.get("special_request_id")).intValue());
            specialRequestDto.setAgencyId(((Integer)sr.get("agency_id")).intValue());
            specialRequestDto.setCfoName((String)sr.get("cfo_name"));
            specialRequestDto.setJobTitle((String)sr.get("job_title"));
            specialRequestDto.setAdditionalCashBonusRequest(((BigDecimal)sr.get("additional_cash_bonus_request")).doubleValue());
            specialRequestDto.setAdditionalStockBonusRequest(((BigDecimal)sr.get("additional_stock_bonus_request")).doubleValue());
            specialRequestDto.setMessageToApprover((String)sr.get("message_to_approver"));
            specialRequestDto.setApprovalStatus((String)sr.get("approval_status"));
            specialRequestDto.setCreatedBy((String)sr.get("created_by"));
            specialRequestDto.setUpdatedDate(Date.from((Instant)sr.get("updated_dt")));
            return specialRequestDto;
        }).collect(Collectors.toList());
    }

    @Transactional
    public void updateSpecialRequest(SpecialRequestApproveDto approveDto) {
        log.info(this.saveApprovedSRValues ? "ApprovedSRValues are also updated in swt_special_requests table" : "ApprovedSRValues are only incremented in swt_agency_budget_allocation");
        if (this.saveApprovedSRValues) {
            this.userRepository.updateSpecialRequestWithApprovedSRValues(approveDto);
        } else {
            this.userRepository.updateSpecialRequestWithoutApprovedSRValues(approveDto);
        }
        this.agencyService.incrementAgencyAmount(approveDto.getApprovedCashBonus(), approveDto.getApprovedStockBonus(), approveDto.getAgencyId());
        log.info("SR approved value is incremented in agency:{}", (Object)approveDto.getAgencyId());
        List<Integer> entitiesOfAgency = this.entityService.incrementEntityAmount(approveDto.getApprovedCashBonus(), approveDto.getApprovedStockBonus(), approveDto.getAgencyId());
        log.info("SR approved value is incremented in entities:{}", (Object)(entitiesOfAgency != null && entitiesOfAgency.size() > 0 ? entitiesOfAgency.stream().map(a -> "" + a).collect(Collectors.joining()) : "NULL or 0"));
    }
}
