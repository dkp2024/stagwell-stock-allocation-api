/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.annotation.JsonIgnore
 */
package com.stagwell.stagwellapp.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.Date;

public class EmployeeDto {
    private final String firstName;
    private final String lastName;
    private final String jobTitle;
    private String agencyName;
    private String entity;
    private final String employeeId;
    private Double baseCompPresent;
    private Double cashBonusPresent;
    private Double stockBonusPresent;
    private Double stockPremiumPresent;
    private Double totalBonusPresent;
    private Double baseCompPrevious;
    private Double cashBonusPrevious;
    private Double stockBonusPrevious;
    private Double stockPremiumPrevious;
    private Double totalBonusPrevious;
    private int vesting;
    private int vestingPremiumPercentage;
    private int year;
    private String costType;
    private Double retentionCurrentYear;
    private String ssn;
    private String fullName;
    private String emailAddress;
    private String homeAddress;
    private String homeAddressCity;
    private String homeAddressStateCode;
    private String homeAddressStateName;
    private String homeAddressZipCode;
    private String homeAddressCountry;
    private String countryOfPayrollTaxation;
    private Date birthDate;
    private Date hireDate;
    private int agencyID;
    private boolean submitted;
    @JsonIgnore
    private String status;
    private int entityId;

    public EmployeeDto(String firstName, String lastName, String jobTitle, String employeeId) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.jobTitle = jobTitle;
        this.employeeId = employeeId;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public String getJobTitle() {
        return this.jobTitle;
    }

    public String getAgencyName() {
        return this.agencyName;
    }

    public String getEntity() {
        return this.entity;
    }

    public String getEmployeeId() {
        return this.employeeId;
    }

    public Double getBaseCompPresent() {
        return this.baseCompPresent;
    }

    public Double getCashBonusPresent() {
        return this.cashBonusPresent;
    }

    public Double getStockBonusPresent() {
        return this.stockBonusPresent;
    }

    public Double getStockPremiumPresent() {
        return this.stockPremiumPresent;
    }

    public Double getTotalBonusPresent() {
        return this.totalBonusPresent;
    }

    public Double getBaseCompPrevious() {
        return this.baseCompPrevious;
    }

    public Double getCashBonusPrevious() {
        return this.cashBonusPrevious;
    }

    public Double getStockBonusPrevious() {
        return this.stockBonusPrevious;
    }

    public Double getStockPremiumPrevious() {
        return this.stockPremiumPrevious;
    }

    public Double getTotalBonusPrevious() {
        return this.totalBonusPrevious;
    }

    public int getVesting() {
        return this.vesting;
    }

    public int getVestingPremiumPercentage() {
        return this.vestingPremiumPercentage;
    }

    public int getYear() {
        return this.year;
    }

    public String getCostType() {
        return this.costType;
    }

    public Double getRetentionCurrentYear() {
        return this.retentionCurrentYear;
    }

    public String getSsn() {
        return this.ssn;
    }

    public String getFullName() {
        return this.fullName;
    }

    public String getEmailAddress() {
        return this.emailAddress;
    }

    public String getHomeAddress() {
        return this.homeAddress;
    }

    public String getHomeAddressCity() {
        return this.homeAddressCity;
    }

    public String getHomeAddressStateCode() {
        return this.homeAddressStateCode;
    }

    public String getHomeAddressStateName() {
        return this.homeAddressStateName;
    }

    public String getHomeAddressZipCode() {
        return this.homeAddressZipCode;
    }

    public String getHomeAddressCountry() {
        return this.homeAddressCountry;
    }

    public String getCountryOfPayrollTaxation() {
        return this.countryOfPayrollTaxation;
    }

    public Date getBirthDate() {
        return this.birthDate;
    }

    public Date getHireDate() {
        return this.hireDate;
    }

    public int getAgencyID() {
        return this.agencyID;
    }

    public boolean isSubmitted() {
        return this.submitted;
    }

    public String getStatus() {
        return this.status;
    }

    public int getEntityId() {
        return this.entityId;
    }

    public void setAgencyName(String agencyName) {
        this.agencyName = agencyName;
    }

    public void setEntity(String entity) {
        this.entity = entity;
    }

    public void setBaseCompPresent(Double baseCompPresent) {
        this.baseCompPresent = baseCompPresent;
    }

    public void setCashBonusPresent(Double cashBonusPresent) {
        this.cashBonusPresent = cashBonusPresent;
    }

    public void setStockBonusPresent(Double stockBonusPresent) {
        this.stockBonusPresent = stockBonusPresent;
    }

    public void setStockPremiumPresent(Double stockPremiumPresent) {
        this.stockPremiumPresent = stockPremiumPresent;
    }

    public void setTotalBonusPresent(Double totalBonusPresent) {
        this.totalBonusPresent = totalBonusPresent;
    }

    public void setBaseCompPrevious(Double baseCompPrevious) {
        this.baseCompPrevious = baseCompPrevious;
    }

    public void setCashBonusPrevious(Double cashBonusPrevious) {
        this.cashBonusPrevious = cashBonusPrevious;
    }

    public void setStockBonusPrevious(Double stockBonusPrevious) {
        this.stockBonusPrevious = stockBonusPrevious;
    }

    public void setStockPremiumPrevious(Double stockPremiumPrevious) {
        this.stockPremiumPrevious = stockPremiumPrevious;
    }

    public void setTotalBonusPrevious(Double totalBonusPrevious) {
        this.totalBonusPrevious = totalBonusPrevious;
    }

    public void setVesting(int vesting) {
        this.vesting = vesting;
    }

    public void setVestingPremiumPercentage(int vestingPremiumPercentage) {
        this.vestingPremiumPercentage = vestingPremiumPercentage;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setCostType(String costType) {
        this.costType = costType;
    }

    public void setRetentionCurrentYear(Double retentionCurrentYear) {
        this.retentionCurrentYear = retentionCurrentYear;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public void setHomeAddress(String homeAddress) {
        this.homeAddress = homeAddress;
    }

    public void setHomeAddressCity(String homeAddressCity) {
        this.homeAddressCity = homeAddressCity;
    }

    public void setHomeAddressStateCode(String homeAddressStateCode) {
        this.homeAddressStateCode = homeAddressStateCode;
    }

    public void setHomeAddressStateName(String homeAddressStateName) {
        this.homeAddressStateName = homeAddressStateName;
    }

    public void setHomeAddressZipCode(String homeAddressZipCode) {
        this.homeAddressZipCode = homeAddressZipCode;
    }

    public void setHomeAddressCountry(String homeAddressCountry) {
        this.homeAddressCountry = homeAddressCountry;
    }

    public void setCountryOfPayrollTaxation(String countryOfPayrollTaxation) {
        this.countryOfPayrollTaxation = countryOfPayrollTaxation;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }

    public void setAgencyID(int agencyID) {
        this.agencyID = agencyID;
    }

    public void setSubmitted(boolean submitted) {
        this.submitted = submitted;
    }

    @JsonIgnore
    public void setStatus(String status) {
        this.status = status;
    }

    public void setEntityId(int entityId) {
        this.entityId = entityId;
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof EmployeeDto)) {
            return false;
        }
        EmployeeDto other = (EmployeeDto)o;
        if (!other.canEqual(this)) {
            return false;
        }
        if (this.getVesting() != other.getVesting()) {
            return false;
        }
        if (this.getVestingPremiumPercentage() != other.getVestingPremiumPercentage()) {
            return false;
        }
        if (this.getYear() != other.getYear()) {
            return false;
        }
        if (this.getAgencyID() != other.getAgencyID()) {
            return false;
        }
        if (this.isSubmitted() != other.isSubmitted()) {
            return false;
        }
        if (this.getEntityId() != other.getEntityId()) {
            return false;
        }
        Double this$baseCompPresent = this.getBaseCompPresent();
        Double other$baseCompPresent = other.getBaseCompPresent();
        if (this$baseCompPresent == null ? other$baseCompPresent != null : !((Object)this$baseCompPresent).equals(other$baseCompPresent)) {
            return false;
        }
        Double this$cashBonusPresent = this.getCashBonusPresent();
        Double other$cashBonusPresent = other.getCashBonusPresent();
        if (this$cashBonusPresent == null ? other$cashBonusPresent != null : !((Object)this$cashBonusPresent).equals(other$cashBonusPresent)) {
            return false;
        }
        Double this$stockBonusPresent = this.getStockBonusPresent();
        Double other$stockBonusPresent = other.getStockBonusPresent();
        if (this$stockBonusPresent == null ? other$stockBonusPresent != null : !((Object)this$stockBonusPresent).equals(other$stockBonusPresent)) {
            return false;
        }
        Double this$stockPremiumPresent = this.getStockPremiumPresent();
        Double other$stockPremiumPresent = other.getStockPremiumPresent();
        if (this$stockPremiumPresent == null ? other$stockPremiumPresent != null : !((Object)this$stockPremiumPresent).equals(other$stockPremiumPresent)) {
            return false;
        }
        Double this$totalBonusPresent = this.getTotalBonusPresent();
        Double other$totalBonusPresent = other.getTotalBonusPresent();
        if (this$totalBonusPresent == null ? other$totalBonusPresent != null : !((Object)this$totalBonusPresent).equals(other$totalBonusPresent)) {
            return false;
        }
        Double this$baseCompPrevious = this.getBaseCompPrevious();
        Double other$baseCompPrevious = other.getBaseCompPrevious();
        if (this$baseCompPrevious == null ? other$baseCompPrevious != null : !((Object)this$baseCompPrevious).equals(other$baseCompPrevious)) {
            return false;
        }
        Double this$cashBonusPrevious = this.getCashBonusPrevious();
        Double other$cashBonusPrevious = other.getCashBonusPrevious();
        if (this$cashBonusPrevious == null ? other$cashBonusPrevious != null : !((Object)this$cashBonusPrevious).equals(other$cashBonusPrevious)) {
            return false;
        }
        Double this$stockBonusPrevious = this.getStockBonusPrevious();
        Double other$stockBonusPrevious = other.getStockBonusPrevious();
        if (this$stockBonusPrevious == null ? other$stockBonusPrevious != null : !((Object)this$stockBonusPrevious).equals(other$stockBonusPrevious)) {
            return false;
        }
        Double this$stockPremiumPrevious = this.getStockPremiumPrevious();
        Double other$stockPremiumPrevious = other.getStockPremiumPrevious();
        if (this$stockPremiumPrevious == null ? other$stockPremiumPrevious != null : !((Object)this$stockPremiumPrevious).equals(other$stockPremiumPrevious)) {
            return false;
        }
        Double this$totalBonusPrevious = this.getTotalBonusPrevious();
        Double other$totalBonusPrevious = other.getTotalBonusPrevious();
        if (this$totalBonusPrevious == null ? other$totalBonusPrevious != null : !((Object)this$totalBonusPrevious).equals(other$totalBonusPrevious)) {
            return false;
        }
        Double this$retentionCurrentYear = this.getRetentionCurrentYear();
        Double other$retentionCurrentYear = other.getRetentionCurrentYear();
        if (this$retentionCurrentYear == null ? other$retentionCurrentYear != null : !((Object)this$retentionCurrentYear).equals(other$retentionCurrentYear)) {
            return false;
        }
        String this$firstName = this.getFirstName();
        String other$firstName = other.getFirstName();
        if (this$firstName == null ? other$firstName != null : !this$firstName.equals(other$firstName)) {
            return false;
        }
        String this$lastName = this.getLastName();
        String other$lastName = other.getLastName();
        if (this$lastName == null ? other$lastName != null : !this$lastName.equals(other$lastName)) {
            return false;
        }
        String this$jobTitle = this.getJobTitle();
        String other$jobTitle = other.getJobTitle();
        if (this$jobTitle == null ? other$jobTitle != null : !this$jobTitle.equals(other$jobTitle)) {
            return false;
        }
        String this$agencyName = this.getAgencyName();
        String other$agencyName = other.getAgencyName();
        if (this$agencyName == null ? other$agencyName != null : !this$agencyName.equals(other$agencyName)) {
            return false;
        }
        String this$entity = this.getEntity();
        String other$entity = other.getEntity();
        if (this$entity == null ? other$entity != null : !this$entity.equals(other$entity)) {
            return false;
        }
        String this$employeeId = this.getEmployeeId();
        String other$employeeId = other.getEmployeeId();
        if (this$employeeId == null ? other$employeeId != null : !this$employeeId.equals(other$employeeId)) {
            return false;
        }
        String this$costType = this.getCostType();
        String other$costType = other.getCostType();
        if (this$costType == null ? other$costType != null : !this$costType.equals(other$costType)) {
            return false;
        }
        String this$ssn = this.getSsn();
        String other$ssn = other.getSsn();
        if (this$ssn == null ? other$ssn != null : !this$ssn.equals(other$ssn)) {
            return false;
        }
        String this$fullName = this.getFullName();
        String other$fullName = other.getFullName();
        if (this$fullName == null ? other$fullName != null : !this$fullName.equals(other$fullName)) {
            return false;
        }
        String this$emailAddress = this.getEmailAddress();
        String other$emailAddress = other.getEmailAddress();
        if (this$emailAddress == null ? other$emailAddress != null : !this$emailAddress.equals(other$emailAddress)) {
            return false;
        }
        String this$homeAddress = this.getHomeAddress();
        String other$homeAddress = other.getHomeAddress();
        if (this$homeAddress == null ? other$homeAddress != null : !this$homeAddress.equals(other$homeAddress)) {
            return false;
        }
        String this$homeAddressCity = this.getHomeAddressCity();
        String other$homeAddressCity = other.getHomeAddressCity();
        if (this$homeAddressCity == null ? other$homeAddressCity != null : !this$homeAddressCity.equals(other$homeAddressCity)) {
            return false;
        }
        String this$homeAddressStateCode = this.getHomeAddressStateCode();
        String other$homeAddressStateCode = other.getHomeAddressStateCode();
        if (this$homeAddressStateCode == null ? other$homeAddressStateCode != null : !this$homeAddressStateCode.equals(other$homeAddressStateCode)) {
            return false;
        }
        String this$homeAddressStateName = this.getHomeAddressStateName();
        String other$homeAddressStateName = other.getHomeAddressStateName();
        if (this$homeAddressStateName == null ? other$homeAddressStateName != null : !this$homeAddressStateName.equals(other$homeAddressStateName)) {
            return false;
        }
        String this$homeAddressZipCode = this.getHomeAddressZipCode();
        String other$homeAddressZipCode = other.getHomeAddressZipCode();
        if (this$homeAddressZipCode == null ? other$homeAddressZipCode != null : !this$homeAddressZipCode.equals(other$homeAddressZipCode)) {
            return false;
        }
        String this$homeAddressCountry = this.getHomeAddressCountry();
        String other$homeAddressCountry = other.getHomeAddressCountry();
        if (this$homeAddressCountry == null ? other$homeAddressCountry != null : !this$homeAddressCountry.equals(other$homeAddressCountry)) {
            return false;
        }
        String this$countryOfPayrollTaxation = this.getCountryOfPayrollTaxation();
        String other$countryOfPayrollTaxation = other.getCountryOfPayrollTaxation();
        if (this$countryOfPayrollTaxation == null ? other$countryOfPayrollTaxation != null : !this$countryOfPayrollTaxation.equals(other$countryOfPayrollTaxation)) {
            return false;
        }
        Date this$birthDate = this.getBirthDate();
        Date other$birthDate = other.getBirthDate();
        if (this$birthDate == null ? other$birthDate != null : !((Object)this$birthDate).equals(other$birthDate)) {
            return false;
        }
        Date this$hireDate = this.getHireDate();
        Date other$hireDate = other.getHireDate();
        if (this$hireDate == null ? other$hireDate != null : !((Object)this$hireDate).equals(other$hireDate)) {
            return false;
        }
        String this$status = this.getStatus();
        String other$status = other.getStatus();
        return !(this$status == null ? other$status != null : !this$status.equals(other$status));
    }

    protected boolean canEqual(Object other) {
        return other instanceof EmployeeDto;
    }

    public int hashCode() {
        int PRIME = 59;
        int result = 1;
        result = result * 59 + this.getVesting();
        result = result * 59 + this.getVestingPremiumPercentage();
        result = result * 59 + this.getYear();
        result = result * 59 + this.getAgencyID();
        result = result * 59 + (this.isSubmitted() ? 79 : 97);
        result = result * 59 + this.getEntityId();
        Double $baseCompPresent = this.getBaseCompPresent();
        result = result * 59 + ($baseCompPresent == null ? 43 : ((Object)$baseCompPresent).hashCode());
        Double $cashBonusPresent = this.getCashBonusPresent();
        result = result * 59 + ($cashBonusPresent == null ? 43 : ((Object)$cashBonusPresent).hashCode());
        Double $stockBonusPresent = this.getStockBonusPresent();
        result = result * 59 + ($stockBonusPresent == null ? 43 : ((Object)$stockBonusPresent).hashCode());
        Double $stockPremiumPresent = this.getStockPremiumPresent();
        result = result * 59 + ($stockPremiumPresent == null ? 43 : ((Object)$stockPremiumPresent).hashCode());
        Double $totalBonusPresent = this.getTotalBonusPresent();
        result = result * 59 + ($totalBonusPresent == null ? 43 : ((Object)$totalBonusPresent).hashCode());
        Double $baseCompPrevious = this.getBaseCompPrevious();
        result = result * 59 + ($baseCompPrevious == null ? 43 : ((Object)$baseCompPrevious).hashCode());
        Double $cashBonusPrevious = this.getCashBonusPrevious();
        result = result * 59 + ($cashBonusPrevious == null ? 43 : ((Object)$cashBonusPrevious).hashCode());
        Double $stockBonusPrevious = this.getStockBonusPrevious();
        result = result * 59 + ($stockBonusPrevious == null ? 43 : ((Object)$stockBonusPrevious).hashCode());
        Double $stockPremiumPrevious = this.getStockPremiumPrevious();
        result = result * 59 + ($stockPremiumPrevious == null ? 43 : ((Object)$stockPremiumPrevious).hashCode());
        Double $totalBonusPrevious = this.getTotalBonusPrevious();
        result = result * 59 + ($totalBonusPrevious == null ? 43 : ((Object)$totalBonusPrevious).hashCode());
        Double $retentionCurrentYear = this.getRetentionCurrentYear();
        result = result * 59 + ($retentionCurrentYear == null ? 43 : ((Object)$retentionCurrentYear).hashCode());
        String $firstName = this.getFirstName();
        result = result * 59 + ($firstName == null ? 43 : $firstName.hashCode());
        String $lastName = this.getLastName();
        result = result * 59 + ($lastName == null ? 43 : $lastName.hashCode());
        String $jobTitle = this.getJobTitle();
        result = result * 59 + ($jobTitle == null ? 43 : $jobTitle.hashCode());
        String $agencyName = this.getAgencyName();
        result = result * 59 + ($agencyName == null ? 43 : $agencyName.hashCode());
        String $entity = this.getEntity();
        result = result * 59 + ($entity == null ? 43 : $entity.hashCode());
        String $employeeId = this.getEmployeeId();
        result = result * 59 + ($employeeId == null ? 43 : $employeeId.hashCode());
        String $costType = this.getCostType();
        result = result * 59 + ($costType == null ? 43 : $costType.hashCode());
        String $ssn = this.getSsn();
        result = result * 59 + ($ssn == null ? 43 : $ssn.hashCode());
        String $fullName = this.getFullName();
        result = result * 59 + ($fullName == null ? 43 : $fullName.hashCode());
        String $emailAddress = this.getEmailAddress();
        result = result * 59 + ($emailAddress == null ? 43 : $emailAddress.hashCode());
        String $homeAddress = this.getHomeAddress();
        result = result * 59 + ($homeAddress == null ? 43 : $homeAddress.hashCode());
        String $homeAddressCity = this.getHomeAddressCity();
        result = result * 59 + ($homeAddressCity == null ? 43 : $homeAddressCity.hashCode());
        String $homeAddressStateCode = this.getHomeAddressStateCode();
        result = result * 59 + ($homeAddressStateCode == null ? 43 : $homeAddressStateCode.hashCode());
        String $homeAddressStateName = this.getHomeAddressStateName();
        result = result * 59 + ($homeAddressStateName == null ? 43 : $homeAddressStateName.hashCode());
        String $homeAddressZipCode = this.getHomeAddressZipCode();
        result = result * 59 + ($homeAddressZipCode == null ? 43 : $homeAddressZipCode.hashCode());
        String $homeAddressCountry = this.getHomeAddressCountry();
        result = result * 59 + ($homeAddressCountry == null ? 43 : $homeAddressCountry.hashCode());
        String $countryOfPayrollTaxation = this.getCountryOfPayrollTaxation();
        result = result * 59 + ($countryOfPayrollTaxation == null ? 43 : $countryOfPayrollTaxation.hashCode());
        Date $birthDate = this.getBirthDate();
        result = result * 59 + ($birthDate == null ? 43 : ((Object)$birthDate).hashCode());
        Date $hireDate = this.getHireDate();
        result = result * 59 + ($hireDate == null ? 43 : ((Object)$hireDate).hashCode());
        String $status = this.getStatus();
        result = result * 59 + ($status == null ? 43 : $status.hashCode());
        return result;
    }

    public String toString() {
        return "EmployeeDto(firstName=" + this.getFirstName() + ", lastName=" + this.getLastName() + ", jobTitle=" + this.getJobTitle() + ", agencyName=" + this.getAgencyName() + ", entity=" + this.getEntity() + ", employeeId=" + this.getEmployeeId() + ", baseCompPresent=" + this.getBaseCompPresent() + ", cashBonusPresent=" + this.getCashBonusPresent() + ", stockBonusPresent=" + this.getStockBonusPresent() + ", stockPremiumPresent=" + this.getStockPremiumPresent() + ", totalBonusPresent=" + this.getTotalBonusPresent() + ", baseCompPrevious=" + this.getBaseCompPrevious() + ", cashBonusPrevious=" + this.getCashBonusPrevious() + ", stockBonusPrevious=" + this.getStockBonusPrevious() + ", stockPremiumPrevious=" + this.getStockPremiumPrevious() + ", totalBonusPrevious=" + this.getTotalBonusPrevious() + ", vesting=" + this.getVesting() + ", vestingPremiumPercentage=" + this.getVestingPremiumPercentage() + ", year=" + this.getYear() + ", costType=" + this.getCostType() + ", retentionCurrentYear=" + this.getRetentionCurrentYear() + ", ssn=" + this.getSsn() + ", fullName=" + this.getFullName() + ", emailAddress=" + this.getEmailAddress() + ", homeAddress=" + this.getHomeAddress() + ", homeAddressCity=" + this.getHomeAddressCity() + ", homeAddressStateCode=" + this.getHomeAddressStateCode() + ", homeAddressStateName=" + this.getHomeAddressStateName() + ", homeAddressZipCode=" + this.getHomeAddressZipCode() + ", homeAddressCountry=" + this.getHomeAddressCountry() + ", countryOfPayrollTaxation=" + this.getCountryOfPayrollTaxation() + ", birthDate=" + String.valueOf(this.getBirthDate()) + ", hireDate=" + String.valueOf(this.getHireDate()) + ", agencyID=" + this.getAgencyID() + ", submitted=" + this.isSubmitted() + ", status=" + this.getStatus() + ", entityId=" + this.getEntityId() + ")";
    }
}
