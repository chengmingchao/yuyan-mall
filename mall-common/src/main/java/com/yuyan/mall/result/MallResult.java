package com.yuyan.mall.result;


import lombok.Data;

/**
 * @author chengmingchao
 * @version 1.0
 * @date 2021/3/16 下午10:25
 * 统一返回结果
 */
@Data
public class MallResult<T> {

    private String msg;

    private Integer code;

    private T data;

    public MallResult(Integer code,String msg) {
        this.code = code;
        this.msg=msg;
    }

    public MallResult(Integer code, T data,String msg) {
        this.code = code;
        this.msg=msg;
        this.data = data;
    }

    public static MallResult ok(){
        return new MallResult(200,"请求成功1");
    }

    public static <T> MallResult ok(T data){
        return new MallResult(200,data,"请求成功!");
    }

    public static MallResult error(){
        return new MallResult(400,"请求失败!");
    }

}
