package com.cloud.learning.test;

/**
 * @ClassName: Test
 * @Description:
 * @Author: pzl
 * @CreateDate: 2021/1/12 15:07
 * @Version: 1.0
 */

import com.cloud.learning.jwt.JWTMain;
import com.cloud.learning.jwt.dal.mapper.ResUserMapper;
import com.cloud.learning.jwt.dal.model.ResUser;
import com.cloud.learning.jwt.dto.UserRequestDto;
import com.cloud.learning.jwt.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.weekend.WeekendSqls;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.DEFINED_PORT,classes = JWTMain.class)
@ActiveProfiles("local")
@Slf4j
public class TestDemo {
    @Autowired
    private ResUserMapper mapper;
    @Autowired
    private UserService service;

    @Test
    public void test(){

        /*WeekendSqls<ResUser> custom=WeekendSqls.custom();
        custom.andEqualTo(ResUser::getUsername,"test");
        custom.andEqualTo(ResUser::getPassword,"1234");
        ResUser resUser = mapper.selectOneByExample(new Example.Builder(ResUser.class).where(custom).build());
        log.info(resUser.getMobile());*/

        UserRequestDto dto=new UserRequestDto();
        dto.setPassword("1234");
        dto.setUsername("test");
        ResUser user2 = service.getUserByNameAndPwd(dto);
        log.info(user2.getMobile());
    }
}
