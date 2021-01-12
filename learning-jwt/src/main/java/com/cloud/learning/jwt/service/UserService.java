package com.cloud.learning.jwt.service;

import com.cloud.learning.jwt.dal.model.ResUser;
import com.cloud.learning.jwt.dto.UserRequestDto;

/**
 * @ClassName: UserService
 * @Description:
 * @Author: pzl
 * @CreateDate: 2021/1/12 14:16
 * @Version: 1.0
 */
public interface UserService {
    ResUser getUserByNameAndPwd(UserRequestDto userRequestDto);
}
