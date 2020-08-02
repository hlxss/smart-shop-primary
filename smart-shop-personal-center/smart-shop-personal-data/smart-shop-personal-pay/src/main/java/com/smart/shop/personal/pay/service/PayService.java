package com.smart.shop.personal.pay.service;

import com.smart.shop.personal.pay.domain.dto.PayDto;

/**
 * @author Administrator
 */
public interface PayService {
    /**
     * 添加银行卡
     * @param payDto
     * @return
     */
    int addCard(PayDto payDto);
}
