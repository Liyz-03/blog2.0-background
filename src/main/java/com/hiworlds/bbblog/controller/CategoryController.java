package com.hiworlds.bbblog.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hiworlds.bbblog.domain.Category;
import com.hiworlds.bbblog.mapper.CategoryDao;
import com.hiworlds.bbblog.myException.errorMsgConstant.ResponseMsgConstant;
import com.hiworlds.bbblog.utils.MyResponseJson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author: Liyz
 * @Date: 2020/7/26 14:55
 * @Description:分类
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
     *
     * @return
     * @throws JsonProcessingException
     */
    @GetMapping("/home/findAllCategorys")
    public Map findAllCategorys() throws JsonProcessingException {
        List<Category> allCategorys = categoryDao.findAllCategorys();
        return MyResponseJson.responseSuccessWithData(allCategorys, "获取全部分类成功!");
    }

    /**
     * 添加分类
     *
     * @param params
     * @return
     * @throws Exception
     */
    @PostMapping("/admin/saveACategory")
    public Map saveACategory(@RequestBody Map<String, String> params) throws Exception {
        logger.debug("/admin/saveACategory得到参数为：" + params.toString());
        Category category = new Category();
        if (params.get("category_name") == null) throw new Exception(ResponseMsgConstant.ERROR_MSG_PARAMS_EXCPTION);
        category.setCategory_name(params.get("category_name"));
        category.setCategory_create_time(new Date());
        categoryDao.saveACategory(category);
        return MyResponseJson.responseSuccessWithData(category, "保存成功");
    }

    /**
     * 删除分类信息
     *
     * @param category_id
     * @return
     * @throws JsonProcessingException
     */
    @GetMapping("/admin/deleteCategoryById")
    public Map deleteCategoryById(@RequestParam("id") Integer category_id) throws JsonProcessingException {
        categoryDao.deleteCategoryById(category_id);
        return MyResponseJson.responseSuccessNoData("分类删除成功");
    }

    /**
     * 修改分类名
     *
     * @param params
     * @return
     * @throws JsonProcessingException
     */
    @PostMapping("/admin/modifyCategory")
    public Map modifyCategory(@RequestBody Map params) throws JsonProcessingException {
        Category category = new Category();
        category.setCategory_id((Integer) params.get("category_id"));
        category.setCategory_name((String) params.get("category_name"));
        categoryDao.modifyCategory(category);
        return MyResponseJson.responseSuccessNoData("分类修改成功");
    }


}
