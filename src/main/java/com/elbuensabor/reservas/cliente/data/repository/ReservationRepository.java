package com.elbuensabor.reservas.cliente.data.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class ReservationRepository {

    private static EntityManagerFactory emf;
    private static EntityManager em;

    public static EntityManager getEntityManager() {
        try {
            if (em == null) {
                emf = Persistence.createEntityManagerFactory("reservasPU");
                em = emf.createEntityManager();
            }
            return em;
        } catch (Exception e) {
            return null;
        }
    }
}
