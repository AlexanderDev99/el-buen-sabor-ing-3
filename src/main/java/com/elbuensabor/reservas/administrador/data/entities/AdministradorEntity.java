package com.elbuensabor.reservas.administrador.data.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table (name = "administradores")
public class AdministradorEntity {

    @Id
    private Integer idAdministrador;
    private String nombre;
    private String apellido;
}
