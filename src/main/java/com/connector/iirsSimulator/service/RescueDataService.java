package com.connector.iirsSimulator.service;

import com.connector.iirsSimulator.dto.*;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class RescueDataService {

    public RescueDataResponse getRequestData(RescueDataRequest rescueDataRequest) {
        System.out.println("service ...");

        List<RegInfo> regInfoList = new ArrayList<RegInfo>();

        if (rescueDataRequest.getReqType() == 1)
        {
            Stations station = Stations.builder()
                    .service("4G")
                    .callSign("3202183744")
                    .callType(1)
                    .cellType(1)
                    .build();

            List<Stations> stationsList = new ArrayList<Stations>();
            stationsList.add(station);

            RegInfo regInfo = RegInfo.builder()
                    .time(LocalDateTime.now())
                    .stations(stationsList)
                    .build();
            regInfoList.add(regInfo);
        }
        else if (rescueDataRequest.getReqType() == 2)
        {
            Stations station1 = Stations.builder()
                    .service("4G")
                    .callSign("3202183744")
                    .callType(1)
                    .cellType(1)
                    .build();

            Stations station2 = Stations.builder()
                    .service("4G")
                    .callSign("3202183844")
                    .callType(1)
                    .cellType(1)
                    .build();

            Stations station3 = Stations.builder()
                    .service("4G")
                    .callSign("3202183944")
                    .callType(1)
                    .cellType(1)
                    .build();

            List<Stations> stationsList = new ArrayList<Stations>();
            stationsList.add(station1);
            RegInfo regInfo = RegInfo.builder()
                    .time(LocalDateTime.now())
                    .stations(stationsList)
                    .build();
            regInfoList.add(regInfo);

            stationsList = new ArrayList<Stations>();
            stationsList.add(station2);
            regInfo = RegInfo.builder()
                    .time(LocalDateTime.now())
                    .stations(stationsList)
                    .build();
            regInfoList.add(regInfo);

            stationsList = new ArrayList<Stations>();
            stationsList.add(station3);
            regInfo = RegInfo.builder()
                    .time(LocalDateTime.now())
                    .stations(stationsList)
                    .build();
            regInfoList.add(regInfo);
        }
        else if (rescueDataRequest.getReqType() == 3)
        {
            Stations serving = Stations.builder()
                    .service("4G")
                    .callSign("3202183744")
                    .rsrp(-90)
                    .ta(50)
                    .callType(1)
                    .cellType(1)
                    .build();

            Stations nehghbor1 = Stations.builder()
                    .service("4G")
                    .callSign("3202183000")
                    .callType(1)
                    .cellType(2)
                    .build();

            Stations nehghbor2 = Stations.builder()
                    .service("4G")
                    .callSign("3202184000")
                    .callType(1)
                    .cellType(2)
                    .build();

            Stations nehghbor3 = Stations.builder()
                    .service("4G")
                    .callSign("3202185000")
                    .callType(1)
                    .cellType(2)
                    .build();

            List<Stations> stationsList = new ArrayList<Stations>();
            stationsList.add(serving);
            stationsList.add(nehghbor1);
            stationsList.add(nehghbor2);
            stationsList.add(nehghbor3);

            RegInfo regInfo = RegInfo.builder()
                    .time(LocalDateTime.now())
                    .stations(stationsList)
                    .build();
            regInfoList.add(regInfo);
        }

        RespData respData = RespData.builder()
                .respId(rescueDataRequest.getReqId())
                .phone(rescueDataRequest.getPhone())
                .company(rescueDataRequest.getCompany())
                .reqType(rescueDataRequest.getReqType())
                .regInfo(regInfoList)
                .build();

        return RescueDataResponse.builder()
                .respCode("OK-200")
                .respData(respData)
                .build();
    }
}