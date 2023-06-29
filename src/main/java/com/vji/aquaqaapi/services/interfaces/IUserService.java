package com.vji.aquaqaapi.services.interfaces;

import com.vji.aquaqaapi.controllers.dtos.requests.CreateUserRequest;
import com.vji.aquaqaapi.controllers.dtos.requests.UpdateUserRequest;
import com.vji.aquaqaapi.controllers.dtos.responses.GetUserResponse;
import com.vji.aquaqaapi.entities.User;

import java.util.List;

public interface IUserService {
    GetUserResponse get(Long id);

    List<GetUserResponse> list();

    GetUserResponse create(CreateUserRequest request);

    GetUserResponse update(Long id, UpdateUserRequest request);

    User findById(Long id);

    User getUser(String email);

    void delete(Long id);
}
