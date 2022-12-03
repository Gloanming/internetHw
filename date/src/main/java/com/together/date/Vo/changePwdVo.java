package com.together.date.Vo;

import lombok.Data;

@Data
public class changePwdVo {
    private String newPwd;
    private String id;
    public changePwdVo(String newPwd, String id) {
        this.newPwd = newPwd;
        this.id = id;
    }
}
