package com.lte.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.lte.common.PageResult;
import com.lte.mapper.MemoryMapper;
import com.lte.pojo.Memory;
import com.lte.pojo.User;
import com.lte.service.MemoryService;
import javafx.scene.media.VideoTrack;
import org.springframework.beans.Mergeable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.Map;

/**
 * @Auther: laite
 * @Date: 2022/4/5 - 04 - 05 - 16:24
 * @Description: com.lte.service.impl
 * @version: 1.0
 */
@Service
public class MemoryServiceImpl implements MemoryService {
    @Autowired
    MemoryMapper memoryMapper;
    @Override
    public PageResult<Memory> findPage(Map<Object,Object> map) {
        PageHelper.startPage((Integer) map.get("currentPage"),(Integer)map.get("pageSize"));
        Page page = memoryMapper.findPage((String) map.get("queryString"));
        return new PageResult<Memory>(page.getTotal(), page.getResult());
    }

    @Override
    public void addMemory(Memory memory, User user) {
        
        memory.setCreatedBy(user.getRealname());
        memory.setCreateTime(new Date());
        memoryMapper.addMemory(memory);

    }
}
