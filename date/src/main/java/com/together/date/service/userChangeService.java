package com.together.date.service;

import com.together.date.result.result;

public interface userChangeService {
    result changeUserName(String newName, String Id);
    result changeUserSex(String sex, String Id);
    result changeUserAvatarUrl(String avatarUrl, String Id);
    result changeUserPwd(String pwd, String Id);
}
