package com.filip.springbootsecuritysample.repositories;

import com.filip.springbootsecuritysample.domain.models.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {

}
