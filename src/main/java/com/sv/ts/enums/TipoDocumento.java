package com.sv.ts.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@AllArgsConstructor
public enum TipoDocumento {
    DNI(1, "DNI", "Documento Nacional de Identidad"),
    CE(2, "CE", "Carnet de Extranjeria"),
    C4(3, "C4", "Certificado de Inscripción"),
    PASSAPORTE(4, "PASSAPORTE", "Passaporte");

    private Integer id;
    private String code;
    private String nombre;

    public static TipoDocumento find(Integer code) {
        return Arrays.stream(TipoDocumento.values())
                .filter(e -> e.id.equals(code))
                .findFirst()
                .orElseThrow(() -> new IllegalStateException(String.format("Unsupported type %s.", code)));
    }

    public static List<TipoDocumento> list() {
        return Arrays.stream(TipoDocumento.values())
                .collect(Collectors.toList());
    }
}
