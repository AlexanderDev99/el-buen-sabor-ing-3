package com.elbuensabor.reservas.reservas.logic.usercases;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.elbuensabor.reservas.reservas.data.entities.db.ReservaEntityDB;
import com.elbuensabor.reservas.reservas.data.repository.ReservaRepository;
import com.elbuensabor.reservas.reservas.logic.network.interfaces.UsersInterface;
import com.elbuensabor.reservas.reservas.logic.validators.Result;
import com.elbuensabor.reservas.reservas.logic.validators.UUIDReservers;

@Service
public class MakeReservationUserCase {

    @Autowired
    private ReservaRepository reservaRepository;

    @Autowired
    private UsersInterface usersInterface;

    public Result<ReservaEntityDB> execute(
            String userId,
            String fechaReservaString,
            int numeroComensales) {

        Result<ReservaEntityDB> result = null;

        try {
            var userResult = usersInterface.GetInfoUsuario(Integer.parseInt(userId));

            Date fechaReserva = Date.valueOf(fechaReservaString);
            var reservaBuilder = ReservaEntityDB.builder()
                    .userName(userResult.name + " " + userResult.lastName)
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
