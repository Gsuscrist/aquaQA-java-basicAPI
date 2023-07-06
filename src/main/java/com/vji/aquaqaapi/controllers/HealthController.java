package com.vji.aquaqaapi.controllers;

import com.vji.aquaqaapi.controllers.dtos.responses.BaseResponse;
import com.vji.aquaqaapi.services.interfaces.IHealthService;
import com.vji.aquaqaapi.services.interfaces.IReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Period;
import java.util.List;

@RestController
@RequestMapping("health")
public class HealthController {

    @Autowired
    private IHealthService service;


    @GetMapping("/{sensorId}/{userId}")
    public ResponseEntity<BaseResponse> getStatus(@PathVariable String sensorId, @PathVariable Long userId){
        BaseResponse baseResponse = service.getStatusof(sensorId,userId);
        return new ResponseEntity<>(baseResponse,baseResponse.getHttpStatus());
    }

    @GetMapping("/service")
    public ResponseEntity<BaseResponse> checkHealth(){
        BaseResponse baseResponse = BaseResponse.builder()
                .data("Ok")
                .message("service check")
                .httpStatus(HttpStatus.ACCEPTED)
                .success(Boolean.TRUE)
                .build();
        return new ResponseEntity<>(baseResponse,baseResponse.getHttpStatus());
    }




}
