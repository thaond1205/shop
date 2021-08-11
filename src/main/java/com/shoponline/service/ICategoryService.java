package com.shoponline.service;



import java.util.List;

import com.shoponline.entities.Category;

public interface ICategoryService {
    Category findCategoryById(String id);

    List<Category> findAll();

    Category createCategory(Category category);

}
