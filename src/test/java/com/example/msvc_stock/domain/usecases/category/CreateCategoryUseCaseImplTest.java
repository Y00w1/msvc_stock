package com.example.msvc_stock.domain.usecases.category;

import com.example.msvc_stock.domain.exceptions.category.CategoryAlreadyExistsException;
import com.example.msvc_stock.domain.exceptions.category.CategoryDescriptionIsRequiredException;
import com.example.msvc_stock.domain.exceptions.category.CategoryDescriptionTooLongException;
import com.example.msvc_stock.domain.exceptions.category.CategoryNameTooLongException;
import com.example.msvc_stock.domain.models.Category;
import com.example.msvc_stock.domain.ports.out.category.CategoryRepositoryPort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CreateCategoryUseCaseImplTest {
    @Mock
    private CategoryRepositoryPort categoryRepositoryPort;

    @InjectMocks
    private CreateCategoryUseCaseImpl createCategoryUseCase;

    private Category validCategory;

    @BeforeEach
    void setUp() {
        validCategory = new Category();
        validCategory.setName("Electronics");
        validCategory.setDescription("All kinds of electronic devices");
    }

    @Test
    void canCreateCategory() {
        // Arrange
        when(categoryRepositoryPort.findByName(anyString())).thenReturn(Optional.empty());
        when(categoryRepositoryPort.save(Mockito.any(Category.class))).thenReturn(validCategory);

        // Act
        Category createdCategory = createCategoryUseCase.createCategory(validCategory);

        // Assert
        assertNotNull(createdCategory);
        assertEquals("Electronics", createdCategory.getName());
        assertEquals("All kinds of electronic devices", createdCategory.getDescription());
    }

    @Test
    void shouldThrowExceptionWhenCategoryNameAlreadyExists() {
        // Arrange
        when(categoryRepositoryPort.findByName(validCategory.getName())).thenReturn(Optional.of(validCategory));

        // Act & Assert
        assertThrows(CategoryAlreadyExistsException.class, () -> createCategoryUseCase.createCategory(validCategory));
    }

    @Test
    void shouldThrowExceptionWhenDescriptionIsMissing() {
        // Arrange
        validCategory.setDescription("");

        // Act & Assert
        assertThrows(CategoryDescriptionIsRequiredException.class, () -> createCategoryUseCase.createCategory(validCategory));
    }

    @Test
    void shouldThrowExceptionWhenCategoryNameIsTooLong() {
        // Arrange
        validCategory.setName("A very very very long category name that exceeds fifty characters");

        // Act & Assert
        assertThrows(CategoryNameTooLongException.class, () -> createCategoryUseCase.createCategory(validCategory));
    }

    @Test
    void shouldThrowExceptionWhenCategoryDescriptionIsTooLong() {
        // Arrange
        validCategory.setDescription("A very very very long category description that exceeds ninety characters, which is not allowed in the system");

        // Act & Assert
        assertThrows(CategoryDescriptionTooLongException.class, () -> createCategoryUseCase.createCategory(validCategory));
    }
}