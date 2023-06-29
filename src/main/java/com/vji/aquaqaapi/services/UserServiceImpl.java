package com.vji.aquaqaapi.services;

import com.vji.aquaqaapi.controllers.dtos.requests.CreateUserRequest;
import com.vji.aquaqaapi.controllers.dtos.requests.UpdateUserRequest;
import com.vji.aquaqaapi.controllers.dtos.responses.GetUserResponse;
import com.vji.aquaqaapi.entities.User;
import com.vji.aquaqaapi.repositories.IUserRepository;
import com.vji.aquaqaapi.services.interfaces.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private IUserRepository repository;
    

    @Override
    public GetUserResponse get(Long id) {
        return from(id);
    }

    @Override
    public List<GetUserResponse> list() {
         return repository
                .findAll()
                .stream()
                .map(this::from)
                .collect(Collectors.toList());
    }

    @Override
    public GetUserResponse create(CreateUserRequest request) {
        return from(repository.save(from(request)));
    }

    @Override
    public User findById(Long id) {
        return repository.findById(id).orElseThrow(()->new RuntimeException("user do not exist"));

    }

    @Override
    public GetUserResponse update(Long id, UpdateUserRequest request) {
        User user = repository.findById(id).orElseThrow(()->new RuntimeException("user do not exist"));
        user = update(user, request);
        return from(user);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }


    private User update(User user, UpdateUserRequest request) {
        user.setName(request.getName());
        user.setLastname(request.getLastname());
        user.setPhoneNumber(request.getPhoneNumber());
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());

        if (request.getRol() == null){
            user.setRol("user");
        }else {
            user.setRol(user.getRol());
        }
        return repository.save(user);
    }


    private User from(CreateUserRequest request) {
        User user = new User();
        user.setName(request.getName());
        user.setLastname(request.getLastname());
        user.setPhoneNumber(request.getPhoneNumber());

        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());
        if (request.getRol() == null){
            user.setRol("user");
        }else {
            user.setRol(user.getRol());
        }

        return user;
    }

    private GetUserResponse from(User user) {
        GetUserResponse response = new GetUserResponse();
        response.setId(user.getId());
        response.setName(user.getName());
        response.setLastname(user.getLastname());
        response.setEmail(user.getEmail());
        response.setPhoneNumber(user.getPhoneNumber());
        response.setPassword(user.getPassword());
        response.setRol(user.getRol());
        return response;
    }


    private GetUserResponse from(Long idUser) {
        return repository.findById(idUser)
                .map(this::from)
                .orElseThrow(() -> new RuntimeException("The user does not exist"));
    }
}
