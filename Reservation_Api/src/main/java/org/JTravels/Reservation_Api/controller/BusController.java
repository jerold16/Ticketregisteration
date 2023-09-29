package org.JTravels.Reservation_Api.controller;

import java.time.LocalTime;
import java.util.List;

import org.JTravels.Reservation_Api.Dto.Bus;
import org.JTravels.Reservation_Api.Dto.ResponseStructure;
import org.JTravels.Reservation_Api.service.BusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class BusController {
	@Autowired
	private BusService service;
	@PostMapping("/bus/{id}")
	public ResponseEntity<ResponseStructure<Bus>> save(@PathVariable int id,@RequestBody Bus bus){
		return service.save(bus, id);
	}
	@PutMapping("/bus/{id}")
	public ResponseEntity<ResponseStructure<Bus>> update(@PathVariable int id,@RequestBody Bus bus){
		return service.Update(bus, id);
	}
	@GetMapping("/bus/{id}")
	public ResponseEntity<ResponseStructure<Bus>> find(@PathVariable int id){
		return service.findbyid(id);
	}
	@PutMapping("/bus/route/{id}")
	public ResponseEntity<ResponseStructure<Bus>> changeroute(@PathVariable int id,@RequestParam String from, @RequestParam String to){	
		    return service.changeroutes(id, from, to);	
    }
	@GetMapping("/bus/route")
	public ResponseEntity<ResponseStructure<List<Bus>>> fetchByroutes (@RequestParam String from, @RequestParam String to){
		return service.FindbyRoutes(from, to);
	}
	@PutMapping("/bus/timing/{id}")
	public ResponseEntity<ResponseStructure<Bus>> changetiming(@PathVariable int id,@RequestParam LocalTime departure,@RequestParam LocalTime destination){
		return service.changetiming(id, departure, destination);
	}
	
}
