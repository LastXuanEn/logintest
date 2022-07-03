package com.lte.controller;

import com.lte.common.PageResult;
import com.lte.common.Result;
import com.lte.pojo.PurchaseStorage;
import com.lte.service.PurchaseStorageService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.Date;
import java.util.Map;

/**
 * @Auther: laite
 * @Date: 2021/9/22 - 09 - 22 - 16:48
 * @Description: com.lte.controller
 * @version: 1.0
 */
@RestController
@RequestMapping("/purchaseStorage")
public class PurchaseStorageController {
    @Autowired
    PurchaseStorageService purchaseStorageService;
    @Value("${photo.dir}")
    String realpath;
    @RequestMapping("/findPage")
    public Result findPage(@RequestBody Map<String,Object> map) {
        PageResult pageResult = purchaseStorageService.findPage(map);
        return new Result(pageResult, "分页查询成功", true);
    }
    @RequestMapping("/upload")
    public Result upload(MultipartFile imgFile){
        try {
//        获取文件名
            String filename = imgFile.getOriginalFilename();
//        获取后缀
            int index = filename.lastIndexOf(".");
            String substring = filename.substring(index);
//        使用时间戳进行字符串拼接
            long l = System.currentTimeMillis();
            String newName = l+substring;
//         利用transferto将图片文件以流的方式写出去
            File file = new File(realpath, newName);
            imgFile.transferTo(file);
            return new Result(newName, "文件上传成功", true);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result("文件上传失败", false);
        }
    }
    @RequestMapping("/save")
    public Result save (@RequestBody PurchaseStorage purchaseStorage){
        try {
            purchaseStorage.setBillDate(new Date());
            purchaseStorage.setAmount(300);
            purchaseStorageService.save(purchaseStorage);
            return new Result("入库成功", true);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result("入库失败", false);
        }
    }
}
