package com.hiworlds.bbblog.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hiworlds.bbblog.domain.Category;
import com.hiworlds.bbblog.mapper.CategoryDao;
import com.hiworlds.bbblog.myException.errorMsgConstant.ResponseMsgConstant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *  @author: Liyz
 *  @Date: 2020/7/26 14:55
 *  @Description:分类
 **/


@RestController
public class CategoryController {
    @Autowired
    private ObjectMapper objectMapper;
    Logger logger = LoggerFactory.getLogger(CategoryController.class);
    @Autowired
    private CategoryDao categoryDao;

    /**
     * 获取所有分类
     * @return
     * @throws JsonProcessingException
     */
    @GetMapping("/home/findAllCategorys")
    public String findAllCategorys() throws JsonProcessingException {
        List<Category> allCategorys = categoryDao.findAllCategorys();
        HashMap<String, Object> map = new HashMap<>();
        map.put("code", 200);
        map.put("msg", "获取全部分类成功!");
        map.put("data", allCategorys);
        return objectMapper.writeValueAsString(map);
    }

    /**
     * 添加分类
     * @param params
     * @return
     * @throws Exception
     */
    @PostMapping("/admin/saveACategory")
    public String saveACategory(@RequestBody Map<String,String> params) throws Exception {
        logger.debug("/admin/saveACategory得到参数为："+params.toString());
        Category category = new Category();
        if(params.get("category_name")==null) throw new Exception(ResponseMsgConstant.ERROR_MSG_PARAMS_EXCPTION);
        category.setCategory_name(params.get("category_name"));
        category.setCategory_create_time(new Date());categoryDao.saveACategory(category);
        HashMap<String, Object> map = new HashMap<>();
        map.put("code", 200);
        map.put("msg", "保存成功");
        map.put("data", category);
        return objectMapper.writeValueAsString(map);
    }

    /**
     * 删除分类信息
     * @param category_id
     * @return
     * @throws JsonProcessingException
     */
    @GetMapping("/admin/deleteCategoryById")
    public String deleteCategoryById(@RequestParam("id") Integer category_id) throws JsonProcessingException {
        categoryDao.deleteCategoryById(category_id);
        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("code", 200);
        resultMap.put("msg", "分类删除成功");
        resultMap.put("data", null);
        return objectMapper.writeValueAsString(resultMap);
    }

    /**
     * 修改分类名
     * @param params
     * @return
     * @throws JsonProcessingException
     */
    @PostMapping("/admin/modifyCategory")
    public String modifyCategory(@RequestBody Map params) throws JsonProcessingException {
        Category category = new Category();
        category.setCategory_id((Integer) params.get("category_id"));
        category.setCategory_name((String) params.get("category_name"));
        categoryDao.modifyCategory(category);
        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("code", 200);
        resultMap.put("msg", "分类修改成功");
        resultMap.put("data", null);
        return objectMapper.writeValueAsString(resultMap);
    }


}
