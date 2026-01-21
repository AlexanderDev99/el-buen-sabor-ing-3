package com.elbuensabor.reservas.reservas.logic.network.interfaces;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.elbuensabor.reservas.reservas.data.entities.apis.UserEntityAPI;

@FeignClient(name = "USUARIO-SERVICE")
public interface UsersInterface {

    @GetMapping("/usuario/buscar")
    UserEntityAPI GetInfoUsuario(@RequestParam("id") Integer idCliente);

}
