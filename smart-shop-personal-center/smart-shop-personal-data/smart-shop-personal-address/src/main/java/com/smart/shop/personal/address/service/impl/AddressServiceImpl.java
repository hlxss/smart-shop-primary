package com.smart.shop.personal.address.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.smart.shop.personal.address.domain.dto.AddressControllerDto;
import com.smart.shop.personal.address.domain.dto.AddressDto;
import com.smart.shop.personal.address.domain.dto.ModifyAddressDto;
import com.smart.shop.personal.address.domain.entity.Address;
import com.smart.shop.personal.address.domain.vo.AddressVo;
import com.smart.shop.personal.address.mapper.AddressMapper;
import com.smart.shop.personal.address.service.AddressService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

/**
 * @author Administrator
 */
@Service
public class AddressServiceImpl implements AddressService {
    @Resource
    AddressMapper addressMapper;

    @Override
    @DS("master")
    public int addAddress(AddressDto addressDto) {
        Address address = new Address();
        BeanUtils.copyProperties(addressDto, address);
        int insert = addressMapper.insert(address);

        return insert;
    }

    @Override
    public int removeAddress(int mId, int aId) {
        /*
         * 将参数封装到对象中传递
         */
        Address address = new Address();
        address.setStatus(0);
        // update address set status = 0 where mid=mid and aid=aid
        QueryWrapper<Address> qw = new QueryWrapper<>();
//        qw.eq(Address.COL_A_ID, aId).eq(Address.COL_M_ID, mId);
        qw.and(queryWrapper -> queryWrapper.eq(Address.COL_A_ID, aId).eq(Address.COL_M_ID, mId));
        int update = addressMapper.update(address, qw);
        return update;
    }

    @Override
    @DS("slave")
    public List<AddressVo> findAll(int mId) {
        QueryWrapper<Address> qw = new QueryWrapper<>();
        qw.eq(Address.COL_M_ID, mId);
        List<Address> addresses = addressMapper.selectList(qw);
        // 将addresses里面的数据全部复制到另一个集合中,返回
        AddressVo addressVo = null;
        List<AddressVo> addressVoList = new ArrayList<>();
        for (Address address : addresses) {
            addressVo = new AddressVo();
            BeanUtils.copyProperties(address, addressVo);
            addressVoList.add(addressVo);
        }
        return addressVoList;
    }

    @Override
    @DS("master")
    public int modifyAddress(AddressControllerDto addressControllerDto) {
        Address address = new Address();
        BeanUtils.copyProperties(addressControllerDto.getModifyAddressDto(), address);
        QueryWrapper<Address> qw = new QueryWrapper<>();
        qw.and(queryWrapper -> queryWrapper.eq(Address.COL_M_ID, addressControllerDto.getMId()).eq(Address.COL_A_ID, addressControllerDto.getAId()));

        int update = addressMapper.update(address, qw);
        return update;
    }


}
