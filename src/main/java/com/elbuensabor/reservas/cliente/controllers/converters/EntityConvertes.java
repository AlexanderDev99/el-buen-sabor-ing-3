package com.elbuensabor.reservas.cliente.controllers.converters;

import com.elbuensabor.reservas.cliente.controllers.data.ReservaUI;
import com.elbuensabor.reservas.cliente.data.entities.db.ReservaEntityDB;

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
