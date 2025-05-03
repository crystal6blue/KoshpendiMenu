package com.project.koshpendimenu1.Controller;

import com.project.koshpendimenu1.Model.Reservation;
import com.project.koshpendimenu1.Service.ReservationService.IReservationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/reservations")  // Base URL for reservation-related endpoints
public class ReservationController {

    private final IReservationService reservationService;

    public ReservationController(IReservationService reservationService) {
        this.reservationService = reservationService;
    }

    // Add a new reservation
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Reservation addReservation(@RequestBody Reservation reservation) {
        return reservationService.addReservation(reservation);
    }

    // Get a reservation by ID
    @GetMapping("/{id}")
    public Optional<Reservation> getReservationById(@PathVariable Long id) {
        return reservationService.getReservationById(id);
    }

    // Get all reservations
    @GetMapping
    public Iterable<Reservation> getAllReservations() {
        return reservationService.getAllReservations();
    }

    // Update an existing reservation
    @PutMapping("/{id}")
    public Reservation updateReservation(@PathVariable Long id, @RequestBody Reservation updatedReservation) {
        return reservationService.updateReservation(id, updatedReservation);
    }

    // Delete a reservation by ID
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteReservation(@PathVariable Long id) {
        reservationService.deleteReservation(id);
    }
}
