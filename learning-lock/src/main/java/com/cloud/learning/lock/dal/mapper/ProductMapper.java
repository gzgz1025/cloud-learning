package com.cloud.learning.lock.dal.mapper;

import com.cloud.learning.lock.dal.model.Product;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.special.InsertListMapper;

public interface ProductMapper extends Mapper<Product>, InsertListMapper<Product> {
    @Update("UPDATE product SET number = number - 1")
    int reduceOrder();

    @Update("UPDATE product SET number = number - 1 , version = version + 1 where version = #{ver,jdbcType=INTEGER}")
    int reduceOrderOptimistic(@Param("id") int id);

    @Select("SELECT * FROM product WHERE id = #{id , jdbcType=INTEGER} for update")
    Product selectWithPessimism(@Param("id") int id);
}