package com.elbuensabor.reservas.cliente.data.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "usuarios")
public class UsuarioEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El nombre de usuario es obligatorio") // validamos que no sea nulo ni vacio
    private String nombreUsuario;

    @NotBlank(message = "El apellido es obligatorio") // validamos que no sea nulo ni vacio
    private String apellidoUsuario;

    @Email(message = "El correo electrónico no es válido") // validamos que sea un email valido
    @NotBlank(message = "El correo electrónico es obligatorio") // validamos que no sea nulo ni vacio
    @Column(unique = true) // validamos que sea unico
    private String emailUsuario;

    @NotBlank(message = "La contraseña es obligatoria") // validamos que no sea nulo ni vacio
    private String passwordUsuario;

    @Transient // Indica que este campo NO se guardará en la base de datos, solo se usa en
               // memoria
    private String passwordConfirmar;
    
}
