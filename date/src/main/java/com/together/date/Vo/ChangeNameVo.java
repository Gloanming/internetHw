package com.together.date.Vo;

import lombok.Data;

@Data
public class ChangeNameVo {
    private String newInform;
    private String id;
    public ChangeNameVo(String name, String id) {
        newInform = name;
        this.id = id;
    }

}
