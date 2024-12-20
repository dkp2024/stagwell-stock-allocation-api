/*
 * Decompiled with CFR 0.152.
 */
package com.stagwell.stagwellapp.dto;

public class LoginReqDto {
    private String email;
    private String password;

    public String getEmail() {
        return this.email;
    }

    public String getPassword() {
        return this.password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof LoginReqDto)) {
            return false;
        }
        LoginReqDto other = (LoginReqDto)o;
        if (!other.canEqual(this)) {
            return false;
        }
        String this$email = this.getEmail();
        String other$email = other.getEmail();
        if (this$email == null ? other$email != null : !this$email.equals(other$email)) {
            return false;
        }
        String this$password = this.getPassword();
        String other$password = other.getPassword();
        return !(this$password == null ? other$password != null : !this$password.equals(other$password));
    }

    protected boolean canEqual(Object other) {
        return other instanceof LoginReqDto;
    }

    public int hashCode() {
        int PRIME = 59;
        int result = 1;
        String $email = this.getEmail();
        result = result * 59 + ($email == null ? 43 : $email.hashCode());
        String $password = this.getPassword();
        result = result * 59 + ($password == null ? 43 : $password.hashCode());
        return result;
    }

    public String toString() {
        return "LoginReqDto(email=" + this.getEmail() + ", password=" + this.getPassword() + ")";
    }
}
