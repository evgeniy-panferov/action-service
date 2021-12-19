package com.actionservice.http;

import com.actionservice.model.Category;
import com.actionservice.model.Coupon;
import com.actionservice.model.dto.CategoryDto;
import com.actionservice.repository.category.CategoryDaoImpl;
import com.actionservice.util.CategoryUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;


@RestController
@RequestMapping("/categories")
@RequiredArgsConstructor
public class CategoryCtrl {

    private final CategoryDaoImpl categoryDao;

    @GetMapping
    public Set<CategoryDto> getCoupons() {
        return CategoryUtil.toDtos(categoryDao.findAll());
    }

}
