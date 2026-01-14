package com.elbuensabor.reservas.cliente.data.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.elbuensabor.reservas.cliente.data.entities.ReservaEntity;

public interface ReservaRepository
        extends JpaRepository<ReservaEntity, Integer> {

    @Query("SELECT r FROM ReservaEntity r WHERE r.reservaId = ?1")
    public ReservaEntity findByReservaId(String reservaId);

    @Query("SELECT r FROM ReservaEntity r")
    public List<ReservaEntity> findAllPaging(Pageable pageable);
}
