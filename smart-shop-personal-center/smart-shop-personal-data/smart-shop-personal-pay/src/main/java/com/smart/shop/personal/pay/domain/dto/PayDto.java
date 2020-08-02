package com.smart.shop.personal.pay.domain.dto;

import lombok.Data;


/**
 * @author Administrator
 */
@Data
public class PayDto {

    /**
     * 银行卡号
     */
    private String card;

    /**
     * 银行卡类别
     */
    private String cardType;

    /**
     * 银行名字
     */
    private String bank;

    /**
     * 1代表开通快捷支付,0代表没开,默认开启
     */
    private Integer fastPayment;


    /**
     * 身份证号
     */
    private String idNumber;

    /**
     * 真实姓名
     */
    private String realName;

    /**
     * 支付密码
     */
    private Integer payPassword;

    /**
     * 外键,用户id
     */
    private Integer mId;
}
