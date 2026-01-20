package com.elbuensabor.reservas.reservas.logic.usercases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.elbuensabor.reservas.reservas.controllers.converters.EntityConvertes;
import com.elbuensabor.reservas.reservas.controllers.data.ReservaUI;
import com.elbuensabor.reservas.reservas.data.repository.ReservaRepository;
import com.elbuensabor.reservas.reservas.logic.validators.Result;

@Service
public class GetReservationUserCase {

    @Autowired
    private ReservaRepository reservaRepository;

    public Result<ReservaUI> execute(String reservaId) {
        Result<ReservaUI> result = null;
        try {
            var reservas = reservaRepository.findByReservaId(reservaId);
            var reservaUI = EntityConvertes.ReservationEntityToUI(reservas);
            result = Result.success(reservaUI);
        } catch (Exception e) {
            result = Result.failure(e);
        }
        return result;
    }

}
