package com.schooltecher.api.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.UUID;

@Entity
public class Questions {

    @Id
    private UUID id;
}
