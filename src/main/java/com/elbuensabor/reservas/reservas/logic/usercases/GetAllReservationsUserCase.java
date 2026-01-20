package com.elbuensabor.reservas.reservas.logic.usercases;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.elbuensabor.reservas.reservas.controllers.converters.EntityConvertes;
import com.elbuensabor.reservas.reservas.controllers.data.ReservaUI;
import com.elbuensabor.reservas.reservas.data.repository.ReservaRepository;
import com.elbuensabor.reservas.reservas.logic.validators.Result;

@Service
public class GetAllReservationsUserCase {

    @Autowired
    private ReservaRepository reservaRepository;

    public Result<List<ReservaUI>> getAllReservs() {

        Result<List<ReservaUI>> result = null;
        List<ReservaUI> reservasUI = new ArrayList<>();

        try {
            var reservas = reservaRepository.findAll();
            reservas.forEach(r -> reservasUI.add(
                    EntityConvertes.ReservationEntityToUI(r)));
            result = Result.success(reservasUI);
        } catch (Exception e) {
            result = Result.failure(e);
        }
        return result;
    }

    public Result<List<ReservaUI>> getAllReservsPagginResult(int page) {
        Result<List<ReservaUI>> result = null;
        List<ReservaUI> reservasUI = new ArrayList<>();
        try {
            Pageable pageable = PageRequest.of(page, 5);
            var reservas = reservaRepository.findAllPaging(pageable);
            reservas.forEach(r -> reservasUI.add(
                    EntityConvertes.ReservationEntityToUI(r)));
            result = Result.success(reservasUI);
        } catch (Exception e) {
            result = Result.failure(e);
        }
        return result;
    }

}
