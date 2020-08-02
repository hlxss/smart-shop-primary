package com.smart.shop.personal.pay.service.impl;

import com.smart.shop.personal.pay.domain.dto.PayDto;
import com.smart.shop.personal.pay.domain.entity.Pay;
import com.smart.shop.personal.pay.mapper.PayMapper;
import com.smart.shop.personal.pay.service.PayService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author Administrator
 */
@Service
public class PayServiceImpl implements PayService {
    @Resource
    PayMapper payMapper;


    @Override
    public int addCard(PayDto payDto) {

        Pay pay = new Pay();
        BeanUtils.copyProperties(payDto, pay);
        int count = payMapper.insert(pay);

        return count;
    }
}
