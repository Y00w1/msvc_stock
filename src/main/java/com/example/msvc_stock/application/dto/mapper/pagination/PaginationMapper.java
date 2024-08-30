package com.example.msvc_stock.application.dto.mapper.pagination;

import com.example.msvc_stock.application.dto.pagination.PaginationDto;
import com.example.msvc_stock.domain.models.Pagination;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PaginationMapper {
    Pagination toDomain(PaginationDto paginationDto);
}
