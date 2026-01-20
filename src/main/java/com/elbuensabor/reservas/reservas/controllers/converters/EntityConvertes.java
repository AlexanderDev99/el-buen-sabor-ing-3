package com.elbuensabor.reservas.reservas.controllers.converters;

import com.elbuensabor.reservas.reservas.controllers.data.ReservaUI;
import com.elbuensabor.reservas.reservas.data.entities.db.ReservaEntityDB;

public class EntityConvertes {

    public static ReservaUI ReservationEntityToUI(ReservaEntityDB reservaEntity) {
        return new ReservaUI(
                reservaEntity.getReservaId(),
                reservaEntity.getUserName(),
                reservaEntity.getFechaReserva(),
                reservaEntity.getEstadoReserva(),
                reservaEntity.getMesaReservada(),
                reservaEntity.getNumeroComensales());
    }
}
