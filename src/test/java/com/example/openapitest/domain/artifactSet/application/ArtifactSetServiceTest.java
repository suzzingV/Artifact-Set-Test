package com.example.openapitest.domain.artifactSet.application;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import com.example.openapitest.domain.artifactSet.domain.entity.ArtifactSet;
import com.example.openapitest.domain.artifactSet.domain.enums.Stat;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ArtifactSetServiceTest {

    @Autowired
    ArtifactSetService artifactSetService;

    String response1 = "공격력 +18%";

    String setName1 = "미완의 몽상";

    @Test
    @DisplayName("chatGPT를 이용해 문장에서 세트효과에 대한 정보를 추출할 수 있다.")
    public void getArtifactSet() {
        ArtifactSet artifactSet = artifactSetService.generateArtifactSet(setName1, response1);

        assertThat(artifactSet.getName()).isEqualTo(setName1);
        assertThat(artifactSet.getTwoSet()).isEqualTo(Stat.ATK);
        assertThat(artifactSet.getTwoSetValue()).isEqualTo(18);
        assertThat(artifactSet.isPercent()).isTrue();
    }
}