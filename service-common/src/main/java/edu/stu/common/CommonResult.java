package edu.stu.common;

import lombok.Data;

@Data
public class CommonResult<T> {

    private  String status = "200";
    private  String message = "success";
    private  T data;

    public CommonResult(){}

    public CommonResult(String status,String message,T data){
        this.status = status;
        this.message = message;
        this.data = data;
    }
    public CommonResult(String status,String message){
        this.status = status;
        this.message = message;
    }
    public CommonResult(String status,T data){
        this.status = status;
        this.data = data;
    }
    //全参数
    public static <T> CommonResult<T> result(String status,String message,T data){
        CommonResult<T> tCommonResult = new CommonResult<>(status, message, data);
        return tCommonResult;
    }
    public  static <T> CommonResult<T> success(T data){
        CommonResult<T> tCommonResult = new CommonResult<>();
        tCommonResult.setData(data);
        return tCommonResult;
    }


}
