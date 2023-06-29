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

    @GetMapping("/data/{sensorId}/{userId}")
    public List<Float> getDataOf(@PathVariable String sensorId,@PathVariable Long userId){
        return service.listDailyDataOf(sensorId,userId);
    }




}
