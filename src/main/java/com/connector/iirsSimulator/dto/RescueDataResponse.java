package com.connector.iirsSimulator.dto;


import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class RescueDataResponse {
    private String respCode;
    private RespData respData;
}