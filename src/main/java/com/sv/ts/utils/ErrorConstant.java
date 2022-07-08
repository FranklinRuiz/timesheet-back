package com.sv.ts.utils;

import lombok.NoArgsConstructor;

import static lombok.AccessLevel.PRIVATE;

@NoArgsConstructor(access = PRIVATE)
public class ErrorConstant {
    public static final String ERROR_SAVE = "error.save";
    public static final String ERROR_UPDATE = "error.update";
    public static final String ERROR_DELETE = "error.delete";
    public static final String ERROR_FIND = "error.find";
    public static final String ERROR_EMPLOYEE_EXISTES = "error.employee.exists";
    public static final String ERROR_CARGO_EXISTES = "error.cargo.exists";
    public static final String ERROR_HORARIO_EXISTES = "error.horario.exists";
}
