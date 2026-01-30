package com.jaroso.pedidos2026.services;

import com.jaroso.pedidos2026.dtos.AuthDto;
import com.jaroso.pedidos2026.dtos.UserCreateDto;
import com.jaroso.pedidos2026.dtos.UserDto;
import com.jaroso.pedidos2026.dtos.UserLoginDto;
import com.jaroso.pedidos2026.entities.User;
import com.jaroso.pedidos2026.repositories.UserRepository;
import com.jaroso.pedidos2026.security.JwtService;
import com.jaroso.pedidos2026.security.UserAuthority;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthService {

    Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserRepository repository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtService jwtService;

    /**
     * Guarda un nuevo usuario en la BBDD
     * @param userDTO
     * @return
     */
    public UserDto save(UserCreateDto userDTO) {
        User user = new User(
                null,
                userDTO.userName(),
                passwordEncoder.encode(userDTO.password()),
                userDTO.email(),
                List.of(UserAuthority.READ)
        );

        //Comprobar que el username no esté ya en BBDD
        if (this.repository.findByUserName(user.getUsername()).isPresent()) {
            log.error("El usuario ya existe");
            throw new RuntimeException("El usuario ya existe");
        }

        //Si no existe lo insertamos en BBDD y devolvemos un UserDto
        this.repository.save(user);

        return new UserDto(user.getId(), user.getUsername(), user.getEmail());
    }

    /**
     * Login de un usuario
     * @param user
     * @return AuthDto con el token JWT
     */
    public ResponseEntity<AuthDto> login(UserLoginDto user) {
        //1. Buscar el usuario en la BBDD
        Optional<User> userOptional = this.repository.findByUserName(user.userName());
        if (userOptional.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }

        //2. Comprobar que el password coincida con el del usuario
        Authentication authDTO = new UsernamePasswordAuthenticationToken(user.userName(), user.password());
        Authentication authentication =
                authenticationManager.authenticate(
                        new UsernamePasswordAuthenticationToken(
                                user.userName(),
                                user.password()
                        )
                );

        //3. Generar el token JWT
        String token = jwtService.generateToken(authentication);

        //4. Generar el objeto AuthDto con el token JWT y devolverlo en la respuesta Http
        User userEntity = (User) authentication.getPrincipal();
        AuthDto auth = new AuthDto(userEntity.getUsername(),
                userEntity.getAuthorities().stream().map(Object::toString).toList(),
                token);

        return ResponseEntity.ok(auth);
    }



}
