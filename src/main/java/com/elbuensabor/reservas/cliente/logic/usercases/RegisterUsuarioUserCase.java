package com.elbuensabor.reservas.cliente.logic.usercases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.elbuensabor.reservas.cliente.data.entities.apis.UserEntityAPI;
import com.elbuensabor.reservas.cliente.logic.validators.Result;

@Service
public class RegisterUsuarioUserCase {

    public Result<UserEntityAPI> execute(String idCliente) {
        try {
            RestTemplate restTemplate = new RestTemplate();
            String url = "https://jsonplaceholder.typicode.com/users/" + idCliente;
            UserEntityAPI user = restTemplate.getForObject(url, UserEntityAPI.class);
            return Result.success(user);
        } catch (Exception e) {
            return Result.failure(e);
        }
    }
}
