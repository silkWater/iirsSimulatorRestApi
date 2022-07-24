package com.connector.iirsSimulator.exception;

import lombok.Getter;

@Getter
public class RescueDataException extends RuntimeException {
    private String respErrCode;
    private String respErrMsg;
    private String detail;

    public RescueDataException(RescueDataCode rescueDataCode, String detail) {
        this.respErrCode = rescueDataCode.getExceptCode();
        this.respErrMsg = rescueDataCode.getExceptMsg();
        this.detail = detail;
    }
}