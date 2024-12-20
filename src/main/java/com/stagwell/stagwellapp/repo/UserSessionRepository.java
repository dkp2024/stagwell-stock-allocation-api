/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.stagwell.stagwellapp.entity.UserSession
 *  org.springframework.data.jpa.repository.JpaRepository
 *  org.springframework.data.jpa.repository.Query
 *  org.springframework.stereotype.Repository
 */
package com.stagwell.stagwellapp.repo;

import com.stagwell.stagwellapp.entity.UserSession;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserSessionRepository
extends JpaRepository<UserSession, String> {
    public List<UserSession> getUserSessionByEmailAndIsActive(String email, boolean isActive);

    public UserSession getUserSessionBySessionIdAndIsActive(String session_Id, boolean isActive);

    @Query(nativeQuery=true, value="SELECT  user_id FROM swm_usercredentials WHERE password=:password AND user_name=:username")
    public Object validateCredentials(String username, String password);
}
