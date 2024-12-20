/*
 * Decompiled with CFR 0.152.
 */
package com.stagwell.stagwellapp.dto;

public class UserAgencyDto {
    private String agencyName;
    private double overallBonusPoolBudget;
    private double amountForCash;
    private double amountForStock;
    private int agencyId;

    public String getAgencyName() {
        return this.agencyName;
    }

    public double getOverallBonusPoolBudget() {
        return this.overallBonusPoolBudget;
    }

    public double getAmountForCash() {
        return this.amountForCash;
    }

    public double getAmountForStock() {
        return this.amountForStock;
    }

    public int getAgencyId() {
        return this.agencyId;
    }

    public void setAgencyName(String agencyName) {
        this.agencyName = agencyName;
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

    public void setAgencyId(int agencyId) {
        this.agencyId = agencyId;
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof UserAgencyDto)) {
            return false;
        }
        UserAgencyDto other = (UserAgencyDto)o;
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
        if (this.getAgencyId() != other.getAgencyId()) {
            return false;
        }
        String this$agencyName = this.getAgencyName();
        String other$agencyName = other.getAgencyName();
        return !(this$agencyName == null ? other$agencyName != null : !this$agencyName.equals(other$agencyName));
    }

    protected boolean canEqual(Object other) {
        return other instanceof UserAgencyDto;
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
        result = result * 59 + this.getAgencyId();
        String $agencyName = this.getAgencyName();
        result = result * 59 + ($agencyName == null ? 43 : $agencyName.hashCode());
        return result;
    }

    public String toString() {
        return "UserAgencyDto(agencyName=" + this.getAgencyName() + ", overallBonusPoolBudget=" + this.getOverallBonusPoolBudget() + ", amountForCash=" + this.getAmountForCash() + ", amountForStock=" + this.getAmountForStock() + ", agencyId=" + this.getAgencyId() + ")";
    }
}
