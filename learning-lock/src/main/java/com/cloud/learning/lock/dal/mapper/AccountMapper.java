package com.cloud.learning.lock.dal.mapper;

import com.cloud.learning.lock.dal.model.Account;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.special.InsertListMapper;

public interface AccountMapper extends Mapper<Account>, InsertListMapper<Account> {
}