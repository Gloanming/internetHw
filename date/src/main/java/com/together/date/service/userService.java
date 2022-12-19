package com.together.date.service;

import com.together.date.Vo.creditVo;
import com.together.date.Vo.loginVo;
import com.together.date.Vo.registerVo;
import com.together.date.result.result;
import com.together.date.service.entity.user;

public interface userService {
    result add(user User);

    result login(loginVo LoginVo);
    result register(registerVo RegisterVo);

    result breakRule(creditVo CreditVo);

    result getInformation(user User);

}
