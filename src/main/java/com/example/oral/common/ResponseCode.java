package com.example.oral.common;

/**
 * @author :ZhangYi
 * @date :2022/2/24 20:37
 * @description:
 */
public enum ResponseCode {

    OK(0, "操作成功"), FAIL(1, "操作失败"), NO_AUTH(2, "没有权限"), NO_PAGE(3, "未找到页面"), TOKEN_OVERDUE(4, "Token超期"),
    SERVER_ERROR(5, "服务器错误"), NO_SERVER(6, "服务器不在线"), TOKEN_INVALID(7, "token非法"), NOT_LOGIN(8, "未登录");

    public Integer code;
    public String msg;

    ResponseCode() {}

    ResponseCode(final Integer code, final String msg) {
        this.code = code;
        this.msg = msg;
    }
}