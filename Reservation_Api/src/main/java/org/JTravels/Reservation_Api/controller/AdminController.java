package org.JTravels.Reservation_Api.controller;

import org.JTravels.Reservation_Api.Dto.Admin;
import org.JTravels.Reservation_Api.Dto.ResponseStructure;
import org.JTravels.Reservation_Api.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class AdminController {
	@Autowired
	private AdminService ser;

	@PostMapping(value = "/admin")
	public ResponseEntity<ResponseStructure<Admin>> save(@RequestBody Admin ad) {
		return ser.save(ad);
	}

	@PutMapping(value = "/admin")
	public ResponseEntity<ResponseStructure<Admin>> Upadte(@RequestBody Admin ad) {
		return ser.Update(ad);
	}

	@GetMapping(value = "/admin/verifyphone")
	public ResponseEntity<ResponseStructure<Admin>> verifyadmin(@RequestParam long phone,
			@RequestParam String password) {
		return ser.verifyAdmin(phone, password);
	}

	@GetMapping(value = "/admin/verifyemail")
	public ResponseEntity<ResponseStructure<Admin>> verifyadmin(@RequestParam String email,
			@RequestParam String password) {
		return ser.verifyAdmin(email, password);
	}

}
