package com.example.openapitest.domain.artifactSet.domain.enums;

import lombok.Getter;

@Getter
public enum Stat {

    ATK("공격력"),
    DEF("방어력"),
    EM("원소 마스터리"),
    HEALING_BONUS("치유 보너스"),
    HP("HP"),
    AMENO_BONUS("바람 원소 피해 보너스"),
    HYDRO_BONUS("물 원소 피해 보너스"),
    DENDRO_BONUS("풀 원소 피해 보너스"),
    ER("원소 충전 효율"),
    PYRO_BONUS("불 원소 피해 보너스"),
    ELECTRO_BONUS("번개 원소 피해 보너스"),
    CYRO_BONUS("얼음 원소 피해 보너스"),
    CRIT_RATE("치명타 확률"),
    GEO_BONUS("바위 원소 피해 보너스");

    private final String label;

    Stat(String label) {
        this.label = label;
    }

    public static Stat findByLabel(String label) {
        for(Stat stat : values()) {
            if(stat.getLabel().equals(label)) {
                return stat;
            }
        }
        return null;
    }
}
