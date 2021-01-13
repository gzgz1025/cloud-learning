package com.cloud.learning.lock.dal.mapper;

import com.cloud.learning.lock.dal.model.PayOrder;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.special.InsertListMapper;

public interface PayOrderMapper extends Mapper<PayOrder>, InsertListMapper<PayOrder> {
}