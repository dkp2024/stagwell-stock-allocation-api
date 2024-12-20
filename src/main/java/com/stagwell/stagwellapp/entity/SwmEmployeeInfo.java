/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  jakarta.persistence.Entity
 *  jakarta.persistence.Id
 *  jakarta.persistence.Table
 */
package com.stagwell.stagwellapp.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="SWM_EMPLOYEES_INFO")
public class SwmEmployeeInfo {
    private String firstName;
    private String lastName;
    private String jobTitle;
    @Id
    private String employeeId;
    private int agencyId;
    private String agencyName;
    private double cashBonus;
    private double stockBonus;
    private double totalBonus;
    private double stockPremium;
}
