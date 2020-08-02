package com.smart.shop.personal.pay.exception;

import com.smart.shop.personal.pay.common.RespCode;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author Administrator
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class DaoException extends RuntimeException{
    private int status;

    private String msg;

    private String tips;

    public DaoException(RespCode respCode) {
        // 使用父类的错误提示,这样在全局异常处理那里就不需要进行异常强转
        super(respCode.getMsg());
        this.status = respCode.getStatus();
        this.tips = respCode.getTips();
    }

}
