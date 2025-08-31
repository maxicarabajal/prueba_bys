package com.prueba.bys.infrastructure.utils;

import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import java.net.URI;

public class UriUtils {

    private UriUtils(){}

    public static URI buildUri(Long id) {
        return ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(id)
                .toUri();
    }
}
