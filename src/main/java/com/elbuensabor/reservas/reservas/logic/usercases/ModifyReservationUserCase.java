package com.elbuensabor.reservas.reservas.logic.usercases;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.elbuensabor.reservas.reservas.controllers.converters.EntityConvertes;
import com.elbuensabor.reservas.reservas.controllers.data.ReservaUI;
import com.elbuensabor.reservas.reservas.data.repository.ReservaRepository;
import com.elbuensabor.reservas.reservas.logic.validators.Result;

@Service
public class ModifyReservationUserCase {

    @Autowired
    private ReservaRepository repoReserva;

    //Servicio para modificar una reserva existente
    public Result<ReservaUI> execute(String reservaId, String newUserName, 
        Date newDate, String newState, int newMesaReservada, int newPeopleCount) {
        Result<ReservaUI> result = null;

        try{
        var reserva = repoReserva.findByReservaId(reservaId);
        reserva.setUserName(newUserName);
        reserva.setFechaReserva(newDate);
        reserva.setEstadoReserva(newState);
        reserva.setMesaReservada(newMesaReservada);
        reserva.setNumeroComensales(newPeopleCount);
        repoReserva.save(reserva);
         var reservaUI = EntityConvertes.ReservationEntityToUI(reserva);
        result = Result.success(reservaUI);
        }catch(Exception e){
        result = Result.failure(e);
    }
    return result;

    }

}
