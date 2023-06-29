package com.vji.aquaqaapi.services.interfaces;

import com.vji.aquaqaapi.controllers.dtos.requests.CreateReportRequest;
import com.vji.aquaqaapi.controllers.dtos.responses.GetReportResponse;

import java.util.List;

public interface IReportService {

    GetReportResponse get(Long id);

    List<GetReportResponse> list();

    GetReportResponse create(CreateReportRequest request);

    void delete(Long id);


    List<Float> listDailyDataOf(String sensorId, Long userId);

}
