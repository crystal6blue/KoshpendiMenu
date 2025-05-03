package com.project.koshpendimenu1.Repository;

import com.project.koshpendimenu1.Model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
}
