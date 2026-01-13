package com.elbuensabor.reservas;

import java.sql.Date;
import java.time.LocalDate;
import java.time.Period;

import com.elbuensabor.reservas.cliente.controllers.services.MakeReservationService;
import com.elbuensabor.reservas.cliente.logic.usercases.MakeReservationUserCase;
import com.elbuensabor.reservas.cliente.logic.validators.Result;

public class MainApp {
    public static void main(String[] args) {
        
        MakeReservationService service = new MakeReservationService(
                new MakeReservationUserCase());

        for (int i = 0; i < 2; i++) {

            int randomNum = (int) (Math.random() * (11));

            Result<String> reserva = service.makeReservation(
                    "JuanPerez",
                    Date.valueOf(
                            LocalDate
                                    .now()
                                    .plus(Period.ofDays(randomNum))
                                    .toString()),
                    randomNum);

            if (reserva.isSuccess())
                System.out.println("Reserva creada con ID: " + reserva.getOrNull());
            else
                System.out.println("Error al crear la reserva: " + reserva.exceptionOrNull().getMessage());
        }
    }

}
