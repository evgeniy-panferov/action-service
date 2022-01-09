package com.actionservice.http;

import com.actionservice.model.dto.telegram.CategoryDto;
import com.actionservice.repository.category.CategoryDaoImpl;
import com.actionservice.util.CategoryUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<Set<CategoryDto>> getCoupons() {
        return new ResponseEntity<>(CategoryUtil.toDtos(categoryDao.findAll()), HttpStatus.OK);
    }

}
