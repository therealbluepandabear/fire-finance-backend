package com.example.firefinancebackend.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Embedded;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Embeddable
public class Scenario {

    @Column(name = "scenario_name")
    private String name;

    @Column(name = "scenario_creation_date")
    private String creationDate;

    @Column(name = "scenario_trigger")
    @Embedded
    private ScenarioTrigger trigger;

    @Column(name = "scenario_event")
    @Embedded
    private ScenarioEvent event;
}
