package com.smart.shop.personal.pay.global;

import com.smart.shop.personal.pay.common.RespCode;
import com.smart.shop.personal.pay.common.RespEntity;
import com.smart.shop.personal.pay.exception.DaoException;
import com.smart.shop.personal.pay.exception.ServiceException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author Administrator
 */
@RestControllerAdvice
@Slf4j
public class GlobalHandleException {
    @ExceptionHandler(Exception.class)
    public static RespEntity globalHandleException(Exception exception) {
        if (exception instanceof ServiceException) {
            log.error(exception.getMessage());
            return RespEntity.error(RespCode.BUSINESS_UNKNOW_ERROR);
        }
        if (exception instanceof DaoException) {
            log.error(exception.getMessage());
            return RespEntity.error(RespCode.SYSTEM_INNER_ERROR);
        }

        log.error(exception.getMessage());
        return RespEntity.error();
    }
}
