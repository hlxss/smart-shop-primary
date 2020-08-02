package com.smart.shop.personal.details.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.smart.shop.personal.details.common.RespCode;
import com.smart.shop.personal.details.domain.dto.MemberControllerDto;
import com.smart.shop.personal.details.domain.dto.MemberDto;
import com.smart.shop.personal.details.domain.entity.Member;
import com.smart.shop.personal.details.domain.vo.MemberVo;
import com.smart.shop.personal.details.exception.ServiceException;
import com.smart.shop.personal.details.mapper.MemberMapper;
import com.smart.shop.personal.details.service.MemberService;
import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author Administrator
 */
@Service
public class MemberServiceImpl implements MemberService {
    @Resource
    MemberMapper memberMapper;

    @Override
    @DS("master")
    public int saveMember(MemberDto memberDto) {
        // 该方法只是用来做条件判断,所以简单查询两个字段来判断数据库中用户名是否已存在,节约性能
        QueryWrapper<Member> qwUsername = new QueryWrapper<>();
        qwUsername.select(Member.COL_USERNAME, Member.COL_EMAIL).eq(Member.COL_USERNAME, memberDto.getUsername());
        Member memberUsername = memberMapper.selectOne(qwUsername);

        // 该方法只是用来做条件判断,所以简单查询两个字段来判断数据库中邮箱是否已存在,节约性能
        QueryWrapper<Member> qwEmail = new QueryWrapper<>();
        qwEmail.select(Member.COL_USERNAME, Member.COL_EMAIL).eq(Member.COL_EMAIL, memberDto.getEmail());
        Member memberEmail = memberMapper.selectOne(qwEmail);

        // 该方法只是用来做条件判断,所以简单查询两个字段来判断数据库中电话号码是否已存在,节约性能
        QueryWrapper<Member> qwPhone = new QueryWrapper<>();
        qwPhone.select(Member.COL_USERNAME, Member.COL_EMAIL).eq(Member.COL_EMAIL, memberDto.getPhone());
        Member memberPhone = memberMapper.selectOne(qwPhone);
        int count = 0;
        if (memberUsername == null) {
            if (memberEmail == null) {
                if (memberPhone == null) {
                    Member member = new Member();
                    BeanUtils.copyProperties(memberDto, member);

                     count = memberMapper.insert(member);

                }else {
                    throw new ServiceException(RespCode.PHONE_EXIST);
                }

            }else {
                throw new ServiceException(RespCode.EMAIL_EXIST);
            }
        }else {
            throw new ServiceException(RespCode.USERNAME_EXIST);
        }
        return count;

    }

    @Override
    @DS("master")
    public int modifyMember(MemberControllerDto memberControllerDto) {
        //根据用户名进行查询
        QueryWrapper<Member> qwUsername = new QueryWrapper<>();
        qwUsername.eq("username", memberControllerDto.getMemberDto().getUsername());
        Member memberUsername = memberMapper.selectOne(qwUsername);
        // 根据email进行查询
        QueryWrapper<Member> qwEmail = new QueryWrapper<>();
        qwEmail.eq("email", memberControllerDto.getMemberDto().getEmail());
        Member memberEmail = memberMapper.selectOne(qwEmail);
        //根据电话号码进行查询
        QueryWrapper<Member> qwPhone = new QueryWrapper<>();
        qwPhone.eq("phone", memberControllerDto.getMemberDto().getPhone());
        Member memberPhone = memberMapper.selectOne(qwPhone);
        int count = 0;
        Member member = null;
        /*
         * 使用用户输入的用户名来进行查询,如果查询的结果不为空,
         * 而且查询出来的用户id与修改资料的用户id不为同一个则抛出异常
         * 说明用户修改的用户名在数据库中已存在,用户名,邮箱,电话号码采用唯一约束不允许重复
         * 接下来邮箱以及电话号码也是这样进行验证
         */
        if (memberUsername == null || memberUsername.getMId().equals(memberControllerDto.getMId())) {
            if (memberEmail == null || memberEmail.getMId().equals(memberControllerDto.getMId())) {
                if (memberPhone == null || memberPhone.getMId().equals(memberControllerDto.getMId())) {
                    member = new Member();
                    BeanUtils.copyProperties(memberControllerDto.getMemberDto(), member);
                    QueryWrapper<Member> queryWrapper = new QueryWrapper<>();
                    queryWrapper.eq(Member.COL_M_ID, memberControllerDto.getMId());
                    count  = memberMapper.update(member, queryWrapper);
                }else {
                    throw new ServiceException(RespCode.PHONE_EXIST);
                }
            }else {
                throw new ServiceException(RespCode.EMAIL_EXIST);
            }
        }else {
            throw new ServiceException(RespCode.USERNAME_EXIST);
        }

        return count;
    }

    @Override
    @DS("slave")
    public MemberVo findMember(int mId) {

        QueryWrapper<Member> qw = new QueryWrapper<>();
        qw.select("username", "real_name", "sex", "birth", "phone", "email", "grade", "create_time", "update_time")
                .eq("m_id", mId);
        Member member = memberMapper.selectOne(qw);
        MemberVo memberVo = new MemberVo();
        BeanUtils.copyProperties(member, memberVo);


        return memberVo;
    }

    @Override
    public int removeMember(int mId) {
        Member member = new Member();
        member.setStatus(0);
        QueryWrapper<Member> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq(Member.COL_M_ID, mId);
        int count = memberMapper.update(member, queryWrapper);

        return count;
    }


}
