package org.JTravels.Reservation_Api.repository;

import org.JTravels.Reservation_Api.Dto.Slots;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Slotrepository extends JpaRepository<Slots, Integer> {

}
