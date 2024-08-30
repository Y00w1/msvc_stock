package com.example.msvc_stock.infrastructure.jpa.repository.category;

import com.example.msvc_stock.domain.models.Category;
import com.example.msvc_stock.domain.models.Paged;
import com.example.msvc_stock.domain.models.Pagination;
import com.example.msvc_stock.domain.models.Sorter;
import com.example.msvc_stock.domain.ports.out.category.CategoryRepositoryPort;
import com.example.msvc_stock.infrastructure.jpa.mapper.CategoryEntityMapper;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@AllArgsConstructor
public class JpaCategoryRepositoryAdapter implements CategoryRepositoryPort {
    private final CategoryEntityMapper entityMapper;
    private final JpaCategoryRepository jpaCategoryRepository;

    @Override
    public Category save(Category category) {
        return entityMapper.toModel(jpaCategoryRepository.save(entityMapper.toEntity(category)));
    }

    @Override
    public Optional<Category> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public Optional<Category> findByName(String name) {
        return jpaCategoryRepository.findByName(name).map(entityMapper::toModel);
    }

    @Override
    public Paged<Category> findAll(Pagination pagination, Sorter sorter) {
        Pageable pageable = PageRequest.of(pagination.getPage(), pagination.getSize(), Sort.by(Sort.Direction.fromString(sorter.getDirection().name()), sorter.getField()));
        return entityMapper.toModelPaged(jpaCategoryRepository.findAll(pageable));
    }

    @Override
    public Optional<Category> update(Category category) {
        return Optional.empty();
    }

    @Override
    public boolean deleteById(Long id) {
        return false;
    }
}
