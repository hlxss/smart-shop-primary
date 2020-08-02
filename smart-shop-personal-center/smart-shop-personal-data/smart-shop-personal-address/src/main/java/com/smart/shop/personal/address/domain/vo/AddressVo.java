package com.smart.shop.personal.address.domain.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.smart.shop.personal.address.domain.entity.Address;
import lombok.Data;

/**
 * @author Administrator
 */
@Data
public class AddressVo {
    /**
     * 主键,地址id
     */
    private Integer aId;

    /**
     * 收货人
     */
    private String consignee;

    /**
     * 收货号码
     */
    private String consigneePhone;

    /**
     * 收货地址
     */
    private String location;

    /**
     * 1代表默认地址,0代表不是默认地址
     */
    private Integer defaultAddress;


}
