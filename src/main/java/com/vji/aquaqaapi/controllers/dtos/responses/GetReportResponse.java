package com.vji.aquaqaapi.controllers.dtos.responses;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class GetReportResponse {
    private Long id;

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
