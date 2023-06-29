package com.vji.aquaqaapi.controllers.dtos.requests;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class CreateReportRequest {

    private Float externalTemp;

    private Float externalHum;

    private Float internalTemp;

    private Float phValue;

    private Float tdsValue;

    private Float tsValue;

    private Float tensionValue;

    private Boolean level;

    private Long userId;
}
