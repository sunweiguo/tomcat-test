package com.njupt.swg.common;

import lombok.*;

/**
 * @Author swg.
 * @Date 2021/11/13 23:08
 * @CONTACT 317758022@qq.com
 * @DESC
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Result {
    private Integer code;
    private String msg;
    private Object data;

    public static Result success(String msg, Object data){
        return new Result(200,msg,data);
    }

    public static Result error(Integer code, String msg, Object data){
        return new Result(code,msg,data);
    }
}
