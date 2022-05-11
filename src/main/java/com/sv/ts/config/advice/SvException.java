package com.sv.ts.config.advice;


import lombok.Getter;

@Getter
public class SvException extends RuntimeException {
    private String code;
    protected String shortMessage;
    protected Integer httpCode;

    public SvException(String code, String msg, Throwable e) {
        super(String.format("[%s] %s", code, msg), e);
        this.code = code;
    }

    public SvException(String code, String msg) {
        super(String.format("[%s] %s", code, msg));
        this.code = code;
    }

    public SvException(String code, String msg, String shortMessage) {
        super(String.format("[%s] %s", code, msg));
        this.code = code;
        this.shortMessage = shortMessage;
    }

    public SvException(String code) {
        super(String.format("[%s]", code));
        this.code = code;
    }

    public SvException(String code, Integer httpCode) {
        super(String.format("[%s]", code));
        this.code = code;
        this.httpCode = httpCode;
    }

    public SvException(String msg, Throwable e) {
        this("DEFAULT", msg, e);
    }
}

