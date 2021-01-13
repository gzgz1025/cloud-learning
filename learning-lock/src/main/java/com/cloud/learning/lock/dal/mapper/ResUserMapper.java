package com.cloud.learning.lock.dal.mapper;

import com.cloud.learning.lock.dal.model.ResUser;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.special.InsertListMapper;

public interface ResUserMapper extends Mapper<ResUser>, InsertListMapper<ResUser> {
}