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
public class SwtAgencyBudgetAllocation {
    @Id
    @Column(name="AGENCY_ID")
    private String agencyId;
    @Column(name="NETWORK")
    private String network;
    @Column(name="overall_bonus_pool_budget")
    private double overallBonusPoolBudget;
    @Column(name="amount_allocated_to_cash")
    private double amountAllocatedForCash;
    @Column(name="amount_allocated_to_stock")
    private double amountAllocatedForStock;
    @Column(name="status")
    private String status;
    @Column(name="created_by")
    private String createdBy;
    @Column(name="updated_dt")
    private Date updatedDate;
}
