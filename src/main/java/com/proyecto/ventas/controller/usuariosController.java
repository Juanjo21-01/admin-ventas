package com.proyecto.ventas.controller;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proyecto.ventas.DTO.LoginRequest;
import com.proyecto.ventas.models.usuariosModel;
import com.proyecto.ventas.repository.usuariosRepository;
import com.proyecto.ventas.service.JwtUtil;
import com.proyecto.ventas.service.usuariosService;

@CrossOrigin
@RestController
@RequestMapping("usuarios")
public class usuariosController {

    // autenticacion
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private usuariosRepository usuarioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    // *** */
    @Autowired
    private usuariosService usuariosService;

    // Listar todos los usuarios
    @GetMapping
    public Iterable<usuariosModel> getUsuarios() {
        return this.usuariosService.findAll();
    }

    // Listar por ID
    @GetMapping("/{idUsuario}")
    public ResponseEntity<usuariosModel> getUsuarioById(@PathVariable int idUsuario) {
        Optional<usuariosModel> usuario = this.usuariosService.findById(idUsuario);

        if (usuario.isPresent()) {
            return ResponseEntity.ok(usuario.get());
        } else {
            return ResponseEntity.badRequest().body(null);
        }
    }

    // Guardar un usuario
    @PostMapping
    public ResponseEntity<?> saveUsuario(@RequestBody usuariosModel entity) {
        try {
            this.usuariosService.save(entity);
            return ResponseEntity.ok(entity);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error al guardar el usuario");
        }
    }

    // Actualizar un usuario
    @PutMapping("/{idUsuario}")
    public ResponseEntity<?> updateUsuario(@PathVariable int idUsuario,
            @RequestBody usuariosModel entity) {
        try {
            Optional<usuariosModel> usuario = this.usuariosService.findById(idUsuario);

            if (usuario.isPresent()) {
                entity.setId(idUsuario);
                this.usuariosService.save(entity);
                return ResponseEntity.ok(entity);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body("Usuario no encontrado con ID: " + idUsuario);
            }
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error al actualizar el usuario");
        }
    }

    // Eliminar un usuario
    @DeleteMapping("/{idUsuario}")
    public ResponseEntity<String> deleteUsuario(@PathVariable int idUsuario) {
        try {
            this.usuariosService.deleteById(idUsuario);
            return ResponseEntity.ok("Usuario eliminado correctamente");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error al eliminar el usuario con ID: " + idUsuario);
        }
    }

    // Buscar por nombre
    @GetMapping("/nombres/{nombres}")
    public ResponseEntity<Iterable<usuariosModel>> getUsuariosByNombre(@PathVariable String nombres) {
        Iterable<usuariosModel> usuarios = this.usuariosService.findByNombres(nombres);

        if (usuarios.iterator().hasNext()) {
            return ResponseEntity.ok(usuarios);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    // Buscar por email
    @GetMapping("/email/{email}")
    public ResponseEntity<usuariosModel> getUsuariosByEmail(@PathVariable String email) {
        Optional<usuariosModel> usuarios = this.usuariosService.findByEmail(email);

        if (usuarios.isPresent()) {
            return ResponseEntity.ok(usuarios.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    // Buscar por estado
    @GetMapping("/estado/{estado}")
    public ResponseEntity<Iterable<usuariosModel>> getUsuariosByEstado(@PathVariable Boolean estado) {
        Iterable<usuariosModel> usuarios = this.usuariosService.findByEstado(estado);

        if (usuarios.iterator().hasNext()) {
            return ResponseEntity.ok(usuarios);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    // Buscar por rol
    @GetMapping("/rol/{rolId}")
    public ResponseEntity<Iterable<usuariosModel>> getUsuariosByRolId(@PathVariable Integer rolId) {
        Iterable<usuariosModel> usuarios = this.usuariosService.findByRolId(rolId);

        if (usuarios.iterator().hasNext()) {
            return ResponseEntity.ok(usuarios);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    // autenticacion
    @PostMapping("/register")
    public ResponseEntity<?> registrarUsuario(@RequestBody usuariosModel entity) {
        // Cifrar la contraseña antes de guardarla en la base de datos
        entity.setPassword(passwordEncoder.encode(entity.getPassword()));
        usuarioRepository.save(entity);
        Map<String, String> response = new HashMap<>();
        response.put("mensaje", "Usuario registrado con éxito");
        return ResponseEntity.ok(response);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        try {
            // Autentica al usuario usando AuthenticationManager
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword()));

            // Si la autenticación es exitosa, generar el token JWT
            final String jwt = jwtUtil.generateToken(loginRequest.getEmail());

            // Cargar el usuario para obtener más información
            Optional<usuariosModel> usuarioOptional = usuarioRepository.findByEmail(loginRequest.getEmail());

            if (!usuarioOptional.isPresent()) {
                return ResponseEntity.status(404).body("Usuario no encontrado");
            }

            usuariosModel usuario = usuarioOptional.get();

            // Se utiliza LinkedHashMap en vez de HashMap para mantener el orden de las
            // inserciones.
            Map<String, Object> usuarioResponse = new LinkedHashMap<>();
            usuarioResponse.put("id", usuario.getId());
            usuarioResponse.put("nombre", usuario.getNombres());
            usuarioResponse.put("email", usuario.getEmail());
            usuarioResponse.put("rolId", usuario.getRolId());

            // Se utiliza LinkedHashMap en vez de HashMap para mantener el orden de las
            // inserciones.
            Map<String, Object> response = new LinkedHashMap<>();
            response.put("mensaje", "Autenticación exitosa, Bienvenido " + usuario.getNombres());
            response.put("usuario", usuarioResponse);
            response.put("access_token", jwt);
            response.put("token_type", "Bearer");

            return ResponseEntity.ok(response);

        } catch (BadCredentialsException e) {
            // Si las credenciales son incorrectas
            return ResponseEntity.status(400).body("Credenciales incorrectas");
        } catch (Exception e) {
            // Capturar otros tipos de errores para obtener más información
            return ResponseEntity.status(500).body("Error durante el proceso de autenticación: " + e.getMessage());
        }
    }
}
