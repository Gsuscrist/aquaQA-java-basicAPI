package com.vji.aquaqaapi.services.interfaces;

import com.vji.aquaqaapi.controllers.dtos.requests.CreateUserRequest;
import com.vji.aquaqaapi.controllers.dtos.requests.UpdateUserRequest;
import com.vji.aquaqaapi.controllers.dtos.responses.BaseResponse;
import com.vji.aquaqaapi.controllers.dtos.responses.GetUserResponse;
import com.vji.aquaqaapi.entities.User;

import java.util.Base64;
import java.util.List;

public interface IUserService {
    BaseResponse get(Long id);

    BaseResponse list();

    BaseResponse create(CreateUserRequest request);

    BaseResponse update(Long id, UpdateUserRequest request);

    User findById(Long id);

    User getUser(String email);

    void delete(Long id);
}
