package com.smart.shop.personal.address.domain.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * @author Administrator
 */
@Data
public class AddressDto {

    /**
     * 收货人
     */
    @Size(min = 1, max = 15)
    @NotEmpty(message = "收货人不能为空")
    private String consignee;

    /**
     * 收货号码
     */
    @NotEmpty(message = "手机号码不能为空")
    @Pattern(regexp = "^[1][3,4,5,7,8,9][0-9]{9}$", message = "手机号码不合法")
    private String consigneePhone;

    /**
     * 收货地址
     */
    @NotEmpty(message = "收货地址不能为空")
    private String location;

    /**
     * 1代表默认地址,0代表不是默认地址
     */
    private Integer defaultAddress;

    private Integer status;

    /**
     * 外键,关联用户表,用户id
     */
    private Integer mId;

}
