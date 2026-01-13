package com.elbuensabor.reservas.cliente.controllers.services;

import com.elbuensabor.reservas.cliente.logic.usercases.MakeReservationUserCase;
import com.elbuensabor.reservas.cliente.logic.validators.Result;

public class MakeReservationService {

    private MakeReservationUserCase userCase;

    public MakeReservationService(MakeReservationUserCase userCase) {
        this.userCase = userCase;
    }

    public Result<String> makeReservation(String userName, java.sql.Date fechaReserva, int numeroComensales) {

        var reserva = userCase.makeReservation(userName, fechaReserva, numeroComensales);

        return reserva.fold(val -> Result.success(val.getReservaId()), ex -> Result.failure(ex));
    }

}
