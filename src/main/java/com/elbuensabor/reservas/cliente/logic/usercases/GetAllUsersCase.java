package com.elbuensabor.reservas.cliente.logic.usercases;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.elbuensabor.reservas.cliente.controllers.converters.EntityConvertes;
import com.elbuensabor.reservas.cliente.controllers.data.UsuarioUI;
import com.elbuensabor.reservas.cliente.data.repository.UsuarioRepository;
import com.elbuensabor.reservas.cliente.logic.validators.Result;

@Service
public class GetAllUsersCase {

    @Autowired
    private UsuarioRepository repoUsuario;

    //Listar todos los usuarios
     public Result<List<UsuarioUI>> getAllUsers() {

        Result<List<UsuarioUI>> result = null;
        List<UsuarioUI> usuariosUI = new ArrayList<>();

        try {
            var usuarios = repoUsuario.findAll();
            usuarios.forEach(u -> usuariosUI.add(
                    EntityConvertes.UsuarioEntityToUI(u)));
            result = Result.success(usuariosUI);
        } catch (Exception e) {
            result = Result.failure(e);
        }
        return result;
    }
    
}
