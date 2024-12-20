/*
 * Decompiled with CFR 0.152.
 */
package com.stagwell.stagwellapp.dto;

import java.util.Date;

public class SpecialRequestApproveDto {
    private int specialRequestId;
    private int agencyId;
    private int approvedCashBonus;
    private int approvedStockBonus;
    private String approvalStatus;
    private Date updatedDate = new Date();

    public int getSpecialRequestId() {
        return this.specialRequestId;
    }

    public int getAgencyId() {
        return this.agencyId;
    }

    public int getApprovedCashBonus() {
        return this.approvedCashBonus;
    }

    public int getApprovedStockBonus() {
        return this.approvedStockBonus;
    }

    public String getApprovalStatus() {
        return this.approvalStatus;
    }

    public Date getUpdatedDate() {
        return this.updatedDate;
    }

    public void setSpecialRequestId(int specialRequestId) {
        this.specialRequestId = specialRequestId;
    }

    public void setAgencyId(int agencyId) {
        this.agencyId = agencyId;
    }

    public void setApprovedCashBonus(int approvedCashBonus) {
        this.approvedCashBonus = approvedCashBonus;
    }

    public void setApprovedStockBonus(int approvedStockBonus) {
        this.approvedStockBonus = approvedStockBonus;
    }

    public void setApprovalStatus(String approvalStatus) {
        this.approvalStatus = approvalStatus;
    }

    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof SpecialRequestApproveDto)) {
            return false;
        }
        SpecialRequestApproveDto other = (SpecialRequestApproveDto)o;
        if (!other.canEqual(this)) {
            return false;
        }
        if (this.getSpecialRequestId() != other.getSpecialRequestId()) {
            return false;
        }
        if (this.getAgencyId() != other.getAgencyId()) {
            return false;
        }
        if (this.getApprovedCashBonus() != other.getApprovedCashBonus()) {
            return false;
        }
        if (this.getApprovedStockBonus() != other.getApprovedStockBonus()) {
            return false;
        }
        String this$approvalStatus = this.getApprovalStatus();
        String other$approvalStatus = other.getApprovalStatus();
        if (this$approvalStatus == null ? other$approvalStatus != null : !this$approvalStatus.equals(other$approvalStatus)) {
            return false;
        }
        Date this$updatedDate = this.getUpdatedDate();
        Date other$updatedDate = other.getUpdatedDate();
        return !(this$updatedDate == null ? other$updatedDate != null : !((Object)this$updatedDate).equals(other$updatedDate));
    }

    protected boolean canEqual(Object other) {
        return other instanceof SpecialRequestApproveDto;
    }

    public int hashCode() {
        int PRIME = 59;
        int result = 1;
        result = result * 59 + this.getSpecialRequestId();
        result = result * 59 + this.getAgencyId();
        result = result * 59 + this.getApprovedCashBonus();
        result = result * 59 + this.getApprovedStockBonus();
        String $approvalStatus = this.getApprovalStatus();
        result = result * 59 + ($approvalStatus == null ? 43 : $approvalStatus.hashCode());
        Date $updatedDate = this.getUpdatedDate();
        result = result * 59 + ($updatedDate == null ? 43 : ((Object)$updatedDate).hashCode());
        return result;
    }

    public String toString() {
        return "SpecialRequestApproveDto(specialRequestId=" + this.getSpecialRequestId() + ", agencyId=" + this.getAgencyId() + ", approvedCashBonus=" + this.getApprovedCashBonus() + ", approvedStockBonus=" + this.getApprovedStockBonus() + ", approvalStatus=" + this.getApprovalStatus() + ", updatedDate=" + String.valueOf(this.getUpdatedDate()) + ")";
    }
}
