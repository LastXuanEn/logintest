package com.lte.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.List;

/**
 * @Auther: laite
 * @Date: 2022/4/9 - 04 - 09 - 13:53
 * @Description: com.lte.pojo
 * @version: 1.0
 * 商品三级分类
 */
@Data
@TableName("pms_category")
public class PmsCategory {
    //分类id
    @TableId
    private Long catId;
    //分类名称
    @TableField
    private String name;
    //父分类id
    @TableField("parent_cid")
    private Long parentId;
    //层级
    @TableField
    private Integer catLevel;
    //是否显示，0不显示 1显示
    @TableField
    private Integer showStatus;
    //排序
    @TableField
    private Integer sort;
    //图标地址
    @TableField
    private String icon;
    //计量单位
    @TableField
    private String productUnit;
    //商品数量
    @TableField
    private Integer productCount;
    //子类
    @TableField(exist = false)
    private List<PmsCategory> children;
}
