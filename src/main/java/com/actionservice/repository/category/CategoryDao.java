package com.actionservice.repository.category;

import com.actionservice.model.Category;

import java.util.Set;

public interface CategoryDao {
    Set<Category> findAll();
}
