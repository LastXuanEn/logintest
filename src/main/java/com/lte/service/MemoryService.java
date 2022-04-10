package com.lte.service;

import com.lte.common.PageResult;
import com.lte.pojo.Memory;
import com.lte.pojo.User;


import java.util.Map;

/**
 * @Auther: laite
 * @Date: 2022/4/5 - 04 - 05 - 16:19
 * @Description: com.lte.service
 * @version: 1.0
 */
public interface MemoryService {
    //查
    PageResult<Memory> findPage(Map<Object,Object> map);

    //增
    void addMemory(Memory memory, User user);
}
