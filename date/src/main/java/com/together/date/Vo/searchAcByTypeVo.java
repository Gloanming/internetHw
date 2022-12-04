package com.together.date.Vo;

import lombok.Data;

@Data
public class searchAcByTypeVo {
    public String searchType;

    public searchAcByTypeVo(String type){
        this.searchType = type;
    }
}
