/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  jakarta.persistence.Column
 *  jakarta.persistence.Entity
 *  jakarta.persistence.Id
 */
package com.stagwell.stagwellapp.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import java.util.Date;

@Entity
public class UserSession {
    private String email;
    private int userId;
    @Id
    private String sessionId;
    @Column(name="is_active")
    private boolean isActive;
    @Column(name="login_time")
    private Date loginTime = new Date();
    private Date lastHeartBeat = new Date();

    public String getEmail() {
        return this.email;
    }

    public int getUserId() {
        return this.userId;
    }

    public String getSessionId() {
        return this.sessionId;
    }

    public boolean isActive() {
        return this.isActive;
    }

    public Date getLoginTime() {
        return this.loginTime;
    }

    public Date getLastHeartBeat() {
        return this.lastHeartBeat;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public void setActive(boolean isActive) {
        this.isActive = isActive;
    }

    public void setLoginTime(Date loginTime) {
        this.loginTime = loginTime;
    }

    public void setLastHeartBeat(Date lastHeartBeat) {
        this.lastHeartBeat = lastHeartBeat;
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof UserSession)) {
            return false;
        }
        UserSession other = (UserSession)o;
        if (!other.canEqual(this)) {
            return false;
        }
        if (this.getUserId() != other.getUserId()) {
            return false;
        }
        if (this.isActive() != other.isActive()) {
            return false;
        }
        String this$email = this.getEmail();
        String other$email = other.getEmail();
        if (this$email == null ? other$email != null : !this$email.equals(other$email)) {
            return false;
        }
        String this$sessionId = this.getSessionId();
        String other$sessionId = other.getSessionId();
        if (this$sessionId == null ? other$sessionId != null : !this$sessionId.equals(other$sessionId)) {
            return false;
        }
        Date this$loginTime = this.getLoginTime();
        Date other$loginTime = other.getLoginTime();
        if (this$loginTime == null ? other$loginTime != null : !((Object)this$loginTime).equals(other$loginTime)) {
            return false;
        }
        Date this$lastHeartBeat = this.getLastHeartBeat();
        Date other$lastHeartBeat = other.getLastHeartBeat();
        return !(this$lastHeartBeat == null ? other$lastHeartBeat != null : !((Object)this$lastHeartBeat).equals(other$lastHeartBeat));
    }

    protected boolean canEqual(Object other) {
        return other instanceof UserSession;
    }

    public int hashCode() {
        int PRIME = 59;
        int result = 1;
        result = result * 59 + this.getUserId();
        result = result * 59 + (this.isActive() ? 79 : 97);
        String $email = this.getEmail();
        result = result * 59 + ($email == null ? 43 : $email.hashCode());
        String $sessionId = this.getSessionId();
        result = result * 59 + ($sessionId == null ? 43 : $sessionId.hashCode());
        Date $loginTime = this.getLoginTime();
        result = result * 59 + ($loginTime == null ? 43 : ((Object)$loginTime).hashCode());
        Date $lastHeartBeat = this.getLastHeartBeat();
        result = result * 59 + ($lastHeartBeat == null ? 43 : ((Object)$lastHeartBeat).hashCode());
        return result;
    }

    public String toString() {
        return "UserSession(email=" + this.getEmail() + ", userId=" + this.getUserId() + ", sessionId=" + this.getSessionId() + ", isActive=" + this.isActive() + ", loginTime=" + String.valueOf(this.getLoginTime()) + ", lastHeartBeat=" + String.valueOf(this.getLastHeartBeat()) + ")";
    }
}
