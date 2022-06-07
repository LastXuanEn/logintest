package com.lte.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lte.common.Result;
import com.lte.mapper.TreeMapper;
import com.lte.pojo.PmsCategory;
import com.lte.service.TreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Auther: laite
 * @Date: 2022/4/9 - 04 - 09 - 13:52
 * @Description: com.lte.controller
 * @version: 1.0
 */
@RestController
@RequestMapping("/tree")
public class TreeController {
    @Autowired
    TreeService treeService;


    @GetMapping("/list")
    public List<PmsCategory> findPage(){
        return treeService.findPage();
    }

    @PostMapping("/delete")
    public Result delete(@RequestBody Long[] catIds){
        return treeService.delete(catIds);
    }
}
