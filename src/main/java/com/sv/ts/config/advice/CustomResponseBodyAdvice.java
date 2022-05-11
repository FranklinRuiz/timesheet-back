package com.sv.ts.config.advice;

import brave.Tracer;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
@RequiredArgsConstructor
public class CustomResponseBodyAdvice extends SvResponseBodyAdvice {
    private final Tracer tracer;

    @Override
    protected String getTraceId() {
        return tracer.currentSpan().context().traceIdString();
    }
}

