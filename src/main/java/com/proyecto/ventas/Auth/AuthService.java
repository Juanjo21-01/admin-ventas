package com.proyecto.ventas.Auth;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.proyecto.ventas.jwt.JwtService;
import com.proyecto.ventas.models.usuariosModel;
import com.proyecto.ventas.repository.usuariosRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final usuariosRepository usuariosRepository; 
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    public AuthResponse login(LoginRequest request) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));
        UserDetails usuario=usuariosRepository.findByEmail(request.getEmail()).orElseThrow();
        String token=jwtService.getToken(usuario);
        return AuthResponse.builder()
            .token(token)
            .build();
    }

    public AuthResponse register(RegisterRequest request) {
        usuariosModel usuario = usuariosModel.builder()
        .nombres(request.getNombres())
        .apellidos(request.getApellidos())
        .email(request.getEmail())
        .password(passwordEncoder.encode( request.getPassword()))
        .direccion(request.getDireccion())
        .telefono(request.getTelefono())
        .estado(request.isEstado())
        .rolId(request.getRolId())
        .build();

        usuariosRepository.save(usuario);
    
        return AuthResponse.builder()
        .token(jwtService.getToken(usuario))
        .build();
}
}
