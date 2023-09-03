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
public class ScenarioEvent {

    @Column(name = "scenario_event_property")
    @Enumerated(EnumType.STRING)
    private ScenarioEventProperty property;

    @Column(name = "scenario_event_action")
    @Enumerated(EnumType.STRING)
    private ScenarioEventAction action;

    @Column(name = "scenario_event_amount")
    private Integer amount;
}
