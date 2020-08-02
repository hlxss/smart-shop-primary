package com.smart.shop.personal.address.domain.dto;

import lombok.Data;

/**
 * @author Administrator
 * 该dto是用来做参数传递的,主要是用在修改收货地址那个controller,不能使用多个@RequestBody来接收json数据
 * 所以将所有参数合并封装在这个dto里面
 */
@Data
public class AddressControllerDto {
    /**
     * 用户id
     */
    private Integer mId;
    /**
     * 收货地址id
     */
    private Integer aId;
    /**
     * 需要修改的参数dto
     */
    private ModifyAddressDto modifyAddressDto;
}
