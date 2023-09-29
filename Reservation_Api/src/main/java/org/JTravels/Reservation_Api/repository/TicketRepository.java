package org.JTravels.Reservation_Api.repository;

import org.JTravels.Reservation_Api.Dto.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<Ticket, Integer> {
    
}
