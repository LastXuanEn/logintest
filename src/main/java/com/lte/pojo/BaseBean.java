package com.lte.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * @Auther: laite
 * @Date: 2022/4/5 - 04 - 05 - 17:23
 * @Description: com.lte.pojo
 * @version: 1.0
 */
@Data
public class BaseBean implements Serializable {
    private static final long serialVersionUID = -739006545728855488L;
    /**
     * 创造人
     */
     String createdBy;
    /**
     * 创建时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")  //将日期格式化成制指定字符串
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
     Date createTime;
    /**
     * 最后修改时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")  //将日期格式化成制指定字符串
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    Date updateTime;
    /**
     * 修改者
     */
    private String updateBy;

}

