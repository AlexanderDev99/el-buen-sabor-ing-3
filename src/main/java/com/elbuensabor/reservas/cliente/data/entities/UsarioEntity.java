package com.elbuensabor.reservas.cliente.data.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Data;

@Entity
@Data
@Builder
@Table(name = "usuarios")
public class UsarioEntity {

    @Id
    private Integer usuarioId;

    //Datos del usuario
    private String nombreUsuario;
    private String apellidoUsario;
    private Integer edad;

}
