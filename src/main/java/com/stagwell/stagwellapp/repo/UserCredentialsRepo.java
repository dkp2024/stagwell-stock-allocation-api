/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.stagwell.stagwellapp.entity.SwmUserCredentials
 *  org.springframework.data.jpa.repository.JpaRepository
 *  org.springframework.stereotype.Repository
 */
package com.stagwell.stagwellapp.repo;

import com.stagwell.stagwellapp.entity.SwmUserCredentials;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserCredentialsRepo
extends JpaRepository<SwmUserCredentials, Integer> {
    public SwmUserCredentials getSwmUserCredentialsByUserId(int var1);

    public SwmUserCredentials getSwmUserCredentialsByUserName(String email);
}
