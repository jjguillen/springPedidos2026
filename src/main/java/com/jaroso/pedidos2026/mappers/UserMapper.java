package com.jaroso.pedidos2026.mappers;


import com.jaroso.pedidos2026.dtos.UserCreateDto;
import com.jaroso.pedidos2026.dtos.UserDto;
import com.jaroso.pedidos2026.entities.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDto toDto(User user);
    User toEntity(UserCreateDto userDto);
}
