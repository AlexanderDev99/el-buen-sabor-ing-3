package com.elbuensabor.reservas.cliente.data.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.elbuensabor.reservas.cliente.data.entities.UsuarioEntity;

@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioEntity, Long> {

    // Verificar si el correo ya existe
    boolean existsByEmailUsuario(String correo);

    // Buscar usuario por correo
    Optional<UsuarioEntity> findByEmailUsuario(String correo);

}
