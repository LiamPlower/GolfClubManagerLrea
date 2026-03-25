package ie.atu.golfclubmanagerlrea.service;


import ie.atu.golfclubmanagerlrea.exceptions.EquipmentConflictException;
import ie.atu.golfclubmanagerlrea.model.Reservation;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ReservationService {

    private final List<Reservation> reservations = new ArrayList<>();
    private long nextId = 1;

    public Reservation addReservation(Reservation res) {
        int newStart = res.getStartHour();
        int newEnd = newStart + res.getDurationHours();

        for (Reservation existing : reservations) {
            if (existing.getEquipmentName().equalsIgnoreCase(res.getEquipmentName()) &&
                    existing.getReservationDate().equals(res.getReservationDate())) {

                int existingStart = existing.getStartHour();
                int existingEnd = existingStart + existing.getDurationHours();

                if (existingStart < newEnd && newStart < existingEnd) {
                    throw new EquipmentConflictException("Time slot already booked");
                }
            }
        }
        res.setReservationId(nextId++);
        reservations.add(res);
        return res;
    }

    public List<Reservation> getAll() {
        return reservations;
    }
}