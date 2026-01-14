package com.elbuensabor.reservas.cliente.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.elbuensabor.reservas.cliente.data.entities.ReservaEntity;

public interface ReservaRepository extends JpaRepository<ReservaEntity, Integer> {
    
}
