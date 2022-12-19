package com.together.date.Vo;

import lombok.Data;

@Data
public class creditVo {
    public String userId;
    public int thisUserCredit;
    public String command;

    public creditVo(String userId, int thisUserCredit, String command) {
        this.userId = userId;
        this.thisUserCredit = thisUserCredit;
        this.command = command;
    }
}
