package com.smart.shop.personal.details.domain.dto;

import com.smart.shop.personal.details.domain.entity.Member;
import lombok.Data;

/**
 * @author Administrator
 * 该类用来封装MemberDto和mid来进行参数的传递,用户修改用户资料那个方法,由于用户id是不能修改的,所以分开封装
 */
@Data
public class MemberControllerDto {
    /**
     * 用户id
     */
    private Integer mId;

    /**
     * 修改的用户资料
     */
    private MemberDto memberDto;
}
