package com.elbuensabor.reservas.reservas.data.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.elbuensabor.reservas.reservas.data.entities.db.ReservaEntityDB;

public interface ReservaRepository
        extends JpaRepository<ReservaEntityDB, Integer> {

    @Query("SELECT r FROM ReservaEntityDB r WHERE r.reservaId = ?1")
    public ReservaEntityDB findByReservaId(String reservaId);

    @Query("SELECT r FROM ReservaEntityDB r")
    public List<ReservaEntityDB> findAllPaging(Pageable pageable);
}
