package com.example.firefinancebackend.domain;

import jakarta.annotation.Nullable;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Embeddable
public class PlanInputs {

    private Integer age;
    private Double annualIncome;
    private Double annualSpending;
    private Double networth;

    private Double safeWithdrawalRate;
    private Double inflationRate;

    private Double stocksAllocationRate;
    private Double bondsAllocationRate;
    private Double cashAllocationRate;

    private Double stocksReturnRate;
    private Double bondsReturnRate;
    private Double cashReturnRate;

    private Double incomeGrowthRate;
    private Integer retirementAge;
    private Integer maximumAge;
}
