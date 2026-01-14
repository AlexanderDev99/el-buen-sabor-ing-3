package com.elbuensabor.reservas.cliente.controllers.services;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.elbuensabor.reservas.cliente.data.entities.ReservaEntity;
import com.elbuensabor.reservas.cliente.logic.usercases.GetAllReservations;
import com.elbuensabor.reservas.cliente.logic.usercases.MakeReservationUserCase;

@RestController
public class ReservationService {

    @Autowired
    private MakeReservationUserCase userCase;

    @Autowired
    private GetAllReservations getAllReservationsCase;

    @GetMapping("/make-reservation")
    public String makeReservation(
            @RequestParam("name") String userName,
            @RequestParam("date") String fechaReservaString,
            @RequestParam("people") int numeroComensales) {

        Date fechaReserva = Date.valueOf(fechaReservaString);
        var reserva = userCase.makeReservation(userName, fechaReserva, numeroComensales);

        return reserva.fold(
                val -> val.getReservaId().toString(),
                ex -> ex.getMessage());
    }

    @GetMapping("/all-reservations")
    public List<ReservaEntity> getAllReservations() {
        return getAllReservationsCase.getAllReservs().fold(
                val -> val,
                ex -> List.of());
    }

}
