package com.elbuensabor.reservas.cliente.controllers.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioUI {

    private String nombreUsuario;
    private String apellidoUsuario;
    private String emailUsuario;
    private String passwordUsuario;
    private String passwordConfirmar;

}
