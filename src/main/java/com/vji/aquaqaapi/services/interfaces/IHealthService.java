package com.vji.aquaqaapi.services.interfaces;

import com.vji.aquaqaapi.controllers.dtos.responses.BaseResponse;

public interface IHealthService {

    BaseResponse getStatusof(String sensorId, Long userId);
}
