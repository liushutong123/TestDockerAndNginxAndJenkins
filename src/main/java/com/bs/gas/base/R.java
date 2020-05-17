package com.bs.gas.base;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author wind
 * @date @s_2020/5/14
 */
@Data
@Accessors(chain = true)
public class R {
    private int code;
    private String msg;
    private Object data;

    public static R success(Object data) {
        return new R().setCode(0).setMsg("success").setData(data);
    }

    public static R success(String msg, Object data) {
        return new R().setCode(0).setMsg(msg).setData(data);
    }

    public static R fail(String msg, Object data) {
        return new R().setCode(-1).setMsg(msg).setData(data);
    }

    public static R custom(int code, String msg, Object data) {
        return new R().setCode(code).setMsg(msg).setData(data);
    }
}
