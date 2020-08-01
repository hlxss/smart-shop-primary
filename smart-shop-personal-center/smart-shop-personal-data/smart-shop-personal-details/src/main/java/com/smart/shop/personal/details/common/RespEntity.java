package com.smart.shop.personal.details.common;

/**
 * @author Administrator
 */
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
    private RespEntity(int status, String msg, String tips, T data) {
        this.status = status;
        this.msg = msg;
        this.tips = tips;
        this.data = data;
    }

    /**
     * 构造方法
     * @param respCode 枚举状态类
     */
    private RespEntity(RespCode respCode) {

    }

    /**
     * 构造方法
     * @param respCode 枚举状态类
     * @param data 返回参数 泛型
     */
    private RespEntity(RespCode respCode, T data) {

    }

    /**
     * 程序运行成功的返回方法, 返回状态码,由我们自己指定,没有外部传入
     * @param data 返回参数 泛型
     * @param <T> 泛型
     * @return 返回包装类型
     */
    public static <T> RespEntity<T> success(T data) {
        return success(RespCode.SUCCESS, data);
    }

    public static <T> RespEntity<T> success(RespCode respCode, T data) {
        return new RespEntity<T>(respCode, data);
    }

    /**
     * 程序出现异常的返回方法的
     * @param respCode
     * @param <T>
     * @return
     */
    public static <T> RespEntity<T> error(RespCode respCode) {
        return new RespEntity<T>(respCode);
    }

    public static <T> RespEntity<T> error(RespCode respCode, T data) {
        return new RespEntity<T>(respCode, null);
    }

    public static <T> RespEntity<T> error() {
        return error(RespCode.ERROR);
    }
}
