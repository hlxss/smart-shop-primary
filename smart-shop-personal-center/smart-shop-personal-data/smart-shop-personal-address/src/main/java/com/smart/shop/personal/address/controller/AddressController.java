package com.smart.shop.personal.address.controller;

import com.smart.shop.personal.address.common.RespCode;
import com.smart.shop.personal.address.common.RespEntity;
import com.smart.shop.personal.address.domain.dto.AddressControllerDto;
import com.smart.shop.personal.address.domain.dto.AddressDto;
import com.smart.shop.personal.address.domain.dto.ModifyAddressDto;
import com.smart.shop.personal.address.service.AddressService;
import com.smart.shop.personal.address.domain.vo.AddressVo;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Administrator
 */
@RestController
@RequestMapping("/address")
public class AddressController {
    @Resource
    AddressService addressService;


    @DeleteMapping("/remove")
    public RespEntity<Integer> remove( int mId,  int aId){
        int i = addressService.removeAddress(mId, aId);

        return RespEntity.success(RespCode.SUCCESS, i);
    }
    @PostMapping("/add")
    public RespEntity<Integer> add(@RequestBody @Validated AddressDto addressDto) {
        int i = addressService.addAddress(addressDto);
        return RespEntity.success(RespCode.SUCCESS, i);
    }
    @PutMapping("/amend")
    public RespEntity<Integer> amend(@RequestBody @Validated AddressControllerDto addressControllerDto) {
        int i = addressService.modifyAddress(addressControllerDto);

        return RespEntity.success(RespCode.SUCCESS, i);
    }
    @GetMapping("/find/{mId}")
    public RespEntity<List<AddressVo>> findAll(@PathVariable("mId") int mId) {
        List<AddressVo> all = addressService.findAll(mId);

        return RespEntity.success(RespCode.SUCCESS, all);
    }

}
