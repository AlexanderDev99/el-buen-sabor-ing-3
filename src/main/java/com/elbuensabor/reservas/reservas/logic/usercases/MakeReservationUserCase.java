package com.elbuensabor.reservas.reservas.logic.usercases;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.elbuensabor.reservas.reservas.data.entities.db.ReservaEntityDB;
import com.elbuensabor.reservas.reservas.data.repository.ReservaRepository;
import com.elbuensabor.reservas.reservas.logic.validators.Result;
import com.elbuensabor.reservas.reservas.logic.validators.UUIDReservers;

@Service
public class MakeReservationUserCase {

    @Autowired
    private ReservaRepository reservaRepository;

    @Autowired
    private GetInfoUsuarioUserCase registerUsuarioUserCase;

    public Result<ReservaEntityDB> execute(
            String userId,
            String fechaReservaString,
            int numeroComensales) {

        Result<ReservaEntityDB> result = null;

        var userResult = registerUsuarioUserCase.execute(userId);

        try {
            Date fechaReserva = Date.valueOf(fechaReservaString);
            var reservaBuilder = ReservaEntityDB.builder()
                    .userName(userResult.getOrNull().name)
                    .fechaReserva(fechaReserva)
                    .estadoReserva("PENDIENTE")
                    .mesaReservada(-1)
                    .numeroComensales(numeroComensales);
            reservaBuilder.reservaId(UUIDReservers.generateRandomCode());
            var reserva = reservaBuilder.build();

            // Insertar la reserva en la base de datos
            var reservaSaved = reservaRepository.save(reserva);
            result = Result.success(reservaSaved);

        } catch (Exception e) {
            result = Result.failure(e);
        }
        return result;
    }

}
