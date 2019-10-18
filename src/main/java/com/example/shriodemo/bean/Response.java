package com.example.shriodemo.bean;

/*
 * @Author liuxin
 * @Description //TODO 系统返回实体类
 **/


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Response  {
    private static final String SUCCESS="成功";
    private static final String FAIL="失败";

    private Boolean status;
    private Integer code;
    private String msg;
    private Object data;

    public static Response success(String msg){
        Response response = new Response();
        response.setStatus(true);
        response.setMsg(msg);
        response.setData(null);
        response.setCode(200);
        return response;
    }
    public static Response success(Object data){
        Response response = success(SUCCESS);
        response.setData(data);
        return response;
    }
    public static Response success(){
        Response response = success(SUCCESS);
        return response;
    }
    public static Response success(Object data,Integer code){
        Response response = new Response();
        response.setStatus(true);
        response.setMsg(SUCCESS);
        response.setData(data);
        response.setCode(code);
        return response;
    }
    public static Response fail(String msg){
        Response response = new Response();
        response.setStatus(false);
        response.setMsg(msg);
        response.setData(null);
        response.setCode(500);
        return response;
    }
    public static Response fail(){
        Response response = fail(FAIL);
        return response;
    }
    public static Response fail(String msg,Integer code){
        Response response = fail(msg);
        response.setCode(code);
        return response;
    }
}
