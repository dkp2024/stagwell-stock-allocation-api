/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.stagwell.stagwellapp.dto.UserEntityDto
 *  com.stagwell.stagwellapp.repo.UserRepository
 *  org.apache.logging.log4j.LogManager
 *  org.apache.logging.log4j.Logger
 *  org.springframework.beans.factory.annotation.Autowired
 *  org.springframework.stereotype.Service
 *  org.springframework.transaction.annotation.Transactional
 */
package com.stagwell.stagwellapp.service;

import com.stagwell.stagwellapp.dto.UserEntityDto;
import com.stagwell.stagwellapp.repo.UserRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EntityService {
    private static final Logger log = LogManager.getLogger(EntityService.class);
    @Autowired
    UserRepository userRepository;

    public List<UserEntityDto> getEntityListByAgency(String agency, int userId) {
        List<Map<String, Object>> allEntitiesByAgency = this.userRepository.findAllEntitiesByAgency(userId);
        return allEntitiesByAgency.stream().map(a -> {
            UserEntityDto userEntityDto = new UserEntityDto();
            userEntityDto.setEntityName((String)a.get("entity"));
            userEntityDto.setAmountForCash(((Integer)a.get("amount_allocated_to_cash")).doubleValue());
            userEntityDto.setAmountForStock(((Integer)a.get("amount_allocated_to_stock")).doubleValue());
            String status = (String)a.get("status");
            if (status != null && status.equals("SUBMITED")) {
                userEntityDto.setSubmitted(true);
            } else {
                userEntityDto.setSubmitted(false);
            }
            userEntityDto.setEntityId(((Integer)a.get("entity_id")).intValue());
            userEntityDto.setAgencyName((String)a.get("agency_name"));
            userEntityDto.setAgencyId(((Integer)a.get("agency_id")).intValue());
            userEntityDto.setCurrentStage((String)a.get("current_stage"));
            return userEntityDto;
        }).collect(Collectors.toList());
    }

    @Transactional
    public void saveEntity(UserEntityDto userEntityDto) {
        if (userEntityDto.isSubmitted()) {
            userEntityDto.setStatus("SUBMITED");
        } else {
            userEntityDto.setStatus("NOT_SUBMITED");
        }
        this.userRepository.saveEntity(userEntityDto);
    }

    @Transactional
    public void updateStageOfEntity(String stage, int entityId) {
        this.userRepository.updateStage(stage, entityId);
    }

    public List<Integer> getEntityByAgencyId(int agencyId) {
        ArrayList<Integer> entityIds = new ArrayList<Integer>();
        List<Map<String, Object>> result = this.userRepository.getEntitiesByAgencyId(agencyId);
        result.forEach(r -> entityIds.add((Integer)r.get("entity_id")));
        return entityIds;
    }

    public List<Integer> incrementEntityAmount(int approvedCashBonus, int approvedStockBonus, int agencyId) {
        List<Integer> entitiesByAgencyId = this.getEntityByAgencyId(agencyId);
        if (entitiesByAgencyId != null && entitiesByAgencyId.size() > 0) {
            entitiesByAgencyId.forEach(eId -> this.userRepository.incrementEntityAmount(approvedCashBonus / entitiesByAgencyId.size(), approvedStockBonus / entitiesByAgencyId.size(), eId.intValue()));
        } else {
            log.error("In incrementEntityAmount, entitiesByAgencyId list is NULL or size:0");
        }
        return entitiesByAgencyId;
    }
}
