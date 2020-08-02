package com.smart.shop.personal.details.domain.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.smart.shop.personal.details.domain.entity.Member;
import lombok.Data;

import java.util.Date;

/**
 * @author Administrator
 */
@Data
public class MemberVo extends Member {


    /**
     * 用户昵称
     */

    private String username;

    /**
     * 登录密码
     */

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
    private Date birth;

    /**
     * 用户电话
     */
    private String phone;

    /**
     * 用户邮箱
     */
    private String email;

    /**
     * 会员等级,默认V0
     */
    private String grade;

    /**
     * 会员创建时间,默认为当前系统时间戳
     */
    private Date createTime;

    /**
     * 会员更新时间
     */
    private Date updateTime;

}
