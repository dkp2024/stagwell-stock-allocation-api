/*
 * Decompiled with CFR 0.152.
 */
package com.stagwell.stagwellapp.dto;

import java.util.Date;

public class SpecialRequestDto {
    private int specialRequestId;
    private int agencyId;
    private String cfoName;
    private String jobTitle;
    private double additionalCashBonusRequest;
    private double additionalStockBonusRequest;
    private String messageToApprover;
    private String approvalStatus;
    private String createdBy;
    private Date updatedDate;

    public int getSpecialRequestId() {
        return this.specialRequestId;
    }

    public int getAgencyId() {
        return this.agencyId;
    }

    public String getCfoName() {
        return this.cfoName;
    }

    public String getJobTitle() {
        return this.jobTitle;
    }

    public double getAdditionalCashBonusRequest() {
        return this.additionalCashBonusRequest;
    }

    public double getAdditionalStockBonusRequest() {
        return this.additionalStockBonusRequest;
    }

    public String getMessageToApprover() {
        return this.messageToApprover;
    }

    public String getApprovalStatus() {
        return this.approvalStatus;
    }

    public String getCreatedBy() {
        return this.createdBy;
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

    public void setCfoName(String cfoName) {
        this.cfoName = cfoName;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public void setAdditionalCashBonusRequest(double additionalCashBonusRequest) {
        this.additionalCashBonusRequest = additionalCashBonusRequest;
    }

    public void setAdditionalStockBonusRequest(double additionalStockBonusRequest) {
        this.additionalStockBonusRequest = additionalStockBonusRequest;
    }

    public void setMessageToApprover(String messageToApprover) {
        this.messageToApprover = messageToApprover;
    }

    public void setApprovalStatus(String approvalStatus) {
        this.approvalStatus = approvalStatus;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof SpecialRequestDto)) {
            return false;
        }
        SpecialRequestDto other = (SpecialRequestDto)o;
        if (!other.canEqual(this)) {
            return false;
        }
        if (this.getSpecialRequestId() != other.getSpecialRequestId()) {
            return false;
        }
        if (this.getAgencyId() != other.getAgencyId()) {
            return false;
        }
        if (Double.compare(this.getAdditionalCashBonusRequest(), other.getAdditionalCashBonusRequest()) != 0) {
            return false;
        }
        if (Double.compare(this.getAdditionalStockBonusRequest(), other.getAdditionalStockBonusRequest()) != 0) {
            return false;
        }
        String this$cfoName = this.getCfoName();
        String other$cfoName = other.getCfoName();
        if (this$cfoName == null ? other$cfoName != null : !this$cfoName.equals(other$cfoName)) {
            return false;
        }
        String this$jobTitle = this.getJobTitle();
        String other$jobTitle = other.getJobTitle();
        if (this$jobTitle == null ? other$jobTitle != null : !this$jobTitle.equals(other$jobTitle)) {
            return false;
        }
        String this$messageToApprover = this.getMessageToApprover();
        String other$messageToApprover = other.getMessageToApprover();
        if (this$messageToApprover == null ? other$messageToApprover != null : !this$messageToApprover.equals(other$messageToApprover)) {
            return false;
        }
        String this$approvalStatus = this.getApprovalStatus();
        String other$approvalStatus = other.getApprovalStatus();
        if (this$approvalStatus == null ? other$approvalStatus != null : !this$approvalStatus.equals(other$approvalStatus)) {
            return false;
        }
        String this$createdBy = this.getCreatedBy();
        String other$createdBy = other.getCreatedBy();
        if (this$createdBy == null ? other$createdBy != null : !this$createdBy.equals(other$createdBy)) {
            return false;
        }
        Date this$updatedDate = this.getUpdatedDate();
        Date other$updatedDate = other.getUpdatedDate();
        return !(this$updatedDate == null ? other$updatedDate != null : !((Object)this$updatedDate).equals(other$updatedDate));
    }

    protected boolean canEqual(Object other) {
        return other instanceof SpecialRequestDto;
    }

    public int hashCode() {
        int PRIME = 59;
        int result = 1;
        result = result * 59 + this.getSpecialRequestId();
        result = result * 59 + this.getAgencyId();
        long $additionalCashBonusRequest = Double.doubleToLongBits(this.getAdditionalCashBonusRequest());
        result = result * 59 + (int)($additionalCashBonusRequest >>> 32 ^ $additionalCashBonusRequest);
        long $additionalStockBonusRequest = Double.doubleToLongBits(this.getAdditionalStockBonusRequest());
        result = result * 59 + (int)($additionalStockBonusRequest >>> 32 ^ $additionalStockBonusRequest);
        String $cfoName = this.getCfoName();
        result = result * 59 + ($cfoName == null ? 43 : $cfoName.hashCode());
        String $jobTitle = this.getJobTitle();
        result = result * 59 + ($jobTitle == null ? 43 : $jobTitle.hashCode());
        String $messageToApprover = this.getMessageToApprover();
        result = result * 59 + ($messageToApprover == null ? 43 : $messageToApprover.hashCode());
        String $approvalStatus = this.getApprovalStatus();
        result = result * 59 + ($approvalStatus == null ? 43 : $approvalStatus.hashCode());
        String $createdBy = this.getCreatedBy();
        result = result * 59 + ($createdBy == null ? 43 : $createdBy.hashCode());
        Date $updatedDate = this.getUpdatedDate();
        result = result * 59 + ($updatedDate == null ? 43 : ((Object)$updatedDate).hashCode());
        return result;
    }

    public String toString() {
        return "SpecialRequestDto(specialRequestId=" + this.getSpecialRequestId() + ", agencyId=" + this.getAgencyId() + ", cfoName=" + this.getCfoName() + ", jobTitle=" + this.getJobTitle() + ", additionalCashBonusRequest=" + this.getAdditionalCashBonusRequest() + ", additionalStockBonusRequest=" + this.getAdditionalStockBonusRequest() + ", messageToApprover=" + this.getMessageToApprover() + ", approvalStatus=" + this.getApprovalStatus() + ", createdBy=" + this.getCreatedBy() + ", updatedDate=" + String.valueOf(this.getUpdatedDate()) + ")";
    }
}
