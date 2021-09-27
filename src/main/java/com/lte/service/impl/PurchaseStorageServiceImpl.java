package com.lte.service.impl;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.lte.common.PageResult;
import com.lte.mapper.PurchaseStorageMapper;
import com.lte.pojo.PurchaseStorage;
import com.lte.service.PurchaseStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

/**
 * @Auther: laite
 * @Date: 2021/9/22 - 09 - 22 - 16:50
 * @Description: com.lte.service.impl
 * @version: 1.0
 */
@Service
@Transactional
public class PurchaseStorageServiceImpl implements PurchaseStorageService {
    @Autowired
    PurchaseStorageMapper purchaseStorageMapper;
    @Override
    public PageResult findPage(Map<String,Object> map) {
//       初始化页面
        System.out.println("map = " + map);
        PageHelper.startPage((Integer) map.get("currentPage"), (Integer)map.get("pageSize"));
//      使用sql进行查询得到结果集封装到page中
        Page page = purchaseStorageMapper.findPage((String)map.get("queryString"));;
        System.out.println(page.getTotal());
        return new  PageResult(page.getTotal(),page.getResult());

    }

    @Override
    public void save(PurchaseStorage purchaseStorage) {

        purchaseStorageMapper.save(purchaseStorage);
    }
}
