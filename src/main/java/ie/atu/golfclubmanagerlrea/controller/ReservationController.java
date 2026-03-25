package ie.atu.golfclubmanagerlrea.controller;

import ie.atu.golfclubmanagerlrea.model.Reservation;
import ie.atu.golfclubmanagerlrea.service.ReservationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reservations")
public class ReservationController {

    private final ReservationService service;

    public ReservationController(ReservationService service) { this.service = service; }

    @PostMapping
    public Reservation create(@RequestBody Reservation res) { return service.addReservation(res); }

    @GetMapping
    public List<Reservation> getAll() { return service.getAll(); }
}