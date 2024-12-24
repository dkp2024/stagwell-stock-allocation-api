/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.stagwell.stagwellapp.dto.SpecialRequestApproveDto
 *  com.stagwell.stagwellapp.dto.SpecialRequestDto
 *  com.stagwell.stagwellapp.dto.UserEntityDto
 *  com.stagwell.stagwellapp.entity.SwmUserInfo
 *  org.springframework.data.jpa.repository.JpaRepository
 *  org.springframework.data.jpa.repository.Modifying
 *  org.springframework.data.jpa.repository.Query
 *  org.springframework.data.repository.query.Param
 *  org.springframework.stereotype.Repository
 */
package com.stagwell.stagwellapp.repo;

import com.stagwell.stagwellapp.dto.SpecialRequestApproveDto;
import com.stagwell.stagwellapp.dto.SpecialRequestDto;
import com.stagwell.stagwellapp.dto.UserEntityDto;
import com.stagwell.stagwellapp.entity.SwmUserInfo;
import java.util.List;
import java.util.Map;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository
extends JpaRepository<SwmUserInfo, Integer> {
    @Query(value="SELECT b.agency_name,\n       a.overall_bonus_pool_budget,\n       a.amount_allocated_to_cash,\n       b.agency_id,\n\t   a.amount_allocated_to_stock, c.email_address\nFROM swt_agency_budget_allocation a \nINNER JOIN swm_agency_info b ON a.agency_id=b.agency_id\nINNER JOIN swm_user_info c ON C.agency_name=b.agency_name\nINNER JOIN swm_usercredentials d ON d.user_id=c.user_id\nWHERE user_type IN ('AGENCY','NETWORK','STAGWELL','NETWORK')\nAND c.email_address=:email", nativeQuery=true)
    public List<Map<String, Object>> findAllAgenciesByUserName(@Param(value="email") String email);

    @Query(value="SELECT b.entity,\n       a.amount_allocated_to_cash,\n\t   a.amount_allocated_to_stock,\n\t   c.status,\n\t   a.entity_id,\n\t   b.agency_name,\n\t   b.agency_id\nFROM swt_entity_budget_allocation a \nINNER JOIN swm_entity_info b ON a.entity_id=b.entity_id\nINNER JOIN swt_entity_budget_allocation c ON c.entity_id=b.entity_id\nINNER JOIN swm_user_info d ON d.agency_name=b.agency_name AND d.entity=b.entity\nINNER JOIN swm_usercredentials e ON e.user_id=d.user_id\nWHERE user_type IN ('AGENCY','NETWORK','STAGWELL','NETWORK','ENTITY')\nAND d.user_id=:userId", nativeQuery=true)
    public List<Map<String, Object>> findAllEntitiesByAgency(int userId);

    public List<SwmUserInfo> getSwmUserInfoByEmailAddress(String email);

    @Modifying
    @Query(nativeQuery=true, value="INSERT INTO public.swt_special_requests(\n\tagency_id, cfo_name, job_title, additional_cash_bonus_request, additional_stock_bonus_request, message_to_approver, approval_status, created_by, updated_dt)\n\tVALUES (:#{#sr.agencyId}, :#{#sr.cfoName}, :#{#sr.jobTitle}, :#{#sr.additionalCashBonusRequest}, :#{#sr.additionalStockBonusRequest}, :#{#sr.messageToApprover}, :#{#sr.approvalStatus}, :#{#sr.createdBy}, :#{#sr.updatedDate})")
    public void saveSwtSpecialRequests(SpecialRequestDto sr);

    @Query(value="SELECT special_request_id, agency_id, cfo_name, job_title, additional_cash_bonus_request, additional_stock_bonus_request, message_to_approver, approval_status, created_by, updated_dt\n\tFROM swt_special_requests WHERE agency_id=:agencyId ORDER BY special_request_id DESC LIMIT 5", nativeQuery=true)
    public List<Map<String, Object>> getSpecialRequests(int agencyId);

    @Modifying
    @Query(nativeQuery=true, value="UPDATE swt_entity_budget_allocation SET amount_allocated_to_cash=:#{#ue.amountForCash}, amount_allocated_to_stock=:#{#ue.amountForStock}, status=:#{#ue.status} WHERE entity_id=:#{#ue.entityId}")
    public void saveEntity(UserEntityDto ue);

    @Modifying
    @Query(nativeQuery=true, value="UPDATE swt_special_requests SET \napproved_cash_bonus=:#{#sr.approvedCashBonus}, approved_stock_bonus=:#{#sr.approvedStockBonus},\napproval_status=:#{#sr.approvalStatus} WHERE special_request_id=:#{#sr.specialRequestId}")
    public void updateSpecialRequestWithApprovedSRValues(SpecialRequestApproveDto sr);

    @Modifying
    @Query(nativeQuery=true, value="UPDATE swt_special_requests SET \napproval_status=:#{#sr.approvalStatus} WHERE special_request_id=:#{#sr.specialRequestId}")
    public void updateSpecialRequestWithoutApprovedSRValues(SpecialRequestApproveDto sr);

    @Modifying
    @Query(nativeQuery=true, value="UPDATE swt_agency_budget_allocation AS a SET \namount_allocated_to_cash=amount_allocated_to_cash+:cashAmount, amount_allocated_to_stock=amount_allocated_to_stock+:stockAmount \nFROM swm_agency_info AS b WHERE a.agency_id=b.agency_id AND b.agency_id=:agencyId")
    public void incrementAgencyAmount(int cashAmount, int stockAmount, int agencyId);

    @Modifying
    @Query(nativeQuery=true, value="UPDATE swt_entity_budget_allocation SET \namount_allocated_to_cash=amount_allocated_to_cash+:cashAmount, amount_allocated_to_stock=amount_allocated_to_stock+:stockAmount \nWHERE entity_id=:entityId")
    public void incrementEntityAmount(int cashAmount, int stockAmount, int entityId);

    @Modifying
    @Query(nativeQuery=true, value="UPDATE swt_entity_budget_allocation SET current_stage=:stage WHERE entity_id=:entityId")
    public void updateStage(String stage, int entityId);

    @Modifying
    @Query(nativeQuery=true, value="SELECT entity_id FROM swm_entity_info WHERE agency_id=:agencyId")
    public List<Map<String, Object>> getEntitiesByAgencyId(int agencyId);
}
