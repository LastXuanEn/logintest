package com.lte.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lte.common.Result;
import com.lte.mapper.TreeMapper;
import com.lte.pojo.PmsCategory;
import com.lte.service.TreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Auther: laite
 * @Date: 2022/4/10 - 04 - 10 - 16:18
 * @Description: com.lte.service.impl
 * @version: 1.0
 */
@Service
public class TreeServiceImpl implements TreeService {
    @Autowired
    TreeMapper treeMapper;
    @Override
    public List<PmsCategory> findPage() {
        QueryWrapper<PmsCategory> wrapper = new QueryWrapper<>();
        wrapper.eq("show_status", 1);
        List<PmsCategory> pmsCategories = treeMapper.selectList(wrapper);
        return getParents(pmsCategories);
    }

    @Override
    public Result delete(Long[] catIds) {
        List<PmsCategory> list = new ArrayList<>();
        for (Long catId : catIds) {
            PmsCategory pmsCategory = new PmsCategory();
            pmsCategory.setCatId(catId);
            list.add(pmsCategory);
        }
        int i = treeMapper.updateList(list);
        return new Result("成功删除" + i + "条", true);
    }

    /**
     *
     * @param pmsCategories
     * @return 返回携带子类的元素集合
     */
    private List<PmsCategory> getParents(List<PmsCategory> pmsCategories){
        List<PmsCategory> parentCollect = pmsCategories.stream()
                .filter(t -> t.getParentId() == 0)
                .map(t->{
                    t.setChildren(getChildrens(t,pmsCategories));
                    return t;
                })
                .sorted((t1, t2) ->{
                    return Integer.compare(t1.getSort()==null ? 0: t1.getSort(), t2.getSort()==null ? 0: t2.getSort());
                })
                .collect(Collectors.toList());
        return parentCollect;
    }
    private List<PmsCategory> getChildrens(PmsCategory root,List<PmsCategory> all){
        List<PmsCategory> collect = all.stream().filter(t -> t.getParentId() == root.getCatId())
                .map(t -> {
                    t.setChildren(getChildrens(t, all));
                    return t;
                })
                .sorted((t1, t2) ->
                        Integer.compare(t1.getSort()==null ? 0: t1.getSort(), t2.getSort()==null ? 0: t2.getSort()))
                .collect(Collectors.toList());
        return collect;
    }
}
