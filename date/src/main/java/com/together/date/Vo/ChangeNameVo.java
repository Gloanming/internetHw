package com.together.date.Vo;

import lombok.Data;

@Data
public class ChangeNameVo {
    private String name;
    private String id;
    public ChangeNameVo(String name, String id) {
        this.name = name;
        this.id = id;
    }

}
