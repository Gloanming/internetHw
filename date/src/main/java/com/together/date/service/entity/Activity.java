package com.together.date.service.entity;

import lombok.Data;

@Data
public class Activity {
    String creatorId; //创建人ID
    int activityId; //活动id
    String activityType; //活动类型
    String head; // 标题
    String content; //内容

    String startTime;
    String endTime;//活动开始与结束时间，时间以字符串形式传递

    int viewCount;//浏览量
    int capacity;//活动最大参与人数
    int bookCount;//预约人数
    int likeCount;//点赞数
}
