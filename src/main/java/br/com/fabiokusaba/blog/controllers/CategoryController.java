package br.com.fabiokusaba.blog.controllers;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fabiokusaba.blog.domain.dtos.CategoryDTO;
import br.com.fabiokusaba.blog.domain.dtos.CreateCategoryRequest;
import br.com.fabiokusaba.blog.domain.entities.Category;
import br.com.fabiokusaba.blog.mappers.CategoryMapper;
import br.com.fabiokusaba.blog.services.CategoryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(path = "/api/v1/categories")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;
    private final CategoryMapper categoryMapper;

    @GetMapping
    public ResponseEntity<List<CategoryDTO>> listCategories() {
        List<CategoryDTO> categories = categoryService.listCategories()
            .stream()
            .map(category -> categoryMapper.toDTO(category))
            .collect(Collectors.toList());

        return ResponseEntity.ok(categories);
    }

    @PostMapping
    public ResponseEntity<CategoryDTO> createCategory(@Valid @RequestBody CreateCategoryRequest request) {
        Category categoryToCreate = categoryMapper.toEntity(request);
        Category savedCategory = categoryService.createCategory(categoryToCreate);
        
        return new ResponseEntity<>(
            categoryMapper.toDTO(savedCategory),
            HttpStatus.CREATED
        );
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable UUID id) {
        categoryService.deleteCategory(id);
        return ResponseEntity.noContent().build();
    }

}
