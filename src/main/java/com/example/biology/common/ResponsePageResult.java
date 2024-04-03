package com.example.biology.common;

import lombok.Data;

import java.util.List;

/**
 * @author :ZhangYi
 * @date :2022/2/27 14:53
 * @description:
 */

@Data
public class ResponsePageResult<T> {
    List<T> data;
    Integer page;
    Integer pageSize;

    public ResponsePageResult(List<T> data, Integer page, Integer pageSize) {
        this.data = data;
        this.page = page;
        this.pageSize = pageSize;
    }
}
