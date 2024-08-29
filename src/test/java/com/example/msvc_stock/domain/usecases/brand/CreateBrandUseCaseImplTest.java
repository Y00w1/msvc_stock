package com.example.msvc_stock.domain.usecases.brand;

import com.example.msvc_stock.domain.exceptions.brand.BrandAlreadyExistsException;
import com.example.msvc_stock.domain.exceptions.brand.BrandDescriptionTooLongException;
import com.example.msvc_stock.domain.exceptions.brand.BrandNameTooLongException;
import com.example.msvc_stock.domain.models.Brand;
import com.example.msvc_stock.domain.ports.out.brand.BrandRepositoryPort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CreateBrandUseCaseImplTest {
    @Mock
    private BrandRepositoryPort brandRepositoryPort;

    @InjectMocks
    private CreateBrandUseCaseImpl createBrandUseCase;

    private Brand validBrand;

    @BeforeEach
    void setUp() {
        validBrand = new Brand();
        validBrand.setName("Brand 1");
        validBrand.setDescription("Description A");
    }

    @Test
    void createBrand_Success() {
        // Arrange
        when(brandRepositoryPort.getByName(validBrand.getName())).thenReturn(Optional.empty());
        when(brandRepositoryPort.createBrand(validBrand)).thenReturn(validBrand);

        // Act
        Brand createdBrand = createBrandUseCase.createBrand(validBrand);

        // Assert
        assertEquals(validBrand, createdBrand);
        verify(brandRepositoryPort).createBrand(validBrand);
    }

    @Test
    void createBrand_NameAlreadyExists() {
        // Arrange
        when(brandRepositoryPort.getByName(validBrand.getName())).thenReturn(Optional.of(validBrand));

        // Act & Assert
        assertThrows(BrandAlreadyExistsException.class, () -> createBrandUseCase.createBrand(validBrand));
        verify(brandRepositoryPort, never()).createBrand(validBrand);
    }

    @Test
    void createBrand_NameTooLong() {
        // Arrange
        validBrand.setName("This name is definitely more than fifty characters long, and should fail.");

        // Act & Assert
        assertThrows(BrandNameTooLongException.class, () -> createBrandUseCase.createBrand(validBrand));
        verify(brandRepositoryPort, never()).createBrand(validBrand);
    }

    @Test
    void createBrand_DescriptionTooLong() {
        // Arrange
        validBrand.setDescription("This description is definitely more than one hundred and twenty characters long, which means it should trigger the validation error that checks the description length.");

        // Act & Assert
        assertThrows(BrandDescriptionTooLongException.class, () -> createBrandUseCase.createBrand(validBrand));
        verify(brandRepositoryPort, never()).createBrand(validBrand);
    }

    @Test
    void createBrand_MissingDescription() {
        // Arrange
        validBrand.setDescription(null);

        // Act & Assert
        assertThrows(NullPointerException.class, () -> createBrandUseCase.createBrand(validBrand));
        verify(brandRepositoryPort, never()).createBrand(validBrand);
    }
}