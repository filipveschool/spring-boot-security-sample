package com.filip.springbootsecuritysample.services;

import com.filip.springbootsecuritysample.domain.models.Reservation;
import com.filip.springbootsecuritysample.repositories.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    // Retrieve all rows from table
    public List<Reservation> getAllReservations() {
        return reservationRepository.findAll();
    }

    // Retrieves one row from table based on given id
    public Reservation getReservation(Long id){
        return reservationRepository.getOne(id);
    }

    // Inserts row into table
    public void addReservation(Reservation reservation){
        reservationRepository.saveAndFlush(reservation);
    }

    // Updates row into table
    public void updateReservation(Long id, Reservation reservation){
        Reservation reservationFromDB = reservationRepository.getOne(id);
        reservationFromDB.setPartySize(reservation.getPartySize());
        reservationFromDB.setRestaurantId(reservation.getRestaurantId());
        reservationFromDB.setUserId(reservation.getUserId());
        reservationRepository.saveAndFlush(reservationFromDB);
    }

    // removes row from table
    public void deleteReservation(Long id){
        reservationRepository.deleteById(id);
    }

    // removes Reservation object from table
    public void deleteReservationObject(Reservation reservation){
        reservationRepository.delete(reservation);
    }
}
