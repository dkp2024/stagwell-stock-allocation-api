/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.stagwell.stagwellapp.entity.SwmEmployeeInfo
 *  org.springframework.data.jpa.repository.JpaRepository
 *  org.springframework.data.jpa.repository.Modifying
 *  org.springframework.data.jpa.repository.Query
 */
package com.stagwell.stagwellapp.repo;

import com.stagwell.stagwellapp.entity.SwmEmployeeInfo;
import java.util.List;
import java.util.Map;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface EmployeeRepository
extends JpaRepository<SwmEmployeeInfo, Integer> {
    @Query(nativeQuery=true, value="SELECT a.first_name,\n       a.last_name,\n\t   a.job_title,\n\t   d.agency_name,\n\t   c.entity,\n\t   a.employee_id,\n\t   b.base_comp base_comp_present,\n\t   b.cash_bonus cash_bonus_present,\n\t   b.stock_bonus stock_bonus_present,\n\t   b.stock_premium stock_premium_present,\n\t   b.total_bonus total_bonus_present,\n\t   b.vesting vesting_present,\n\t   b.vesting_premium_perc vesting_premium_perc_present,\n\t   z.base_comp base_comp_previous,\n\t   z.cash_bonus cash_bonus_previous,\n\t   z.stock_bonus stock_bonus_previous,\n\t   z.stock_premium stock_premium_previous,\n\t   z.total_bonus total_bonus_previous,\n\t   z.vesting vesting_previous,\n\t   z.vesting_premium_perc vesting_premium_perc_previous,\n\t   ----hidden column\n\t   b.year,\n\t   b.cost_type,\n\t   b.retention_current_year,\n\t   a.ssn,\n\t   a.full_name,\n\t   a.email_address,\n\t   a.home_address,\n\t   a.home_address_city,\n\t   a.home_address_state_code,\n\t   a.home_address_state_name,\n\t   a.home_address_zip_code,\n\t   a.home_address_country,\n\t   a.country_of_payroll_taxation,\n\t   a.birth_date,\n\t   a.hire_date,\t   \n\t   b.status,\t   \n\t   a.entity_id,\t   \n\t   d.agency_id\t   \nFROM swm_employees_info a \nINNER JOIN swt_overall_bonus_pool_budget b ON a.employee_id=b.employee_id\nINNER JOIN swt_overall_bonus_pool_budget z ON z.employee_id=B.employee_id \nINNER JOIN swm_entity_info c ON c.entity_id=a.entity_id\nINNER JOIN swm_agency_info d ON d.agency_id=c.agency_id\nINNER JOIN swm_user_info e ON e.agency_name=c.agency_name AND e.entity=c.entity\nINNER JOIN swm_usercredentials f ON f.user_id=e.user_id\nWHERE user_type IN ('AGENCY','NETWORK','STAGWELL','NETWORK','ENTITY')\nAND f.user_id=:userId AND z.year=2022 and b.year=2023")
    public List<Map<String, Object>> getEmployeeByEntity(int userId);

    @Modifying
    @Query(nativeQuery=true, value="UPDATE swt_overall_bonus_pool_budget SET cash_bonus=:cashBonusPresent, stock_bonus=:stockBonusPresent, stock_premium=:stockPremiumPresent, base_comp=:baseCompPresent, total_bonus=:totalBonusPresent, status=:status WHERE employee_id=:employeeId AND year=:year")
    public void saveEmployee(double cashBonusPresent, double stockBonusPresent, double stockPremiumPresent, double baseCompPresent, double totalBonusPresent, String status, String employeeId, int year);
}
