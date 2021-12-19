package com.actionservice.util;

import com.actionservice.model.Category;
import com.actionservice.model.dto.CategoryDto;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.Set;
import java.util.stream.Collectors;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CategoryUtil {

    public static CategoryDto toDto(Category category) {
        CategoryDto dto = new CategoryDto();
        dto.setAdmitadId(category.getAdmitadId());
        dto.setName(category.getName());
        dto.setLanguage(category.getLanguage());
        return dto;
    }

    public static Set<CategoryDto> toDtos(Set<Category> categories) {
        return categories.stream()
                .map(CategoryUtil::toDto)
                .collect(Collectors.toSet());
    }
}
