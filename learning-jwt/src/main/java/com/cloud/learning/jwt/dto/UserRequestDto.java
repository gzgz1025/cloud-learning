package com.cloud.learning.jwt.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * @ClassName: UserRequestDto
 * @Description:
 * @Author: pzl
 * @CreateDate: 2021/1/12 14:22
 * @Version: 1.0
 */
@Setter
@Getter
public class UserRequestDto {

    @ApiModelProperty(value = "用户名")
    private String username;

    @ApiModelProperty(value = "密码")
    private String password;
}
