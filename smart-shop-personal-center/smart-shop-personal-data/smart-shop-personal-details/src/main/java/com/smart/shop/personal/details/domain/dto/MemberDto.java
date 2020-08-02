package com.smart.shop.personal.details.domain.dto;

import lombok.Data;

import javax.validation.constraints.*;
import java.util.Date;

/**
 * @author Administrator
 */
@Data
public class MemberDto {


    /**
     * 用户昵称
     */
    @NotBlank(message = "用户名不能为空")
    @Size(min = 1, max = 10)
    private String username;

    /**
     * 登录密码
     */
    @Size(min = 6, max = 16)
    private String password;

    /**
     * 用户真实姓名
     */
    private String realName;

    /**
     * 0表示保密,1表示男,2表示女
     */
    private Integer sex;

    /**
     * 用户生日
     */
    @Past
    private Date birth;

    /**
     * 用户电话
     */
    @NotEmpty(message = "手机号码不能为空")
    @Pattern(regexp = "^[1][3,4,5,7,8,9][0-9]{9}$", message = "手机号码不合法")
    private String phone;

    /**
     * 用户邮箱
     */
    @Email(message = "email格式不正确")
    private String email;

    /**
     * 会员等级,默认V0
     */
    private String grade;
}
