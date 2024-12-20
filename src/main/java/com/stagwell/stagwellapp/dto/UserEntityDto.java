/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.annotation.JsonIgnore
 */
package com.stagwell.stagwellapp.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class UserEntityDto {
    private double overallBonusPoolBudget;
    private double amountForCash;
    private double amountForStock;
    @JsonIgnore
    private String status;
    private String entityName;
    private String agencyName;
    private int entityId;
    private boolean isSubmitted;
    private int agencyId;
    private String currentStage;

    public double getOverallBonusPoolBudget() {
        return this.overallBonusPoolBudget;
    }

    public double getAmountForCash() {
        return this.amountForCash;
    }

    public double getAmountForStock() {
        return this.amountForStock;
    }

    public String getStatus() {
        return this.status;
    }

    public String getEntityName() {
        return this.entityName;
    }

    public String getAgencyName() {
        return this.agencyName;
    }

    public int getEntityId() {
        return this.entityId;
    }

    public boolean isSubmitted() {
        return this.isSubmitted;
    }

    public int getAgencyId() {
        return this.agencyId;
    }

    public String getCurrentStage() {
        return this.currentStage;
    }

    public void setOverallBonusPoolBudget(double overallBonusPoolBudget) {
        this.overallBonusPoolBudget = overallBonusPoolBudget;
    }

    public void setAmountForCash(double amountForCash) {
        this.amountForCash = amountForCash;
    }

    public void setAmountForStock(double amountForStock) {
        this.amountForStock = amountForStock;
    }

    @JsonIgnore
    public void setStatus(String status) {
        this.status = status;
    }

    public void setEntityName(String entityName) {
        this.entityName = entityName;
    }

    public void setAgencyName(String agencyName) {
        this.agencyName = agencyName;
    }

    public void setEntityId(int entityId) {
        this.entityId = entityId;
    }

    public void setSubmitted(boolean isSubmitted) {
        this.isSubmitted = isSubmitted;
    }

    public void setAgencyId(int agencyId) {
        this.agencyId = agencyId;
    }

    public void setCurrentStage(String currentStage) {
        this.currentStage = currentStage;
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof UserEntityDto)) {
            return false;
        }
        UserEntityDto other = (UserEntityDto)o;
        if (!other.canEqual(this)) {
            return false;
        }
        if (Double.compare(this.getOverallBonusPoolBudget(), other.getOverallBonusPoolBudget()) != 0) {
            return false;
        }
        if (Double.compare(this.getAmountForCash(), other.getAmountForCash()) != 0) {
            return false;
        }
        if (Double.compare(this.getAmountForStock(), other.getAmountForStock()) != 0) {
            return false;
        }
        if (this.getEntityId() != other.getEntityId()) {
            return false;
        }
        if (this.isSubmitted() != other.isSubmitted()) {
            return false;
        }
        if (this.getAgencyId() != other.getAgencyId()) {
            return false;
        }
        String this$status = this.getStatus();
        String other$status = other.getStatus();
        if (this$status == null ? other$status != null : !this$status.equals(other$status)) {
            return false;
        }
        String this$entityName = this.getEntityName();
        String other$entityName = other.getEntityName();
        if (this$entityName == null ? other$entityName != null : !this$entityName.equals(other$entityName)) {
            return false;
        }
        String this$agencyName = this.getAgencyName();
        String other$agencyName = other.getAgencyName();
        if (this$agencyName == null ? other$agencyName != null : !this$agencyName.equals(other$agencyName)) {
            return false;
        }
        String this$currentStage = this.getCurrentStage();
        String other$currentStage = other.getCurrentStage();
        return !(this$currentStage == null ? other$currentStage != null : !this$currentStage.equals(other$currentStage));
    }

    protected boolean canEqual(Object other) {
        return other instanceof UserEntityDto;
    }

    public int hashCode() {
        int PRIME = 59;
        int result = 1;
        long $overallBonusPoolBudget = Double.doubleToLongBits(this.getOverallBonusPoolBudget());
        result = result * 59 + (int)($overallBonusPoolBudget >>> 32 ^ $overallBonusPoolBudget);
        long $amountForCash = Double.doubleToLongBits(this.getAmountForCash());
        result = result * 59 + (int)($amountForCash >>> 32 ^ $amountForCash);
        long $amountForStock = Double.doubleToLongBits(this.getAmountForStock());
        result = result * 59 + (int)($amountForStock >>> 32 ^ $amountForStock);
        result = result * 59 + this.getEntityId();
        result = result * 59 + (this.isSubmitted() ? 79 : 97);
        result = result * 59 + this.getAgencyId();
        String $status = this.getStatus();
        result = result * 59 + ($status == null ? 43 : $status.hashCode());
        String $entityName = this.getEntityName();
        result = result * 59 + ($entityName == null ? 43 : $entityName.hashCode());
        String $agencyName = this.getAgencyName();
        result = result * 59 + ($agencyName == null ? 43 : $agencyName.hashCode());
        String $currentStage = this.getCurrentStage();
        result = result * 59 + ($currentStage == null ? 43 : $currentStage.hashCode());
        return result;
    }

    public String toString() {
        return "UserEntityDto(overallBonusPoolBudget=" + this.getOverallBonusPoolBudget() + ", amountForCash=" + this.getAmountForCash() + ", amountForStock=" + this.getAmountForStock() + ", status=" + this.getStatus() + ", entityName=" + this.getEntityName() + ", agencyName=" + this.getAgencyName() + ", entityId=" + this.getEntityId() + ", isSubmitted=" + this.isSubmitted() + ", agencyId=" + this.getAgencyId() + ", currentStage=" + this.getCurrentStage() + ")";
    }
}
