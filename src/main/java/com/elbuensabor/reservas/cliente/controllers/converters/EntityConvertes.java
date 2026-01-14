package com.elbuensabor.reservas.cliente.controllers.converters;

import com.elbuensabor.reservas.cliente.controllers.data.ReservaUI;
import com.elbuensabor.reservas.cliente.data.entities.ReservaEntity;

public class EntityConvertes {

    public static ReservaUI ReservationEntityToUI(ReservaEntity reservaEntity) {
        return new ReservaUI(
                reservaEntity.getReservaId(),
                reservaEntity.getUserName(),
                reservaEntity.getFechaReserva(),
                reservaEntity.getEstadoReserva(),
                reservaEntity.getMesaReservada(),
                reservaEntity.getNumeroComensales());
    }

}
