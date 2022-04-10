package com.lte.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.github.pagehelper.Page;
import com.lte.pojo.Memory;

/**
 * @Auther: laite
 * @Date: 2022/4/5 - 04 - 05 - 16:27
 * @Description: com.lte.mapper
 * @version: 1.0
 */
public interface MemoryMapper extends BaseMapper<Memory> {
    Page findPage(String queryString);

    void addMemory(Memory memory);
}
