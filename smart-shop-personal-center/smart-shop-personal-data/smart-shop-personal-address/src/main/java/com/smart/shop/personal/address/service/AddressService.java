package com.smart.shop.personal.address.service;

import com.smart.shop.personal.address.domain.dto.AddressControllerDto;
import com.smart.shop.personal.address.domain.dto.AddressDto;
import com.smart.shop.personal.address.domain.dto.ModifyAddressDto;
import com.smart.shop.personal.address.domain.vo.AddressVo;

import java.util.List;

/**
 * @author Administrator
 */
public interface AddressService {
    /**
     * 添加用户地址
     * @param addressDto 需要添加的用户信息
     * @return 返回影响的行数
     */
    int addAddress(AddressDto addressDto);

    /**
     * 根据用户id和地址id删除地址
     * @param mId 用户id
     * @param aId 地址id
     * @return
     */
    int removeAddress(int mId, int aId);

    /**
     * 查询用户全部的地址
     * @param mId
     * @return
     */
    List<AddressVo> findAll(int mId);

    /**
     * 修改用户资料
     * @param addressControllerDto 需要的参数
     * @return
     */
    int modifyAddress(AddressControllerDto addressControllerDto);
}
