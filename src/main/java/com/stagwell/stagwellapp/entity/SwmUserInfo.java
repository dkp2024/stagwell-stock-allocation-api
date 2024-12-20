/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  jakarta.persistence.Column
 *  jakarta.persistence.Entity
 *  jakarta.persistence.Id
 *  jakarta.persistence.Table
 */
package com.stagwell.stagwellapp.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.Date;

@Entity
@Table(name="SWM_USER_INFO")
public class SwmUserInfo {
    @Id
    @Column(name="user_id")
    private int userId;
    @Column(name="agency_name")
    private String agencyName;
    @Column(name="entity", length=10)
    private String entity;
    @Column(name="user_type", length=50)
    private String userType;
    @Column(name="created_by", length=50)
    private String createdBy;
    @Column(name="updated_dt")
    private Date updatedDate;
    @Column(name="email_address")
    private String emailAddress;

    public int getUserId() {
        return this.userId;
    }

    public String getAgencyName() {
        return this.agencyName;
    }

    public String getEntity() {
        return this.entity;
    }

    public String getUserType() {
        return this.userType;
    }

    public String getCreatedBy() {
        return this.createdBy;
    }

    public Date getUpdatedDate() {
        return this.updatedDate;
    }

    public String getEmailAddress() {
        return this.emailAddress;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setAgencyName(String agencyName) {
        this.agencyName = agencyName;
    }

    public void setEntity(String entity) {
        this.entity = entity;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof SwmUserInfo)) {
            return false;
        }
        SwmUserInfo other = (SwmUserInfo)o;
        if (!other.canEqual(this)) {
            return false;
        }
        if (this.getUserId() != other.getUserId()) {
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
        String this$userType = this.getUserType();
        String other$userType = other.getUserType();
        if (this$userType == null ? other$userType != null : !this$userType.equals(other$userType)) {
            return false;
        }
        String this$createdBy = this.getCreatedBy();
        String other$createdBy = other.getCreatedBy();
        if (this$createdBy == null ? other$createdBy != null : !this$createdBy.equals(other$createdBy)) {
            return false;
        }
        Date this$updatedDate = this.getUpdatedDate();
        Date other$updatedDate = other.getUpdatedDate();
        if (this$updatedDate == null ? other$updatedDate != null : !((Object)this$updatedDate).equals(other$updatedDate)) {
            return false;
        }
        String this$emailAddress = this.getEmailAddress();
        String other$emailAddress = other.getEmailAddress();
        return !(this$emailAddress == null ? other$emailAddress != null : !this$emailAddress.equals(other$emailAddress));
    }

    protected boolean canEqual(Object other) {
        return other instanceof SwmUserInfo;
    }

    public int hashCode() {
        int PRIME = 59;
        int result = 1;
        result = result * 59 + this.getUserId();
        String $agencyName = this.getAgencyName();
        result = result * 59 + ($agencyName == null ? 43 : $agencyName.hashCode());
        String $entity = this.getEntity();
        result = result * 59 + ($entity == null ? 43 : $entity.hashCode());
        String $userType = this.getUserType();
        result = result * 59 + ($userType == null ? 43 : $userType.hashCode());
        String $createdBy = this.getCreatedBy();
        result = result * 59 + ($createdBy == null ? 43 : $createdBy.hashCode());
        Date $updatedDate = this.getUpdatedDate();
        result = result * 59 + ($updatedDate == null ? 43 : ((Object)$updatedDate).hashCode());
        String $emailAddress = this.getEmailAddress();
        result = result * 59 + ($emailAddress == null ? 43 : $emailAddress.hashCode());
        return result;
    }

    public String toString() {
        return "SwmUserInfo(userId=" + this.getUserId() + ", agencyName=" + this.getAgencyName() + ", entity=" + this.getEntity() + ", userType=" + this.getUserType() + ", createdBy=" + this.getCreatedBy() + ", updatedDate=" + String.valueOf(this.getUpdatedDate()) + ", emailAddress=" + this.getEmailAddress() + ")";
    }
}
