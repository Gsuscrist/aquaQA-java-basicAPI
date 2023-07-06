package com.vji.aquaqaapi.controllers;


import com.vji.aquaqaapi.controllers.dtos.requests.CreateReportRequest;
import com.vji.aquaqaapi.controllers.dtos.responses.BaseResponse;
import com.vji.aquaqaapi.controllers.dtos.responses.GetReportResponse;
import com.vji.aquaqaapi.services.interfaces.IReportService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("report")
public class ReportController {
    @Autowired
    private IReportService service;

    @GetMapping("{id}")
    public ResponseEntity<BaseResponse> get(@PathVariable Long id){
    BaseResponse baseResponse = service.get(id);
    return new ResponseEntity<>(baseResponse,baseResponse.getHttpStatus());
    }

    @GetMapping
    public ResponseEntity<BaseResponse> list(){
        BaseResponse baseResponse =  service.list();
        return new ResponseEntity<>(baseResponse,baseResponse.getHttpStatus());
    }

    @PostMapping
    public ResponseEntity<BaseResponse> create(@RequestBody CreateReportRequest request){

        BaseResponse baseResponse = service.create(request);
        return new ResponseEntity<>(baseResponse,baseResponse.getHttpStatus());
    }


    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }


//    all reports

    @GetMapping("/daily/data/{sensorId}/{userId}")
    public List<Float> getDailyDataOf(@PathVariable String sensorId,@PathVariable Long userId){
        return service.listDailyDataOf(sensorId,userId);
    }

    @GetMapping("/weekly/data/{sensorId}/{userId}")
    public List<Float> getWeeklyDataOf(@PathVariable String sensorId,@PathVariable Long userId){
        return service.listWeeklyDataOf(sensorId,userId);
    }

    @GetMapping("/monthly/data/{sensorId}/{userId}")
    public List<Float> getMonthlyDataOf(@PathVariable String sensorId,@PathVariable Long userId){
        return service.listMonthlyDataOf(sensorId,userId);
    }

    @GetMapping("/yearly/data/{sensorId}/{userId}")
    public List<Float> getYearlyDataOf(@PathVariable String sensorId,@PathVariable Long userId){
        return service.listYearlyDataOf(sensorId,userId);
    }



}
