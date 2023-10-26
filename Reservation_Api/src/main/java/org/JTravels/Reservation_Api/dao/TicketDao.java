package org.JTravels.Reservation_Api.dao;

import java.util.Optional;

import org.JTravels.Reservation_Api.Dto.Ticket;
import org.JTravels.Reservation_Api.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class TicketDao {
	@Autowired
	private TicketRepository rep;
	public Ticket bookticket(Ticket t) {
		return rep.save(t);
	}
	public Ticket update(Ticket t) {
		return rep.save(t);
	}
	public void cancel(int id) {
		rep.deleteById(id);
	}
	public Optional<Ticket> findbyid(int id) {
		return rep.findById(id);
	}

}
