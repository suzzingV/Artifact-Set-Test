package com.example.openapitest.domain.artifactSet.domain.entity;

import com.example.openapitest.domain.artifactSet.domain.enums.Stat;
import lombok.Getter;

@Getter
public class ArtifactSet {

    private String name;

    private Stat twoSet;

    private int twoSetValue;

    private boolean isPercent;

    public ArtifactSet(String name, Stat twoSet, int twoSetValue, boolean isPercent) {
        this.name = name;
        this.twoSet = twoSet;
        this.twoSetValue = twoSetValue;
        this.isPercent = isPercent;
    }
}
