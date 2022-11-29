package com.together.date.Vo;

import lombok.Data;

@Data
public class loginVo {
    private String identity; // 获取的code

    public String userName; // 用户名

    public String avatarUrl; // 头像地址 (一般应该就是头像的图片)

    public String sex; // 性别

    public loginVo(String openid, String userName, String avatarUrl,String sex){
        this.identity = openid;
        this.userName = userName;
        this.avatarUrl = avatarUrl;
        this.sex = sex;
    }
}
