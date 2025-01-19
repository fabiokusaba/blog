package br.com.fabiokusaba.blog.services;

import java.util.List;
import java.util.UUID;

import br.com.fabiokusaba.blog.domain.entities.Category;

public interface CategoryService {
    List<Category> listCategories();
    Category createCategory(Category category);
    void deleteCategory(UUID id);
    Category getCategoryById(UUID id);
}
