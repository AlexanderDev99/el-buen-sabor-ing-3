package com.elbuensabor.reservas.reservas.data.entities.db;

import java.sql.Date;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "reservas")
public class ReservaEntityDB {

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
