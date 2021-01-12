package com.cloud.learning.jwt.service.impl;

import com.cloud.learning.jwt.dal.mapper.ResUserMapper;
import com.cloud.learning.jwt.dal.model.ResUser;
import com.cloud.learning.jwt.dto.UserRequestDto;
import com.cloud.learning.jwt.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.weekend.WeekendSqls;

/**
 * @ClassName: UserServiceImpl
 * @Description:
 * @Author: pzl
 * @CreateDate: 2021/1/12 14:25
 * @Version: 1.0
 */
@Service
@Slf4j
public class UserServiceImpl implements UserService {
    @Autowired
    private ResUserMapper userMapper;
    @Override
    public ResUser getUserByNameAndPwd(UserRequestDto userRequestDto) {
        WeekendSqls<ResUser> custom=WeekendSqls.custom();
        custom.andEqualTo(ResUser::getUsername,userRequestDto.getUsername());
        custom.andEqualTo(ResUser::getPassword,userRequestDto.getPassword());
        return userMapper.selectOneByExample(new Example.Builder(ResUser.class).where(custom).build());
    }
}
