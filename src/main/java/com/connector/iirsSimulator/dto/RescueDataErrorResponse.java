package com.connector.iirsSimulator.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class RescueDataErrorResponse {
    private String errorCode;
    private String errorMsg;
    private String errorParam;
}