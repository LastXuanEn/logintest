package com.lte.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lte.pojo.PmsCategory;

import java.util.List;

/**
 * @Auther: laite
 * @Date: 2022/4/9 - 04 - 09 - 14:05
 * @Description: com.lte.mapper
 * @version: 1.0
 */
public interface TreeMapper  extends BaseMapper<PmsCategory> {
    int updateList(List<PmsCategory> ids);
}
