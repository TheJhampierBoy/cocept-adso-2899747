package inventory.management.inventory.management.service;

import inventory.management.inventory.management.dto.CategoryRequestDto;
import inventory.management.inventory.management.dto.CategoryResponseDto;
import inventory.management.inventory.management.entity.Category;
import inventory.management.inventory.management.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    @Override
    public CategoryResponseDto createCategory(CategoryRequestDto requestDto) {
        Category category = new Category();
        category.setCategoryName(requestDto.getCategoryName());
        category.setDescription(requestDto.getDescription());
        Category saved = categoryRepository.save(category);
        return mapToResponseDto(saved);
    }

    @Override
    public CategoryResponseDto getCategoryById(Long id) {
        Category category = categoryRepository.findById(id).orElseThrow(() -> new RuntimeException("Category not found"));
        return mapToResponseDto(category);
    }

    @Override
    public List<CategoryResponseDto> getAllCategories() {
        return categoryRepository.findAll().stream().map(this::mapToResponseDto).collect(Collectors.toList());
    }

    @Override
    public CategoryResponseDto updateCategory(Long id, CategoryRequestDto requestDto) {
        Category category = categoryRepository.findById(id).orElseThrow(() -> new RuntimeException("Category not found"));
        category.setCategoryName(requestDto.getCategoryName());
        category.setDescription(requestDto.getDescription());
        Category updated = categoryRepository.save(category);
        return mapToResponseDto(updated);
    }

    @Override
    public void deleteCategory(Long id) {
        categoryRepository.deleteById(id);
    }

    private CategoryResponseDto mapToResponseDto(Category category) {
        CategoryResponseDto dto = new CategoryResponseDto();
        dto.setCategoryId(category.getCategoryId());
        dto.setCategoryName(category.getCategoryName());
        dto.setDescription(category.getDescription());
        dto.setCreatedAt(category.getCreatedAt());
        return dto;
    }
}