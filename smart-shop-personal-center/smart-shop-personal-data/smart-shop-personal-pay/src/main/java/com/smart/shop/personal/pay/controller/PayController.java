package com.smart.shop.personal.pay.controller;

import com.smart.shop.personal.pay.common.RespCode;
import com.smart.shop.personal.pay.common.RespEntity;
import com.smart.shop.personal.pay.domain.dto.PayDto;
import com.smart.shop.personal.pay.service.PayService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author Administrator
 */
@RestController
@RequestMapping("/pay")
public class PayController {
    @Resource
    PayService payService;
    @PostMapping("/save")
    public RespEntity<Integer> saveCard(@RequestBody PayDto payDto) {
        int i = payService.addCard(payDto);
        return RespEntity.success(RespCode.SUCCESS, i);
    }
}
