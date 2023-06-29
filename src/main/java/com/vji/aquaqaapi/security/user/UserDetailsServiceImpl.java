package com.vji.aquaqaapi.security.user;

import com.vji.aquaqaapi.entities.User;
import com.vji.aquaqaapi.services.interfaces.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private IUserService service;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = service.getUser(username);
        if (user.getName().isEmpty()){
            return null;
        }else {
            return new UserDetailsImpl(user);
        }

    }
}
