package com.lte.service;

import com.lte.common.Result;
import com.lte.pojo.PmsCategory;

import java.util.List;

/**
 * @Auther: laite
 * @Date: 2022/4/10 - 04 - 10 - 16:16
 * @Description: com.lte.service
 * @version: 1.0
 */
public interface TreeService {
    List<PmsCategory> findPage();

    Result delete(Long[] catIds);
}
