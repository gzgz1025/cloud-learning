package com.cloud.learning;


import org.apache.logging.log4j.util.Strings;
import tk.mybatis.mapper.util.StringUtil;

import java.math.BigDecimal;

/**
 * @ClassName: CaseTest
 * @Description:
 * @Author: pzl
 * @CreateDate: 2021/1/18 9:30
 * @Version: 1.0
 */
public class CaseTest {
    public static void main(String[] args) {
        String ids = "123";
        String id = null;
        System.out.println(id == null && Strings.isBlank(ids));
        //System.out.println(new BigDecimal("1.0").equals(new BigDecimal("1.0")));
    }
}
