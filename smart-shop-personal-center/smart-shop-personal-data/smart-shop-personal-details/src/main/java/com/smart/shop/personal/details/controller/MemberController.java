package com.smart.shop.personal.details.controller;

import com.smart.shop.personal.details.common.RespCode;
import com.smart.shop.personal.details.common.RespEntity;
import com.smart.shop.personal.details.domain.dto.MemberControllerDto;
import com.smart.shop.personal.details.domain.dto.MemberDto;
import com.smart.shop.personal.details.domain.vo.MemberVo;
import com.smart.shop.personal.details.service.MemberService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author Administrator
 */
@RestController
@RequestMapping("/member")
public class MemberController {
    @Resource
    MemberService memberService;

    @PostMapping("/register")
    public RespEntity<Integer> register(@RequestBody @Validated MemberDto memberDto) {
        int i = memberService.saveMember(memberDto);
        return RespEntity.success(RespCode.SUCCESS, i);
    }
    @PutMapping("/modify")
    public RespEntity<Integer> modify(@RequestBody @Validated MemberControllerDto memberControllerDto){
        int i = memberService.modifyMember(memberControllerDto);
        return RespEntity.success(RespCode.SUCCESS, i);
    }
    @GetMapping("/find")
    public RespEntity<MemberVo> find(int mId) {
        MemberVo memberVo = memberService.findMember(mId);

        return RespEntity.success(RespCode.SUCCESS, memberVo);
    }
    @DeleteMapping("/remove")
    public RespEntity<Integer> remove(int mId) {
        int i = memberService.removeMember(mId);

        return RespEntity.success(RespCode.SUCCESS, i);

    }

}
