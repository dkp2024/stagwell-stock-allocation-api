/*
 * Decompiled with CFR 0.152.
 */
package com.stagwell.stagwellapp.dto;

import java.util.Date;

public class UserDto {
    private int userId;
    private String userName;
    private int agencyId;
    private String agencyName;
    private String entity;
    private String userType;
    private String createdBy;
    private Date updatedDate;

    public int getUserId() {
        return this.userId;
    }

    public String getUserName() {
        return this.userName;
    }

    public int getAgencyId() {
        return this.agencyId;
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

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setAgencyId(int agencyId) {
        this.agencyId = agencyId;
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

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof UserDto)) {
            return false;
        }
        UserDto other = (UserDto)o;
        if (!other.canEqual(this)) {
            return false;
        }
        if (this.getUserId() != other.getUserId()) {
            return false;
        }
        if (this.getAgencyId() != other.getAgencyId()) {
            return false;
        }
        String this$userName = this.getUserName();
        String other$userName = other.getUserName();
        if (this$userName == null ? other$userName != null : !this$userName.equals(other$userName)) {
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
        return !(this$updatedDate == null ? other$updatedDate != null : !((Object)this$updatedDate).equals(other$updatedDate));
    }

    protected boolean canEqual(Object other) {
        return other instanceof UserDto;
    }

    public int hashCode() {
        int PRIME = 59;
        int result = 1;
        result = result * 59 + this.getUserId();
        result = result * 59 + this.getAgencyId();
        String $userName = this.getUserName();
        result = result * 59 + ($userName == null ? 43 : $userName.hashCode());
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
        return result;
    }

    public String toString() {
        return "UserDto(userId=" + this.getUserId() + ", userName=" + this.getUserName() + ", agencyId=" + this.getAgencyId() + ", agencyName=" + this.getAgencyName() + ", entity=" + this.getEntity() + ", userType=" + this.getUserType() + ", createdBy=" + this.getCreatedBy() + ", updatedDate=" + String.valueOf(this.getUpdatedDate()) + ")";
    }
}
