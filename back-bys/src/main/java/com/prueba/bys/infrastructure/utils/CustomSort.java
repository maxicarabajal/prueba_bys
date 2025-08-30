package com.prueba.bys.infrastructure.utils;

import org.springframework.data.domain.Sort;

import java.util.Arrays;
import java.util.List;

public final class CustomSort {

    private CustomSort() {}

    public static Sort from(String sortParam) {
        if (sortParam == null || sortParam.isBlank()) {
            return Sort.unsorted();
        }

        List<Sort.Order> orders = Arrays.stream(sortParam.split(";"))
                .map(orderStr -> {
                    String[] parts = orderStr.split(",");
                    String property = parts[0].trim();
                    Sort.Direction direction = (parts.length > 1 && parts[1].equalsIgnoreCase("desc"))
                            ? Sort.Direction.DESC
                            : Sort.Direction.ASC;
                    return new Sort.Order(direction, property);
                })
                .toList();

        return Sort.by(orders);
    }
}

