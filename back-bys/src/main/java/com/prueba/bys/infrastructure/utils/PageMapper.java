package com.prueba.bys.infrastructure.utils;

import com.prueba.bys.domain.commons.PageResult;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.function.Function;

public final class PageMapper {

    private PageMapper() {}

    // Convierte un Page<Entity> de Spring a PageResult<DomainModel>
    public static <E, D> PageResult<D> fromPage(Page<E> page, Function<E, D> mapper) {
        List<D> items = page.getContent()
                .stream()
                .map(mapper)
                .toList();

        return new PageResult<>(
                items,
                page.getNumber(),
                page.getSize(),
                page.getTotalElements(),
                page.getTotalPages(),
                page.getNumberOfElements(),
                page.isFirst(),
                page.isLast(),
                page.hasNext(),
                page.hasPrevious(),
                page.getPageable().getOffset(),
                page.getSort().toString()
        );
    }

    // Convierte un PageResult<DomainModel> a PageResult<DTO>
    public static <D, R> PageResult<R> toDto(PageResult<D> pageResult, Function<D, R> mapper) {
        List<R> items = pageResult.getItems()
                .stream()
                .map(mapper)
                .toList();

        return new PageResult<>(
                items,
                pageResult.getPage(),
                pageResult.getSize(),
                pageResult.getTotalElements(),
                pageResult.getTotalPages(),
                pageResult.getNumberOfElements(),
                pageResult.isFirst(),
                pageResult.isLast(),
                pageResult.isHasNext(),
                pageResult.isHasPrevious(),
                pageResult.getOffset(),
                pageResult.getSort()
        );
    }
}