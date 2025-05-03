package com.project.koshpendimenu1.Service.ReservationService;

import com.project.koshpendimenu1.Model.Reservation;

import java.util.Optional;

public interface IReservationService {

    // Add a new reservation
    Reservation addReservation(Reservation reservation);

    // Update an existing reservation
    Reservation updateReservation(Long id, Reservation updatedReservation);

    // Delete a reservation by ID
    void deleteReservation(Long id);

    // Fetch a reservation by ID
    Optional<Reservation> getReservationById(Long id);

    // Fetch all reservations
    Iterable<Reservation> getAllReservations();
}
