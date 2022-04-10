package com.lte.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * @Auther: laite
 * @Date: 2022/4/5 - 04 - 05 - 16:14
 * @Description: com.lte.pojo
 * @version: 1.0
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class Memory extends BaseBean implements Serializable {
    private static final long serialVersionUID = -5092583684559396972L;

    private Integer id;
    /**
     * 主题回忆
     */
    private String tile;
    /**
     * 故事描述
     */
    private String story;
    /**
     * 图片url
     */
    private String picUrl;

}
