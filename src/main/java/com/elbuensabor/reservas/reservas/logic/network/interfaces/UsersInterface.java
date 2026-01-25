package com.elbuensabor.reservas.reservas.logic.network.interfaces;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.elbuensabor.reservas.reservas.data.entities.apis.UserEntityAPI;


//Interfaz de comunicación con el servicio de usuarios
@FeignClient(name = "usuario-service")
public interface UsersInterface {

    @GetMapping("/api/usuarios/buscar")
    UserEntityAPI GetInfoUsuario(@RequestParam("id") Integer idCliente);

}
