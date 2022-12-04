package com.together.date.service.entity;

import lombok.Data;

@Data
public class user {
    private String userName;
    private String userPwd;
    private String userId;
    public String userSex;
    private String avatarUrl;
    private int userCreditIndex;
}
