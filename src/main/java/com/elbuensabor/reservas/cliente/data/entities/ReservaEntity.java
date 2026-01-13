package com.elbuensabor.reservas.cliente.data.entities;

import java.sql.Date;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Data;

@Entity
@Data
@Builder
@Table(name = "reservas")
public class ReservaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;

    //Datos de la reserva
    private String reservaId;
    private String userName;
    private Date fechaReserva;
    private String estadoReserva;
    private int mesaReservada;
    private int numeroComensales;

   
    

}
