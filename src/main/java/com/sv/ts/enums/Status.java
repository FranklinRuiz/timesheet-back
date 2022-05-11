package com.sv.ts.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Status {
    ACTIVE(true, "Registro activo"),
    INACTIVE(false, "Registro inactivo");

    private boolean value;
    private String description;
}
