package com.elbuensabor.reservas.cliente.controllers.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.elbuensabor.reservas.cliente.data.entities.UsuarioEntity;
import com.elbuensabor.reservas.cliente.logic.usercases.GetAllUsersCase;
import com.elbuensabor.reservas.cliente.logic.usercases.RegisterUsuarioUserCase;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/auth")
public class UsuarioRegisterService {

    @Autowired
    private RegisterUsuarioUserCase registerUsuarioCase;

    @Autowired
    private GetAllUsersCase getAllUsersCase;

    @PostMapping("/registro")
    public ResponseEntity<?> registerUsuario(@Valid @RequestBody UsuarioEntity usuario) {
        var result = registerUsuarioCase.registerUsuario(usuario);
        return result.fold(
                val -> ResponseEntity.ok(val),
                ex -> ResponseEntity.badRequest().body(ex.getMessage())
        );
    }

    //Listar los usuarios
    @GetMapping("/users")
    public ResponseEntity<?> getAllUsers() {
        //Llamar al caso de uso para obtener todos los usuarios
       return getAllUsersCase.getAllUsers().fold(
                val -> ResponseEntity.ok(val),
                ex -> ResponseEntity.badRequest().body(ex.getMessage())
        );
    }
    
}
