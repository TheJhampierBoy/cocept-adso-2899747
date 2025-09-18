package inventory.management.inventory.management.service;

import inventory.management.inventory.management.dto.CategoryRequestDto;
import inventory.management.inventory.management.dto.CategoryResponseDto;
import java.util.List;

public interface CategoryService {
    CategoryResponseDto createCategory(CategoryRequestDto requestDto);
    CategoryResponseDto getCategoryById(Long id);
    List<CategoryResponseDto> getAllCategories();
    CategoryResponseDto updateCategory(Long id, CategoryRequestDto requestDto);
    void deleteCategory(Long id);
}