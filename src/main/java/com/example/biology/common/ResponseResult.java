package com.example.biology.common;

import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;

import java.io.Serializable;
import java.util.List;

/**
 * @author :ZhangYi
 * @date :2022/2/24 20:36
 * @description:
 */
@Builder
public class ResponseResult<T> implements Serializable {
    private static final long serialVersionUID = 1L;
    @ApiModelProperty("返回处理消息")
    private String message = "操作成功！";
    @ApiModelProperty("返回代码")
    private Integer code = 200;
    @ApiModelProperty("返回数据对象")
    private T data;
    @ApiModelProperty("时间戳")
    private long timestamp = System.currentTimeMillis();

    public ResponseResult() {}

    public ResponseResult(final String message, final Integer code, final T data, final long timestamp) {
        this.message = message;
        this.code = code;
        this.data = data;
        this.timestamp = timestamp;
    }

    public static synchronized <T> ResponseResult<T> e(ResponseCode statusEnum) {
        return e(statusEnum, null);
    }

    public static synchronized <T> ResponseResult<T> ok(String message) {
        ResponseResult<T> res = new ResponseResult();
        res.setCode(ResponseCode.OK.code);
        res.setMessage(message);
        res.setData(null);
        return res;
    }

    public static synchronized <T> ResponseResult<T> error(String message) {
        ResponseResult<T> res = new ResponseResult();
        res.setCode(ResponseCode.FAIL.code);
        res.setMessage(message);
        res.setData(null);
        return res;
    }

    public static synchronized <T> ResponseResult<T> e(ResponseCode statusEnum, T data) {
        ResponseResult<T> res = new ResponseResult();
        res.setCode(ResponseCode.OK.code);
        res.setMessage(statusEnum.msg);
        res.setData(data);
        return res;
    }

    public static synchronized <T> ResponseResult<T> buildListData(ResponseCode code, List<T> data, Integer pageNo,
        Integer pageSize) {
        ResponseResult res = new ResponseResult();
        res.setData(new ResponsePageResult<>(data, pageNo, pageSize));
        res.setMessage(code.msg);
        res.setCode(code.code);
        return res;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(final String message) {
        this.message = message;
    }

    public Integer getCode() {
        return this.code;
    }

    public void setCode(final Integer code) {
        this.code = code;
    }

    public T getData() {
        return this.data;
    }

    public void setData(final T data) {
        this.data = data;
    }

    public long getTimestamp() {
        return this.timestamp;
    }

    public void setTimestamp(final long timestamp) {
        this.timestamp = timestamp;
    }
}
