package com.proyecto.ventas.Auth;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RegisterRequest {

    String nombres;
    String apellidos;
    String email;
    String password;
    String direccion; 
    String telefono;
    boolean estado;
    Integer rolId;
}