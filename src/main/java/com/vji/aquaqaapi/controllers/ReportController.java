package com.vji.aquaqaapi.controllers;


import com.vji.aquaqaapi.controllers.dtos.requests.CreateReportRequest;
import com.vji.aquaqaapi.controllers.dtos.responses.GetReportResponse;
import com.vji.aquaqaapi.services.interfaces.IReportService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("report")
public class ReportController {
    @Autowired
    private IReportService service;

    @GetMapping("{id}")
    public GetReportResponse get(@PathVariable Long id){
    return service.get(id);
    }

    @GetMapping
    public List<GetReportResponse> list(){
        return service.list();
    }

    @PostMapping
    public GetReportResponse create(@RequestBody CreateReportRequest request){

        return service.create(request);
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
