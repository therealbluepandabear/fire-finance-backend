package com.example.firefinancebackend.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Embeddable
public class ScenarioTrigger {

    @Column(name = "scenario_trigger_property")
    @Enumerated(EnumType.STRING)
    private ScenarioTriggerProperty property;

    @Column(name = "scenario_trigger_value")
    private Integer value;
}
