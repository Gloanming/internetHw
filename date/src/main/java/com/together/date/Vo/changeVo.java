package com.together.date.Vo;

import lombok.Data;

@Data
public class changeVo {
    String tags;
    String id;

    public changeVo(String tags, String id) {
        this.tags = tags;
        this.id = id;
    }
}
