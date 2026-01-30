package com.jaroso.pedidos2026.services;

import com.jaroso.pedidos2026.dtos.UserCreateDto;
import com.jaroso.pedidos2026.dtos.UserDto;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<UserDto> findAll();
    Optional<UserDto> findById(Long id);
    Optional<UserDto> findByUserName(String userName);
    UserDto saveUser(UserCreateDto user);
    void deleteUser(Long id);
    UserDetails loadUserByUsername(String username);

}
