package com.elbuensabor.reservas.reservas.logic.usercases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.elbuensabor.reservas.reservas.controllers.converters.EntityConvertes;
import com.elbuensabor.reservas.reservas.controllers.data.ReservaUI;
import com.elbuensabor.reservas.reservas.data.repository.ReservaRepository;
import com.elbuensabor.reservas.reservas.logic.validators.Result;

@Service
public class EstateReservationsUserCase {

    @Autowired
    private ReservaRepository repoReserva;

    public Result<ReservaUI> calcelReservation(String reservaId) {
        Result<ReservaUI> result = null;
        try {
            var reservaCancelada = repoReserva.findByReservaId(reservaId);
            reservaCancelada.setEstadoReserva("CANCELADA");
            repoReserva.save(reservaCancelada);
            var reservaUI = EntityConvertes.ReservationEntityToUI(reservaCancelada);
            result = Result.success(reservaUI);
        } catch (Exception e) {
            result = Result.failure(e);
        }
        return result;
    }

    public Result<ReservaUI> completeReservation(String reservaId) {
        Result<ReservaUI> result = null;
        try {
            var reservaComplete = repoReserva.findByReservaId(reservaId);
            reservaComplete.setEstadoReserva("COMPLETADA");
            reservaComplete.setMesaReservada(1);
            repoReserva.save(reservaComplete);
            var reservaUI = EntityConvertes.ReservationEntityToUI(reservaComplete);
            result = Result.success(reservaUI);
        } catch (Exception e) {
            result = Result.failure(e);
        }
        return result;
    }

    

}
