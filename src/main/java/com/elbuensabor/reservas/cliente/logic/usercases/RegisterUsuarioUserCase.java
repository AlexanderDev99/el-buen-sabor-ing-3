package com.elbuensabor.reservas.cliente.logic.usercases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.elbuensabor.reservas.cliente.controllers.converters.EntityConvertes;
import com.elbuensabor.reservas.cliente.controllers.data.UsuarioUI;
import com.elbuensabor.reservas.cliente.data.entities.UsuarioEntity;
import com.elbuensabor.reservas.cliente.data.repository.UsuarioRepository;
import com.elbuensabor.reservas.cliente.logic.validators.Result;

@Service
public class RegisterUsuarioUserCase {

    @Autowired
    private UsuarioRepository repoUsuario;

    public Result<UsuarioUI> registerUsuario(UsuarioEntity usuario) {

        Result<UsuarioUI> result = null;

        try {

        //Verificar que las contraseñas coincidan
        if(!usuario.getPasswordUsuario().equals(usuario.getPasswordConfirmar())){
            throw new Exception("Las contraseñas no coinciden");
        }

        //Verificar si el correo ya esxiste en el sistema 
        if(repoUsuario.existsByEmailUsuario(usuario.getEmailUsuario())){
            throw new Exception("El correo ya está registrado");
        }
        
        //Registrar el nuevo usuario
        repoUsuario.save(usuario);
        var usuarioUI = EntityConvertes.UsuarioEntityToUI(usuario);
        result = Result.success(usuarioUI);
        } catch (Exception e) {
            result = Result.failure(e);
        }
        return result;
    }


}
