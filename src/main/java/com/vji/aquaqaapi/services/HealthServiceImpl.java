package com.vji.aquaqaapi.services;

import com.vji.aquaqaapi.controllers.dtos.responses.BaseResponse;
import com.vji.aquaqaapi.services.interfaces.IHealthService;
import com.vji.aquaqaapi.services.interfaces.IReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class HealthServiceImpl implements IHealthService {

    @Autowired
    private IReportService reportService;

    @Override
    public BaseResponse getStatusof(String sensorId, Long userId) {
        Boolean status = false;
        List<Float> data = reportService.listDailyDataOf(sensorId,userId);
        if (!data.isEmpty()){
            status = true;
        }

        return BaseResponse.builder()
                .data(status)
                .message("health check")
                .success(Boolean.TRUE)
                .httpStatus(HttpStatus.OK).build();
    }
}
