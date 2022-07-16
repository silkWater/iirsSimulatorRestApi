package com.connector.iirsSimulator.dto;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class RescueDataRequest {
    private int reqId;
    private String phone;
    private String name;
    private String healthy;
    private String age;
    private String gender;
    private String experienced;
    private String enterDnr;
    private String target;
    private String exitDnr;
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
    private Date enterDtm;
    private int weather;
    private String info;
    private String company;
    private int reqType;
}