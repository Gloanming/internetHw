package com.together.date.Vo;

import lombok.Data;

@Data
public class loginVo {
    private String identity; // 获取的code
    public String pwd;



    public loginVo(String openid, String pwd){
        this.identity = openid;
        this.pwd = pwd;
    }
}
