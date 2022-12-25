package com.together.date.Vo;

import lombok.Data;

@Data
public class activity_participantVo {
    public String activityId;
    public String userId;

    public activity_participantVo(String activityId, String userId) {
        this.activityId = activityId;
        this.userId = userId;
    }
}
