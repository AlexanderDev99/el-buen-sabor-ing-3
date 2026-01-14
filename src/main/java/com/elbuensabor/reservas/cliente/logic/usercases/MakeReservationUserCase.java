package com.elbuensabor.reservas.cliente.logic.usercases;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.elbuensabor.reservas.cliente.data.entities.ReservaEntity;
import com.elbuensabor.reservas.cliente.data.repository.ReservaRepository;
import com.elbuensabor.reservas.cliente.logic.validators.Result;
import com.elbuensabor.reservas.cliente.logic.validators.UUIDReservers;

@Service
public class MakeReservationUserCase {

    @Autowired
    private ReservaRepository reservaRepository;

    public Result<ReservaEntity> makeReservation(
            String userName,
            Date fechaReserva,
            int numeroComensales) {

        var reservaBuilder = ReservaEntity.builder()
                .userName(userName)
                .fechaReserva(fechaReserva)
                .estadoReserva("PENDIENTE")
                .mesaReservada(-1)
                .numeroComensales(numeroComensales);
        reservaBuilder.reservaId(UUIDReservers.generateRandomCode());
        var reserva = reservaBuilder.build();

        // Insertar la reserva en la base de datos
        Result<ReservaEntity> result = null;
        try {
            var reservaSaved = reservaRepository.save(reserva);
            result = Result.success(reservaSaved);
        } catch (Exception e) {
            result = Result.failure(e);
        }
        return result;
    }

}
