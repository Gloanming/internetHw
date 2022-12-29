package com.together.date.Vo;

import lombok.Data;

@Data
public class addActivityVo {
    private String creatorId; //创建人ID
    private static int activityId;
    public String activityType; //活动类型
    public String head; // 标题
    public String content; //内容

    public String startTime;
    public String endTime;//活动开始与结束时间，时间以字符串形式传递

    public int viewCount;//浏览量
    public int capacity;//活动最大参与人数
    public int bookCount;//预约人数
    public int likeCount;//点赞数
    public String activityCoverUrl;
    private static int digit = 0;

    public addActivityVo(String creatorId, String activityType, String head, String content, String startTime, String endTime, int viewCount, int capacity, int bookCount, int likeCount, String activityCoverUrl) {
        this.creatorId = creatorId;
        this.activityType = activityType;
        this.head = head;
        this.content = content;
        this.startTime = startTime;
        this.endTime = endTime;
        this.viewCount = viewCount;
        this.capacity = capacity;
        this.bookCount = bookCount;
        this.likeCount = likeCount;
        this.activityCoverUrl = activityCoverUrl;
    }
}
