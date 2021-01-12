package com.cloud.learning.jwt.controller;

import cn.hutool.core.bean.BeanUtil;
import com.cloud.learning.asserts.Result;
import com.cloud.learning.asserts.ResultBase;
import com.cloud.learning.jwt.dal.model.ResUser;
import com.cloud.learning.jwt.dto.UserRequestDto;
import com.cloud.learning.jwt.service.UserService;
import com.cloud.learning.jwt.utils.JwtUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName: UserController
 * @Description:
 * @Author: pzl
 * @CreateDate: 2021/1/12 14:15
 * @Version: 1.0
 */
@RestController
@RequestMapping("/usr/")
@Api(tags = "用户")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/getUserByNameAndPwd.json", method = RequestMethod.GET)
    @ApiOperation(value = "根据用户名、密码查询数据")
    public Result<String> getUserByNameAndPwd(UserRequestDto dto) {
        ResUser user = userService.getUserByNameAndPwd(dto);
        if(ObjectUtils.isEmpty(user)){
            Result.fail("用户名密码错误");
        }else{
            // 生成token
            String jwtToken = JwtUtils.getJwtToken(String.valueOf(user.getUserId()), user.getUsername());
            ResultBase re=new ResultBase();
            re.setCode("0");
            re.setMessage("YES");
            re.setSuccess(Boolean.TRUE);
            return Result.success(jwtToken);
        }
        return null;
    }
}
