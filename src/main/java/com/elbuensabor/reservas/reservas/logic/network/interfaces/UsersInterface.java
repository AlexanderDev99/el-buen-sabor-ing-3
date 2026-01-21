package com.elbuensabor.reservas.reservas.logic.network.interfaces;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.elbuensabor.reservas.reservas.data.entities.apis.UserEntityAPI;

@FeignClient(name = "users-service")
public interface UsersInterface {

    @GetMapping("/api/users/getById/{idCliente}")
    UserEntityAPI GetInfoUsuario(@PathVariable("idCliente") String idCliente);

}
