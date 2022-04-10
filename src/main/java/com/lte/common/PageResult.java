package com.lte.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * @Auther: laite
 * @Date: 2021/9/22 - 09 - 22 - 17:03
 * @Description: com.lte.common
 * @version: 1.0
 * 分页结果封装对象
 */
@Data
public class PageResult<T> implements Serializable {
    private Long total; //返回结果总条数
    private List<T> rows; //返回结果集

    public PageResult(Long total, List rows) {
        this.total = total;
        this.rows = rows;
    }

    public PageResult() {
    }
}
