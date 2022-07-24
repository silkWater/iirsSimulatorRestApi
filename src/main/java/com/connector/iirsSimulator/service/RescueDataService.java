package com.connector.iirsSimulator.service;

import com.connector.iirsSimulator.dto.*;
import com.connector.iirsSimulator.exception.RescueDataException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import static com.connector.iirsSimulator.exception.RescueDataCode.NO_DATA;
import static com.connector.iirsSimulator.exception.RescueDataCode.MANDATORY_PARAM_ERROR;
import static com.connector.iirsSimulator.exception.RescueDataCode.INVALID_PARAM_ERROR;
import static com.connector.iirsSimulator.exception.RescueDataCode.INTERNAL_SERVER_ERROR;

@RequiredArgsConstructor
@Service
public class RescueDataService {

    public RescueDataResponse getRequestData(RescueDataRequest rescueDataRequest) {
        validateRescueDataRequest(rescueDataRequest);

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

    public void validateRescueDataRequest(RescueDataRequest request) {
        if (request.getPhone() == null || request.getPhone().trim().isEmpty())      throw new RescueDataException(MANDATORY_PARAM_ERROR, "phone");
        if (request.getName() == null || request.getName().trim().isEmpty())        throw new RescueDataException(MANDATORY_PARAM_ERROR, "name");
        if (request.getHealthy() == null || request.getHealthy().trim().isEmpty())  throw new RescueDataException(MANDATORY_PARAM_ERROR, "healty");
        if (request.getAge() == null || request.getAge().trim().isEmpty())          throw new RescueDataException(MANDATORY_PARAM_ERROR, "age");
        if (request.getGender() == null || request.getGender().trim().isEmpty())    throw new RescueDataException(MANDATORY_PARAM_ERROR, "gender");
        if (request.getExperienced() == null || request.getExperienced().trim().isEmpty())      throw new RescueDataException(MANDATORY_PARAM_ERROR, "experienced");
        if (request.getTarget() == null || request.getTarget().trim().isEmpty())    throw new RescueDataException(MANDATORY_PARAM_ERROR, "target");
        if (request.getEnterDtm() == null || request.getEnterDtm().toString().trim().isEmpty()) throw new RescueDataException(MANDATORY_PARAM_ERROR, "enterDtm");
        if (request.getCompany() == null || request.getCompany().trim().isEmpty())  throw new RescueDataException(MANDATORY_PARAM_ERROR, "company");

        if (Pattern.matches("^01(?:0|1|[6-9])-(?:\\d{3}|\\d{4})-\\d{4}$", request.getPhone()) == false) throw new RescueDataException(INVALID_PARAM_ERROR, "phone");
        if (Pattern.matches("^[상중하]$", request.getHealthy()) == false)      throw new RescueDataException(INVALID_PARAM_ERROR, "healthy");
        if (Pattern.matches("^[1-7]0대$", request.getAge()) == false)         throw new RescueDataException(INVALID_PARAM_ERROR, "age");
        if (Pattern.matches("^[상중하]$", request.getExperienced()) == false)  throw new RescueDataException(INVALID_PARAM_ERROR, "experienced");
        if (request.getWeather() < 0 && request.getWeather() > 6)   throw new RescueDataException(INVALID_PARAM_ERROR, "wheather");
        if (request.getReqType() < 1 && request.getReqType() > 3)   throw new RescueDataException(INVALID_PARAM_ERROR, "reqType");
    }
}