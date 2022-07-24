package com.connector.iirsSimulator.controller;

import com.connector.iirsSimulator.dto.RescueDataRequest;
import com.connector.iirsSimulator.dto.RescueDataResponse;
import com.connector.iirsSimulator.service.RescueDataService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Slf4j
@CrossOrigin
@RequiredArgsConstructor
@RestController
@RequestMapping("/simulator")
public class ApiController {

    private final RescueDataService rescueDataService;

    //조난자 기지국 정보 요청
    @PostMapping("/rescueDataReq")
    public ResponseEntity<RescueDataResponse> rescueDataRequest(@RequestBody RescueDataRequest rescueDataRequest) {
        log.info("[RECV] /rescueDataReq");
        return ResponseEntity.ok(
                rescueDataService.getRequestData(rescueDataRequest)
        );
    }
}