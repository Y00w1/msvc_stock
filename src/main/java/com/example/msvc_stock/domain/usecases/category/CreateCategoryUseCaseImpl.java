package com.example.msvc_stock.domain.usecases.category;

import com.example.msvc_stock.domain.exceptions.category.CategoryAlreadyExistsException;
import com.example.msvc_stock.domain.exceptions.category.CategoryDescriptionIsRequiredException;
import com.example.msvc_stock.domain.exceptions.category.CategoryDescriptionTooLongException;
import com.example.msvc_stock.domain.exceptions.category.CategoryNameTooLongException;
import com.example.msvc_stock.domain.models.Category;
import com.example.msvc_stock.domain.ports.in.category.CreateCategoryUseCase;
import com.example.msvc_stock.domain.ports.out.category.CategoryRepositoryPort;

/**
 * Implementation of the use case for creating categories.
 * Contains the business logic for validating and creating a category.
 */
public class CreateCategoryUseCaseImpl implements CreateCategoryUseCase {
    private final CategoryRepositoryPort categoryRepositoryPort;

    /**
     * Constructor that injects the dependency of the category repository port.
     *
     * @param categoryRepositoryPort Repository port for managing categories.
     */
    public CreateCategoryUseCaseImpl(CategoryRepositoryPort categoryRepositoryPort) {
        this.categoryRepositoryPort = categoryRepositoryPort;
    }

    /**
     * Creates a new category after validating the provided data.
     *
     * @param category Domain object representing the category to be created.
     * @return The created category.
     * @throws CategoryAlreadyExistsException If the category name already exists.
     * @throws CategoryDescriptionIsRequiredException If the category description is null or empty.
     * @throws CategoryNameTooLongException If the category name exceeds 50 characters.
     * @throws CategoryDescriptionTooLongException If the category description exceeds 90 characters.
     */
    @Override
    public Category createCategory(Category category) {
        validateCategory(category);
        return categoryRepositoryPort.save(category);
    }

    /**
     * Validates the category data before proceeding with its creation.
     *
     * @param category Domain object representing the category to be validated.
     * @throws CategoryAlreadyExistsException If the category name already exists.
     * @throws CategoryDescriptionIsRequiredException If the category description is null or empty.
     * @throws CategoryNameTooLongException If the category name exceeds 50 characters.
     * @throws CategoryDescriptionTooLongException If the category description exceeds 90 characters.
     */
    private void validateCategory(Category category) {
        categoryRepositoryPort.findByName(category.getName()).ifPresent(c -> {
            throw new CategoryAlreadyExistsException("Category already exists");
        });
        if (category.getDescription() == null || category.getDescription().isEmpty()) {
            throw  new CategoryDescriptionIsRequiredException();
        }
        if (category.getName().length() > 50) {
            throw new CategoryNameTooLongException();
        }
        if (category.getDescription().length() > 90) {
            throw new CategoryDescriptionTooLongException();
        }
    }
}
