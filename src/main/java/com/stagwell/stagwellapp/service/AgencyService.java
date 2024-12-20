/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.stagwell.stagwellapp.dto.UserAgencyDto
 *  com.stagwell.stagwellapp.dto.UserDto
 *  com.stagwell.stagwellapp.entity.SwmUserInfo
 *  com.stagwell.stagwellapp.repo.UserRepository
 *  org.modelmapper.ModelMapper
 *  org.springframework.beans.factory.annotation.Autowired
 *  org.springframework.stereotype.Service
 */
package com.stagwell.stagwellapp.service;

import com.stagwell.stagwellapp.dto.UserAgencyDto;
import com.stagwell.stagwellapp.dto.UserDto;
import com.stagwell.stagwellapp.entity.SwmUserInfo;
import com.stagwell.stagwellapp.repo.UserRepository;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AgencyService {
    @Autowired
    UserRepository userRepository;
    ModelMapper modelMapper = new ModelMapper();

    public List<UserAgencyDto> getAllSwmUsers(String email) {
        List<Map<String, Object>> allByUserName = this.userRepository.findAllAgenciesByUserName(email);
        return allByUserName.stream().map(a -> {
            UserAgencyDto userAgencyDto = new UserAgencyDto();
            userAgencyDto.setAgencyName((String)a.get("agency_name"));
            userAgencyDto.setAgencyId(((Integer)a.get("agency_id")).intValue());
            userAgencyDto.setOverallBonusPoolBudget(((Integer)a.get("overall_bonus_pool_budget")).doubleValue());
            userAgencyDto.setAmountForCash(((Integer)a.get("amount_allocated_to_cash")).doubleValue());
            userAgencyDto.setAmountForStock(((Integer)a.get("amount_allocated_to_stock")).doubleValue());
            return userAgencyDto;
        }).collect(Collectors.toList());
    }

    public void incrementAgencyAmount(int cashAmount, int stockAmount, int agencyId) {
        this.userRepository.incrementAgencyAmount(cashAmount, stockAmount, agencyId);
    }

    public UserDto convertToDto(SwmUserInfo swmUserInfo) {
        UserDto userDto = (UserDto)this.modelMapper.map((Object)swmUserInfo, UserDto.class);
        return userDto;
    }
}
