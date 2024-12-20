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
@Table(name="SWT_OVERALL_BONUS_POOL_BUDGET")
public class SwtOverallBonusPoolBudget {
    private int employeeId;
    @Id
    private int bonusPoolBudgetId;
    private double cashBonus;
    private double stockBonus;
    private double totalBonus;
    private double stockPremium;
}
