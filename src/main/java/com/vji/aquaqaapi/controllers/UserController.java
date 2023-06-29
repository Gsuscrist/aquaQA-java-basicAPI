package com.vji.aquaqaapi.controllers;

import com.vji.aquaqaapi.controllers.dtos.requests.CreateReportRequest;
import com.vji.aquaqaapi.controllers.dtos.requests.CreateUserRequest;
import com.vji.aquaqaapi.controllers.dtos.requests.UpdateUserRequest;
import com.vji.aquaqaapi.controllers.dtos.responses.GetUserResponse;
import com.vji.aquaqaapi.repositories.IUserRepository;
import com.vji.aquaqaapi.services.interfaces.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    private IUserService service;

    @GetMapping("{id}")
    public GetUserResponse get(@PathVariable Long id){
    return service.get(id);
    }

    @GetMapping
    public List<GetUserResponse> list(){
        return service.list();
    }

    @PostMapping
    public GetUserResponse create(@RequestBody CreateUserRequest request){
        return service.create(request);
    }

    @PutMapping("{id}")
    public GetUserResponse update(@PathVariable Long id, @RequestBody UpdateUserRequest request) {
        return service.update(id, request);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }


}
