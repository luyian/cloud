package com.it.cloud.common;

import lombok.Data;

/**
 * @author admin
 */
@Data
public class JsonResult {
    private Integer code;
    private String message;
    private Object data;

    public JsonResult(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public JsonResult(Integer code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public JsonResult(Object data) {
        this.code = 200;
        this.message = "success";
        this.data = data;
    }

    public JsonResult() {
        super();
    }

    public static JsonResult OK = new JsonResult(200, "success");
    public static JsonResult ERROR = new JsonResult(500, "error");
}
