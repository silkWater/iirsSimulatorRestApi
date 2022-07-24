package com.connector.iirsSimulator.dto;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class RescueDataRequest {
    @NotNull
    private int reqId;
    @NotNull
    private String phone;
    @NotNull
    private String name;
    @NotNull
    private String healthy;
    @NotNull
    private String age;
    @NotNull
    private String gender;
    @NotNull
    private String experienced;
    @NotNull
    private String enterDnr;
    private String target;
    private String exitDnr;
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
    private Date enterDtm;
    @NotNull
    private int weather;
    private String info;
    @NotNull
    private String company;
    @NotNull
    private int reqType;
}