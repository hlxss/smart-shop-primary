package com.smart.shop.personal.address.common;

import lombok.Data;

/**
 * @author Administrator
 */
@Data
public class RespEntity <T>{
    private int status;
    private String msg;
    private String tips;
    private T data;

    /**
     * 全参构造方法
     * @param status
     * @param msg
     * @param tips
     * @param data
     */
    /*private RespEntity(int status, String msg, String tips, T data) {
        this.status = status;
        this.msg = msg;
        this.tips = tips;
        this.data = data;
    }*/

    /**
     * 构造方法
     * @param respCode 枚举状态类
     */
    /*private RespEntity(RespCode respCode) {

    }*/

    /**
     * 构造方法
     * @param respCode 枚举状态类
     * @param data 返回参数 泛型
     */
    /*private RespEntity(RespCode respCode, T data) {

    }*/

    /**
     * 程序运行成功的返回方法, 返回状态码,由我们自己指定,没有外部传入
     * @param data 返回参数 泛型
     * @param <T> 泛型
     * @return 返回包装类型
     */
    public static <T> RespEntity<T> success(T data) {
        RespEntity<T> respEntity = new RespEntity<>();
        respEntity.setData(data);
        respEntity.setMsg(RespCode.SUCCESS.getMsg());
        respEntity.setStatus(RespCode.SUCCESS.getStatus());
        respEntity.setTips(RespCode.SUCCESS.getTips());

        return respEntity;
    }

    public static <T> RespEntity<T> success(RespCode respCode, T data) {
        RespEntity<T> respEntity = new RespEntity<>();
        respEntity.setData(data);
        respEntity.setMsg(respCode.getMsg());
        respEntity.setStatus(respCode.getStatus());
        respEntity.setTips(respCode.getTips());
        return respEntity;
    }

    /**
     * 程序出现异常的返回方法的
     * @param
     * @param <T>
     * @return
     */
    public static <T> RespEntity<T> error(RespCode respCode) {
        RespEntity<T> respEntity = new RespEntity<>();
        respEntity.setMsg(respCode.getMsg());
        respEntity.setStatus(respCode.getStatus());
        respEntity.setTips(respCode.getTips());
        return respEntity;
    }

    /*public static <T> RespEntity<T> error(RespCode respCode, T data) {
        return new RespEntity<T>(respCode, null);
    }*/

    public static <T> RespEntity<T> error() {
        RespEntity<T> respEntity = new RespEntity<>();
        respEntity.setMsg(RespCode.ERROR.getMsg());
        respEntity.setStatus(RespCode.ERROR.getStatus());
        respEntity.setTips(RespCode.ERROR.getTips());

        return respEntity;
    }
}
