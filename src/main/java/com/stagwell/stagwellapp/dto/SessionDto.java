/*
 * Decompiled with CFR 0.152.
 */
package com.stagwell.stagwellapp.dto;

public class SessionDto {
    private String sessionId;
    private String userType;
    private String userName;

    public String getSessionId() {
        return this.sessionId;
    }

    public String getUserType() {
        return this.userType;
    }

    public String getUserName() {
        return this.userName;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof SessionDto)) {
            return false;
        }
        SessionDto other = (SessionDto)o;
        if (!other.canEqual(this)) {
            return false;
        }
        String this$sessionId = this.getSessionId();
        String other$sessionId = other.getSessionId();
        if (this$sessionId == null ? other$sessionId != null : !this$sessionId.equals(other$sessionId)) {
            return false;
        }
        String this$userType = this.getUserType();
        String other$userType = other.getUserType();
        if (this$userType == null ? other$userType != null : !this$userType.equals(other$userType)) {
            return false;
        }
        String this$userName = this.getUserName();
        String other$userName = other.getUserName();
        return !(this$userName == null ? other$userName != null : !this$userName.equals(other$userName));
    }

    protected boolean canEqual(Object other) {
        return other instanceof SessionDto;
    }

    public int hashCode() {
        int PRIME = 59;
        int result = 1;
        String $sessionId = this.getSessionId();
        result = result * 59 + ($sessionId == null ? 43 : $sessionId.hashCode());
        String $userType = this.getUserType();
        result = result * 59 + ($userType == null ? 43 : $userType.hashCode());
        String $userName = this.getUserName();
        result = result * 59 + ($userName == null ? 43 : $userName.hashCode());
        return result;
    }

    public String toString() {
        return "SessionDto(sessionId=" + this.getSessionId() + ", userType=" + this.getUserType() + ", userName=" + this.getUserName() + ")";
    }

    public SessionDto(String sessionId, String userType, String userName) {
        this.sessionId = sessionId;
        this.userType = userType;
        this.userName = userName;
    }
}
