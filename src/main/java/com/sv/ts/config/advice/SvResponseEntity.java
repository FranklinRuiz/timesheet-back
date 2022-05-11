package com.sv.ts.config.advice;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
public class SvResponseEntity<T> {
    private String traceId;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String shortMessage;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String message;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String errorCode;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private T data;
}

