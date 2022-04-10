package com.lte.controller;

import com.lte.common.PageResult;
import com.lte.common.QiNiuUtil;
import com.lte.common.Result;
import com.lte.pojo.Memory;
import com.lte.pojo.User;
import com.lte.service.MemoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.Map;

/**
 * @Auther: laite
 * @Date: 2022/4/5 - 04 - 05 - 16:12
 * @Description: com.lte.controller
 * @version: 1.0
 */
@RestController
@RequestMapping("/memory")
public class MemoryController {
    @Autowired
    MemoryService memoryService;

    @RequestMapping("/findPage")
    public Result findPage(@RequestBody Map<Object, Object> map) {
        PageResult<Memory> page = memoryService.findPage(map);
        return new Result(page, "分页查询成功", true);
    }

    @RequestMapping("/add")
    public Result addMemory(@RequestBody Memory memory, HttpServletRequest httpServletRequest) {
        User user = (User) httpServletRequest.getSession().getAttribute("user");
        if (user == null) {
            return new Result("token失效,请重新登录", false);
        }
        memoryService.addMemory(memory,user);
        return new Result("添加成功", true);
    }

    @RequestMapping("/upload")
    public Result upload(MultipartFile imgFile) {
        try {
//        获取文件名
            String filename = imgFile.getOriginalFilename();
//        获取后缀
            int index = filename.lastIndexOf(".");
            String substring = filename.substring(index);
//        使用时间戳进行字符串拼接
            long l = System.currentTimeMillis();
            String newName = l + substring;
            //上传七牛云
            QiNiuUtil.upload2Qiniu(imgFile.getBytes(), newName);
            return new Result(newName, "文件上传成功", true);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result("文件上传失败", false);
        }
    }
}
