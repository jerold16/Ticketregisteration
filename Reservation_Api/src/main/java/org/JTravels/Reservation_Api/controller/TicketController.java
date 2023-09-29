package org.JTravels.Reservation_Api.controller;

import org.JTravels.Reservation_Api.Dto.ResponseStructure;
import org.JTravels.Reservation_Api.Dto.Ticket;
import org.JTravels.Reservation_Api.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class TicketController {
  @Autowired
  private TicketService ser;
  @PostMapping("/ticket/{user_id}/{bus_id}")
  public ResponseEntity<ResponseStructure<Ticket>> save(@PathVariable int user_id,@PathVariable int bus_id,@RequestBody Ticket t){
	  return ser.BookTicket(user_id, bus_id, t);
  }
  @DeleteMapping("/ticket/{id}")
  public ResponseEntity<ResponseStructure<String>> cancel(@PathVariable int id){
	  return ser.cancel(id);
  }
}
