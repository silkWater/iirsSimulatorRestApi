package com.connector.iirsSimulator.exception;

import com.connector.iirsSimulator.dto.RescueDataErrorResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@ControllerAdvice
public class RescueDataExceptionHandler {

    @ExceptionHandler(RescueDataException.class)
    @ResponseBody
    public RescueDataErrorResponse RescueDataExceptionResponse(
            HttpServletRequest request,
            RescueDataException e
    ) {
        log.error("url: {}, errorCode: {}, message: {}", request.getRequestURI(),
                e.getRespErrCode(), e.getRespErrMsg());

        return RescueDataErrorResponse.builder()
                .errorCode(e.getRespErrCode())
                .errorMsg(e.getRespErrMsg())
                .errorParam(e.getDetail())
                .build();
    }
}