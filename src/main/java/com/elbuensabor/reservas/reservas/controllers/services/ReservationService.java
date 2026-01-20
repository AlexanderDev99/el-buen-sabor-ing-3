package com.elbuensabor.reservas.reservas.controllers.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.elbuensabor.reservas.reservas.controllers.converters.ResultAPI;
import com.elbuensabor.reservas.reservas.logic.usercases.EstateReservationsUserCase;
import com.elbuensabor.reservas.reservas.logic.usercases.GetAllReservationsUserCase;
import com.elbuensabor.reservas.reservas.logic.usercases.GetReservationUserCase;
import com.elbuensabor.reservas.reservas.logic.usercases.MakeReservationUserCase;
import com.elbuensabor.reservas.reservas.logic.usercases.ModifyReservationUserCase;

@RestController
@RequestMapping("/api/reservation")
public class ReservationService {

    @Autowired
    private MakeReservationUserCase userCase;

    @Autowired
    private GetAllReservationsUserCase getAllReservationsCase;

    @Autowired
    GetReservationUserCase getReservationInfo;

    @Autowired
    private EstateReservationsUserCase stateReservationCase;

    @Autowired
    private ModifyReservationUserCase modifyReservationCase;

    // Crear reservas
    @GetMapping("/make-reservation")
    public ResultAPI makeReservation(
            @RequestParam("name") String userName,
            @RequestParam("date") String fechaReservaString,
            @RequestParam("people") int numeroComensales) {

        var reserva = userCase.execute(userName, fechaReservaString, numeroComensales);

        return reserva.fold(
                val -> new ResultAPI(val.getReservaId().toString()),
                ex -> new ResultAPI(ex.getMessage()));
    }

    // Mostrar todas las reservas
    @GetMapping("/all-reservations")
    public ResultAPI getAllReservations() {
        return getAllReservationsCase.getAllReservs().fold(
                val -> new ResultAPI(val),
                ex -> new ResultAPI(ex.getMessage()));
    }

    // Mostrar todas las reservas con paginacion
    @GetMapping("/all-reservations/{page}")
    public ResultAPI getAllReservations(@PathVariable("page") int page) {
        return getAllReservationsCase.getAllReservsPagginResult(page).fold(
                val -> new ResultAPI(val),
                ex -> new ResultAPI(ex.getMessage()));
    }

    // Mostrar una reserva por ID
    @GetMapping("/get-reservation/{reservaId}")
    public ResultAPI getReservation(@PathVariable("reservaId") String reservaId) {
        return getReservationInfo.execute(reservaId).fold(
                val -> new ResultAPI(val),
                ex -> new ResultAPI(ex.getMessage()));
    }

    // Cancelar una reserva por ID
    @PutMapping("/cancel-reservation/{reservaId}")
    public ResultAPI cancelReservation(@PathVariable("reservaId") String reservaId) {
        return stateReservationCase.calcelReservation(reservaId).fold(
                val -> new ResultAPI(val),
                ex -> new ResultAPI(ex.getMessage()));
    }

    // Completar reserva por ID
    @PutMapping("/complete-reservation/{reservaId}")
    public ResultAPI completeReservation(@PathVariable("reservaId") String reservaId) {
        return stateReservationCase.completeReservation(reservaId).fold(
                val -> new ResultAPI(val),
                ex -> new ResultAPI(ex.getMessage()));
    }

    // Modificar una reserva por ID
    @PutMapping("/modify-reservation/{reservaId}")
    public ResultAPI modifyReservation(
            @PathVariable("reservaId") String reservaId,
            @RequestParam("name") String newUserName,
            @RequestParam("date") String newDateString,
            @RequestParam("state") String newState,
            @RequestParam("table") int newMesaReservada,
            @RequestParam("people") int newPeopleCount) {

        return modifyReservationCase.execute(reservaId, newUserName, java.sql.Date.valueOf(newDateString), newState,
                newMesaReservada, newPeopleCount).fold(
                        val -> new ResultAPI(val),
                        ex -> new ResultAPI(ex.getMessage()));
    }

}
