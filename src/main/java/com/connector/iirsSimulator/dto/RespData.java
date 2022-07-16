package com.connector.iirsSimulator.dto;

import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class RespData {
    private int respId;
    private String phone;
    private String company;
    private int reqType;
    private List<RegInfo> regInfo;
}