package com.sv.ts.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@AllArgsConstructor
public enum TipoGenero {
    MASCULINO(1, "Masculino"),
    FEMENINO(2, "Femenino");

    private Integer id;
    private String nombre;

    public static TipoGenero find(Integer code) {
        return Arrays.stream(TipoGenero.values())
                .filter(e -> e.id.equals(code))
                .findFirst()
                .orElseThrow(() -> new IllegalStateException(String.format("Unsupported type %s.", code)));
    }

    public static List<TipoGenero> list() {
        return Arrays.stream(TipoGenero.values())
                .collect(Collectors.toList());
    }
}
