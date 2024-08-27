package com.example.msvc_stock.application.dto.mapper;

import com.example.msvc_stock.application.dto.pagination.SortDto;
import com.example.msvc_stock.domain.models.Sorter;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SortMapper {
    Sorter toDomain(SortDto sortDto);
}
