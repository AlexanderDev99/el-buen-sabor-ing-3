package com.elbuensabor.reservas.cliente.logic.usercases;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.elbuensabor.reservas.cliente.data.entities.ReservaEntity;
import com.elbuensabor.reservas.cliente.data.repository.ReservaRepository;
import com.elbuensabor.reservas.cliente.logic.validators.Result;

@Service
public class GetAllReservations {
    
    @Autowired
    private ReservaRepository reservaRepository;

    public Result<List<ReservaEntity>> getAllReservs() {
        Result<List<ReservaEntity>> result = null;
        try {
            var reservas = reservaRepository.findAll();
            result = Result.success(reservas);
        } catch (Exception e) {
            result = Result.failure(e);
            System.out.println(e.getMessage());
        }
        return result;
    }
    
}
