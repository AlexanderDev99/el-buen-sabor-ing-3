package com.elbuensabor.reservas.cliente.controllers.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.elbuensabor.reservas.cliente.controllers.converters.ResultAPI;
import com.elbuensabor.reservas.cliente.logic.usercases.GetAllReservationsUserCase;
import com.elbuensabor.reservas.cliente.logic.usercases.GetReservationUserCase;
import com.elbuensabor.reservas.cliente.logic.usercases.MakeReservationUserCase;

@RestController
public class ReservationService {

    @Autowired
    private MakeReservationUserCase userCase;

    @Autowired
    private GetAllReservationsUserCase getAllReservationsCase;

    @Autowired
    GetReservationUserCase getReservationInfo;

    @GetMapping("/make-reservation")
    public ResultAPI makeReservation(
            @RequestParam("name") String userName,
            @RequestParam("date") String fechaReservaString,
            @RequestParam("people") int numeroComensales) {

        var reserva = userCase.makeReservation(userName, fechaReservaString, numeroComensales);

        return reserva.fold(
                val -> new ResultAPI(val.getReservaId().toString()),
                ex -> new ResultAPI(ex.getMessage()));
    }

    @GetMapping("/all-reservations")
    public ResultAPI getAllReservations() {
        return getAllReservationsCase.getAllReservs().fold(
                val -> new ResultAPI(val),
                ex -> new ResultAPI(ex.getMessage()));
    }

    @GetMapping("/all-reservations/{page}")
    public ResultAPI getAllReservations(@PathVariable("page") int page) {
        return getAllReservationsCase.getAllReservsPagginResult(page).fold(
                val -> new ResultAPI(val),
                ex -> new ResultAPI(ex.getMessage()));
    }

    @GetMapping("/get-reservation/{reservaId}")
    public ResultAPI getReservation(@PathVariable("reservaId") String reservaId) {
        return getReservationInfo.invoke(reservaId).fold(
                val -> new ResultAPI(val),
                ex -> new ResultAPI(ex.getMessage()));
    }

}
