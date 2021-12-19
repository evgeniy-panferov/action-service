package com.actionservice.repository.category;

import com.actionservice.model.Category;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Slf4j
@Component
@RequiredArgsConstructor
public class CategoryDaoImpl implements CategoryDao {

    private final CategoryRepository repository;

    @Override
    public Set<Category> findAll() {
        log.info("CategoryDaoImpl findAll categories");
        return new HashSet<>(repository.findAll());
    }
}
