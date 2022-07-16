package com.connector.iirsSimulator.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Stations {
    private String service;
    private String callSign;
    private int rsrp;
    private int ta;
    private int callType;
    private int cellType;
}