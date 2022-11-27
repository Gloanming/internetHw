package com.together.date.Vo;

import lombok.Data;

@Data
public class registerVo {
    private String identity; // 用户身份
    private String userName; //用户名
    private String avatarUrl; //头像地址
    private String sex;
    private String userPwd;
    private int userCredit;
    public registerVo(String identity, String userName, String avatarUrl, String sex, int userCredit, String userPwd) {
        this.identity = identity;
        this.userName = userName;
        this.avatarUrl = avatarUrl;
        this.sex = sex;
        this.userCredit = userCredit;
        this.userPwd = userPwd;
    }
}
