package com.elbuensabor.reservas.cliente.logic.usercases;

import java.sql.Date;

import com.elbuensabor.reservas.cliente.data.entities.ReservaEntity;
import com.elbuensabor.reservas.cliente.data.repository.ReservationRepository;
import com.elbuensabor.reservas.cliente.logic.validators.Result;
import com.elbuensabor.reservas.cliente.logic.validators.UUIDReservers;

import jakarta.persistence.EntityManager;

public class MakeReservationUserCase {

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
        EntityManager em = ReservationRepository.getEntityManager();
        if (em != null) {
            try {
                em.getTransaction().begin();
                em.persist(reserva);
                em.getTransaction().commit();
                result = Result.success(reserva);
            } catch (Exception ex) {
                em.getTransaction().rollback();
                result = Result.failure(ex);
            }
        } else {
            result = Result.failure(new Exception("Error con la base de datos."));
        }
        return result;
    }

}
