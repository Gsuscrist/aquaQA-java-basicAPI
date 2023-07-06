package com.vji.aquaqaapi.services.interfaces;

import com.vji.aquaqaapi.controllers.dtos.requests.CreateReportRequest;
import com.vji.aquaqaapi.controllers.dtos.responses.BaseResponse;
import com.vji.aquaqaapi.controllers.dtos.responses.GetReportResponse;

import java.util.List;

public interface IReportService {

    BaseResponse get(Long id);

    BaseResponse list();

    BaseResponse create(CreateReportRequest request);

    void delete(Long id);


    List<Float> listDailyDataOf(String sensorId, Long userId);

    List<Float> listWeeklyDataOf(String sensorId,Long userId);

    List<Float> listMonthlyDataOf(String sensorId, Long userId);

    List<Float> listYearlyDataOf(String sensorId, Long userId);



}
