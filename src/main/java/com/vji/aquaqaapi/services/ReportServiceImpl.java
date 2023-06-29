package com.vji.aquaqaapi.services;

import com.vji.aquaqaapi.controllers.dtos.requests.CreateReportRequest;
import com.vji.aquaqaapi.controllers.dtos.responses.GetReportResponse;
import com.vji.aquaqaapi.entities.Report;
import com.vji.aquaqaapi.entities.User;
import com.vji.aquaqaapi.repositories.IReportRepository;
import com.vji.aquaqaapi.services.interfaces.IReportService;
import com.vji.aquaqaapi.services.interfaces.IUserService;
import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.stereotype.Service;



import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReportServiceImpl implements IReportService {
    @
    Autowired
    private IReportRepository repository;

    @Autowired
    private  IUserService userService;

    @Override
    public GetReportResponse get(Long id) {
        return from(id);
    }

    @Override
    public List<GetReportResponse> list() {
        return repository
                .findAll()
                .stream()
                .map(this::from)
                .collect(Collectors.toList());
    }

    @Override
    public GetReportResponse create(CreateReportRequest request) {
        return from(repository.save(from(request)));
    }


    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public List<Float> listDailyDataOf(String sensorId, Long userId) {
        return getDataOf(sensorId,userId);
    }

    private Report from(CreateReportRequest request){
        Report report = new Report();
        report.setExternalTemp(request.getExternalTemp());
        report.setExternalHum(request.getExternalHum());
        report.setInternalTemp(request.getInternalTemp());
        report.setPhValue(request.getPhValue());
        report.setTdsValue(request.getTdsValue());
        report.setTsValue(request.getTsValue());
        report.setTensionValue(request.getTensionValue());
        report.setLevel(request.getLevel());
        report.setUser(userService.findById(request.getUserId()));
        return report;
    }

    private GetReportResponse from(Report report){
        GetReportResponse response = new GetReportResponse();
        response.setId(report.getId());
        response.setExternalTemp(report.getExternalTemp());
        response.setExternalHum(report.getExternalHum());
        response.setInternalTemp(report.getInternalTemp());
        response.setPhValue(report.getPhValue());
        response.setTdsValue(report.getTdsValue());
        response.setTsValue(report.getTsValue());
        response.setTensionValue(report.getTensionValue());
        response.setLevel(report.getLevel());
        User user = report.getUser();
        response.setUserId(user.getId());
        return response;
    }


    private GetReportResponse from(Long idReport){
        return repository.findById(idReport)
                .map(this::from)
                .orElseThrow(()->new RuntimeException("report doesnt exist"));
    }

    private List<Float> getDataOf(String sensorId,Long userId) {
        List<Float> data = switch (sensorId) {
            case "etemp" -> repository.getDailyExtTempDataOf(userId);
            case "ehum" -> repository.getDailyExtHumDataOf(userId);
            case "itemp" -> repository.getDailyInterTempDataOf(userId);
            case "ph" -> repository.getDailyPhDataOf(userId);
            case "tds" -> repository.getDailyTdsDataOf(userId);
            case "ts" -> repository.getDailyTsDataOf(userId);
            case "tension" -> repository.getDailyTensionDataOf(userId);
            default -> new ArrayList<>();
        };
        return data;
    }


}
