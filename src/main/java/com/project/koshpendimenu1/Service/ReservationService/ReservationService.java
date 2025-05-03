package com.project.koshpendimenu1.Service.ReservationService;

import com.project.koshpendimenu1.Model.Reservation;
import com.project.koshpendimenu1.Repository.ReservationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ReservationService implements IReservationService {

    private final ReservationRepository reservationRepository;

    @Override
    public Reservation addReservation(Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    // Update an existing reservation
    @Override
    public Reservation updateReservation(Long id, Reservation updatedReservation) {
        if (reservationRepository.existsById(id)) {
            updatedReservation.setId(id); // Make sure the ID is set
            return reservationRepository.save(updatedReservation);
        }
        return null; // or throw an exception if the reservation does not exist
    }

    // Delete a reservation by ID
    @Override
    public void deleteReservation(Long id) {
        if (reservationRepository.existsById(id)) {
            reservationRepository.deleteById(id);
        }
    }

    // Fetch a reservation by ID
    @Override
    public Optional<Reservation> getReservationById(Long id) {
        return reservationRepository.findById(id);
    }

    // Fetch all reservations
    @Override
    public Iterable<Reservation> getAllReservations() {
        return reservationRepository.findAll();
    }
}
