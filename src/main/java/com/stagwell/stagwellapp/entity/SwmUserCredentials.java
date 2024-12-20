/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  jakarta.persistence.Entity
 *  jakarta.persistence.Id
 *  jakarta.persistence.Table
 */
package com.stagwell.stagwellapp.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name="swm_usercredentials")
public class SwmUserCredentials {
    @Id
    private int userId;
    private String userName;
    private String password;
    private Date lastlogin;
    private String status;
    private String createdBy;
    private Date updatedDt;

    public int getUserId() {
        return this.userId;
    }

    public String getUserName() {
        return this.userName;
    }

    public String getPassword() {
        return this.password;
    }

    public Date getLastlogin() {
        return this.lastlogin;
    }

    public String getStatus() {
        return this.status;
    }

    public String getCreatedBy() {
        return this.createdBy;
    }

    public Date getUpdatedDt() {
        return this.updatedDt;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setLastlogin(Date lastlogin) {
        this.lastlogin = lastlogin;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public void setUpdatedDt(Date updatedDt) {
        this.updatedDt = updatedDt;
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof SwmUserCredentials)) {
            return false;
        }
        SwmUserCredentials other = (SwmUserCredentials)o;
        if (!other.canEqual(this)) {
            return false;
        }
        if (this.getUserId() != other.getUserId()) {
            return false;
        }
        String this$userName = this.getUserName();
        String other$userName = other.getUserName();
        if (this$userName == null ? other$userName != null : !this$userName.equals(other$userName)) {
            return false;
        }
        String this$password = this.getPassword();
        String other$password = other.getPassword();
        if (this$password == null ? other$password != null : !this$password.equals(other$password)) {
            return false;
        }
        Date this$lastlogin = this.getLastlogin();
        Date other$lastlogin = other.getLastlogin();
        if (this$lastlogin == null ? other$lastlogin != null : !((Object)this$lastlogin).equals(other$lastlogin)) {
            return false;
        }
        String this$status = this.getStatus();
        String other$status = other.getStatus();
        if (this$status == null ? other$status != null : !this$status.equals(other$status)) {
            return false;
        }
        String this$createdBy = this.getCreatedBy();
        String other$createdBy = other.getCreatedBy();
        if (this$createdBy == null ? other$createdBy != null : !this$createdBy.equals(other$createdBy)) {
            return false;
        }
        Date this$updatedDt = this.getUpdatedDt();
        Date other$updatedDt = other.getUpdatedDt();
        return !(this$updatedDt == null ? other$updatedDt != null : !((Object)this$updatedDt).equals(other$updatedDt));
    }

    protected boolean canEqual(Object other) {
        return other instanceof SwmUserCredentials;
    }

    public int hashCode() {
        int PRIME = 59;
        int result = 1;
        result = result * 59 + this.getUserId();
        String $userName = this.getUserName();
        result = result * 59 + ($userName == null ? 43 : $userName.hashCode());
        String $password = this.getPassword();
        result = result * 59 + ($password == null ? 43 : $password.hashCode());
        Date $lastlogin = this.getLastlogin();
        result = result * 59 + ($lastlogin == null ? 43 : ((Object)$lastlogin).hashCode());
        String $status = this.getStatus();
        result = result * 59 + ($status == null ? 43 : $status.hashCode());
        String $createdBy = this.getCreatedBy();
        result = result * 59 + ($createdBy == null ? 43 : $createdBy.hashCode());
        Date $updatedDt = this.getUpdatedDt();
        result = result * 59 + ($updatedDt == null ? 43 : ((Object)$updatedDt).hashCode());
        return result;
    }

    public String toString() {
        return "SwmUserCredentials(userId=" + this.getUserId() + ", userName=" + this.getUserName() + ", password=" + this.getPassword() + ", lastlogin=" + String.valueOf(this.getLastlogin()) + ", status=" + this.getStatus() + ", createdBy=" + this.getCreatedBy() + ", updatedDt=" + String.valueOf(this.getUpdatedDt()) + ")";
    }
}
