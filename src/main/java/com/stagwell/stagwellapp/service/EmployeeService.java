/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.stagwell.stagwellapp.dto.EmployeeDto
 *  com.stagwell.stagwellapp.repo.EmployeeRepository
 *  org.springframework.beans.factory.annotation.Autowired
 *  org.springframework.stereotype.Service
 *  org.springframework.transaction.annotation.Transactional
 */
package com.stagwell.stagwellapp.service;

import com.stagwell.stagwellapp.dto.EmployeeDto;
import com.stagwell.stagwellapp.repo.EmployeeRepository;
import com.stagwell.stagwellapp.service.EntityService;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private EntityService entityService;

    public List<EmployeeDto> getEmployeeByEntity(String sessionUserId) {
        List<Map<String, Object>> employeeList = this.employeeRepository.getEmployeeByEntity(sessionUserId != null ? Integer.parseInt(sessionUserId) : 0);
        return employeeList.stream().map(this::getEmployeeDto).collect(Collectors.toList());
    }

    EmployeeDto getEmployeeDto(Map<String, Object> dataMap) {
        EmployeeDto employeeDto = new EmployeeDto((String)dataMap.get("first_name"), (String)dataMap.get("last_name"), (String)dataMap.get("job_title"), (String)dataMap.get("employee_id"));
        employeeDto.setAgencyName((String)dataMap.get("agency_name"));
        employeeDto.setEntity((String)dataMap.get("entity"));
        employeeDto.setStockBonusPresent(Double.valueOf(((BigDecimal)dataMap.get("stock_bonus_present")).doubleValue()));
        employeeDto.setBaseCompPresent(Double.valueOf(((BigDecimal)dataMap.get("base_comp_present")).doubleValue()));
        employeeDto.setCashBonusPresent(Double.valueOf(((BigDecimal)dataMap.get("cash_bonus_present")).doubleValue()));
        employeeDto.setTotalBonusPresent(Double.valueOf(((BigDecimal)dataMap.get("total_bonus_present")).doubleValue()));
        employeeDto.setStockPremiumPresent(Double.valueOf(((BigDecimal)dataMap.get("stock_premium_present")).doubleValue()));
        employeeDto.setStockBonusPrevious(Double.valueOf(((BigDecimal)dataMap.get("stock_bonus_previous")).doubleValue()));
        employeeDto.setBaseCompPrevious(Double.valueOf(((BigDecimal)dataMap.get("base_comp_previous")).doubleValue()));
        employeeDto.setCashBonusPrevious(Double.valueOf(((BigDecimal)dataMap.get("cash_bonus_previous")).doubleValue()));
        employeeDto.setTotalBonusPrevious(Double.valueOf(((BigDecimal)dataMap.get("total_bonus_previous")).doubleValue()));
        employeeDto.setStockPremiumPrevious(Double.valueOf(((BigDecimal)dataMap.get("stock_premium_previous")).doubleValue()));
        employeeDto.setVesting(dataMap.get("vesting") != null ? ((Short)dataMap.get("vesting")).intValue() : 0);
        employeeDto.setVestingPremiumPercentage(dataMap.get("vesting_premium_perc") != null ? ((Short)dataMap.get("vesting_premium_perc")).intValue() : 0);
        employeeDto.setYear(dataMap.get("year") != null ? ((Short)dataMap.get("year")).intValue() : 0);
        employeeDto.setCostType((String)dataMap.get("cost_type"));
        employeeDto.setRetentionCurrentYear(Double.valueOf((dataMap.get("retention_current_year") != null ? (BigDecimal)dataMap.get("retention_current_year") : new BigDecimal("0")).doubleValue()));
        employeeDto.setSsn((String)dataMap.get("ssn"));
        employeeDto.setFullName((String)dataMap.get("full_name"));
        employeeDto.setEmailAddress((String)dataMap.get("email_address"));
        employeeDto.setHomeAddress((String)dataMap.get("home_address"));
        employeeDto.setHomeAddressCity((String)dataMap.get("home_address_city"));
        employeeDto.setHomeAddressStateCode((String)dataMap.get("home_address_state_code"));
        employeeDto.setHomeAddressStateName((String)dataMap.get("home_address_state_name"));
        employeeDto.setHomeAddressZipCode((String)dataMap.get("home_address_zip_code"));
        employeeDto.setHomeAddressCountry((String)dataMap.get("home_address_country"));
        employeeDto.setCountryOfPayrollTaxation((String)dataMap.get("country_of_payroll_taxation"));
        employeeDto.setBirthDate(Date.from((Instant)dataMap.get("birth_date")));
        employeeDto.setHireDate(Date.from((Instant)dataMap.get("hire_date")));
        employeeDto.setAgencyID(((Integer)dataMap.get("agency_id")).intValue());
        employeeDto.setEntityId(((Integer)dataMap.get("entity_id")).intValue());
        String status = (String)dataMap.get("status");
        if (status != null && status.equalsIgnoreCase("SUBMITED")) {
            employeeDto.setSubmitted(true);
        } else {
            employeeDto.setSubmitted(false);
        }
        return employeeDto;
    }

    @Transactional
    public void saveEmployees(List<EmployeeDto> employeeDtoList) {
        employeeDtoList.forEach(e -> {
            if (e.isSubmitted()) {
                e.setStatus("SUBMITED");
            } else {
                e.setStatus("NOT_SUBMITED");
            }
            this.employeeRepository.saveEmployee(e.getCashBonusPresent().doubleValue(), e.getStockBonusPresent().doubleValue(), e.getStockPremiumPresent().doubleValue(), e.getBaseCompPresent().doubleValue(), e.getTotalBonusPresent().doubleValue(), e.getStatus(), e.getEmployeeId(), 2023);
            this.entityService.updateStageOfEntity("Stage 3", e.getEntityId());
        });
    }
}
