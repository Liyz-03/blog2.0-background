package com.hiworlds.bbblog.mapper;

import com.hiworlds.bbblog.domain.Category;

import java.util.List;

public interface CategoryDao {
    List<Category> findAllCategorys();

    int saveACategory(Category category);

    void deleteCategoryById(Integer post_id);

    void modifyCategory(Category category);
}
