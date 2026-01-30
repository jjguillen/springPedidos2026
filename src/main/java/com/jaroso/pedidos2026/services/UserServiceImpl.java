package com.jaroso.pedidos2026.services;

import com.jaroso.pedidos2026.dtos.UserCreateDto;
import com.jaroso.pedidos2026.dtos.UserDto;
import com.jaroso.pedidos2026.entities.User;
import com.jaroso.pedidos2026.mappers.UserMapper;
import com.jaroso.pedidos2026.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService, UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper mapper;

    @Override
    public List<UserDto> findAll() {
        return userRepository.findAll().stream().map(mapper::toDto).toList();
    }

    @Override
    public Optional<UserDto> findById(Long id) {
        return userRepository.findById(id).map(mapper::toDto);
    }

    @Override
    public Optional<UserDto> findByUserName(String userName) {
        return userRepository.findByUserName(userName).map(mapper::toDto);
    }

    @Override
    public UserDto saveUser(UserCreateDto user) {
        User userEntity = mapper.toEntity(user);
        return mapper.toDto(userRepository.save(userEntity));
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return this.userRepository.findByUserName(username).orElseThrow(
                () -> new UsernameNotFoundException(username + " no encontrado")
        );
    }

}
