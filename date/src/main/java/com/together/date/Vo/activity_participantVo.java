package com.together.date.Vo;

import lombok.Data;

@Data
public class activity_participantVo {
    public int activityId;
    public String userId;

    public activity_participantVo(int activityId, String userId) {
        this.activityId = activityId;
        this.userId = userId;
    }
}
