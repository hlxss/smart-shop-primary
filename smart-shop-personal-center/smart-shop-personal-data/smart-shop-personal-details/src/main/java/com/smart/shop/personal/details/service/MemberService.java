package com.smart.shop.personal.details.service;

import com.smart.shop.personal.details.domain.dto.MemberControllerDto;
import com.smart.shop.personal.details.domain.dto.MemberDto;
import com.smart.shop.personal.details.domain.entity.Member;
import com.smart.shop.personal.details.domain.vo.MemberVo;

/**
 * @author Administrator
 */
public interface MemberService {
    /**
     * 用户注册
     * @param memberDto
     * @return
     */
    int saveMember(MemberDto memberDto);

    /**
     * 修改用户资料
     * @param memberControllerDto
     * @return
     */
    int modifyMember(MemberControllerDto memberControllerDto);

    /**
     * 根据用户id查询用户
     * @param mId
     * @return
     */
    MemberVo findMember(int mId);

    /**
     * 用户注销
     * @param mId
     * @return
     */
    int removeMember(int mId);
}
