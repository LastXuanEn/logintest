package com.lte.service;

import com.lte.common.PageResult;
import com.lte.pojo.PurchaseStorage;

import java.util.Map;

/**
 * @Auther: laite
 * @Date: 2021/9/22 - 09 - 22 - 16:49
 * @Description: com.lte.service
 * @version: 1.0
 */
public interface PurchaseStorageService {
    PageResult  findPage(Map<String,Object> map);

    void save(PurchaseStorage purchaseStorage);
}
