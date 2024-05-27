package com.example.openapitest.domain.artifactSet.application;

import com.example.openapitest.domain.artifactSet.domain.entity.ArtifactSet;
import com.example.openapitest.domain.artifactSet.domain.enums.Stat;
import com.example.openapitest.domain.chatGPT.application.ChatGptService;
import lombok.RequiredArgsConstructor;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ArtifactSetService {

    private final ChatGptService chatGptService;

    public ArtifactSet generateArtifactSet(String name, String setSentence) {
        String prompt = setSentence + "\n이 문장에서 스탯과 수치와 확률여부를 추출해서 json 형태로 줘. 확률여부는 단위가 %일 경우에는 true, 아닐 경우에는 false야. 없는 항목에 대해서는 null로 넣어줘.";
        String answer = chatGptService.getAnswer(prompt);
        JSONObject jsonObject = new JSONObject(answer);

        Stat stat = extractStat(jsonObject.getString("스탯"));
        int value = 0;
        boolean isPercent = false;
        if(stat != null) {
            value = jsonObject.getInt("수치");
            isPercent = jsonObject.getBoolean("확률여부");
        }
        return new ArtifactSet(name, stat, value, isPercent);
    }

    private Stat extractStat(String statName) {
        return Stat.findByLabel(statName);
    }
}
