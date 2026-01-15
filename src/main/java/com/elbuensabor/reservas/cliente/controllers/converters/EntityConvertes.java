package com.elbuensabor.reservas.cliente.controllers.converters;

import com.elbuensabor.reservas.cliente.controllers.data.ReservaUI;
import com.elbuensabor.reservas.cliente.controllers.data.UsuarioUI;
import com.elbuensabor.reservas.cliente.data.entities.ReservaEntity;
import com.elbuensabor.reservas.cliente.data.entities.UsuarioEntity;

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

    public static UsuarioUI UsuarioEntityToUI(UsuarioEntity usuarioEntity) {
        return new UsuarioUI(
                usuarioEntity.getNombreUsuario(),
                usuarioEntity.getApellidoUsuario(),
                usuarioEntity.getEmailUsuario(),
                usuarioEntity.getPasswordUsuario(),
                usuarioEntity.getPasswordConfirmar());
    }

}
