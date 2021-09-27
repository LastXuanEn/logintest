package com.lte.mapper;

import com.github.pagehelper.Page;
import com.lte.pojo.PurchaseStorage;
import com.lte.service.PurchaseStorageService;
import org.apache.ibatis.annotations.Param;

/**
 * @Auther: laite
 * @Date: 2021/9/22 - 09 - 22 - 17:16
 * @Description: com.lte.mapper
 * @version: 1.0
 */
public interface PurchaseStorageMapper {
    Page findPage(String queryString);

    void save( PurchaseStorage purchaseStorage);
}
