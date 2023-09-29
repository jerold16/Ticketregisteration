package org.JTravels.Reservation_Api.service;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

import org.JTravels.Reservation_Api.Dto.Admin;
import org.JTravels.Reservation_Api.Dto.Bus;
import org.JTravels.Reservation_Api.Dto.ResponseStructure;
import org.JTravels.Reservation_Api.Exception.IdNotFoundException;
import org.JTravels.Reservation_Api.dao.AdminDao;
import org.JTravels.Reservation_Api.dao.BusDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class BusService {
	@Autowired
	private BusDao dao;
	@Autowired
	private AdminDao adao;
	public ResponseEntity<ResponseStructure<Bus>> save(Bus bus,int id){
		ResponseStructure<Bus> res=new ResponseStructure<>();
		Optional<Admin> op=adao.findbyid(id);
	    if(op.isPresent()) {
	    	Admin ad=op.get();
	    	ad.getBuses().add(bus);
	    	bus.setAdmin(ad);
	    	adao.Update(ad);
	    	dao.save(bus);
	    	res.setData(bus);
	    	res.setMessage("bus has been saved");
	    	res.setHttpstatus(HttpStatus.CREATED.value());
	    	return new ResponseEntity<ResponseStructure<Bus>>(res,HttpStatus.CREATED);
	    }
	    throw new IdNotFoundException();
	}
	public ResponseEntity<ResponseStructure<Bus>> Update(Bus bus,int id){
		ResponseStructure<Bus> res=new ResponseStructure<>();
		Optional<Admin> op=adao.findbyid(id);
	    if(op.isPresent()) {
	    	Admin ad=op.get();
	    	bus.setAdmin(ad);
	    	dao.update(bus);
	    	res.setData(bus);
	    	res.setMessage("bus has been Updated");
	    	res.setHttpstatus(HttpStatus.ACCEPTED.value());
	    	return new ResponseEntity<ResponseStructure<Bus>>(res,HttpStatus.ACCEPTED);
	    }
	    throw new IdNotFoundException();
	}
	public ResponseEntity<ResponseStructure<Bus>> changeroutes(int id,String from,String to){
		Optional<Bus> op=dao.findbyID(id);
		ResponseStructure<Bus> res=new ResponseStructure<>();
		if(op.isPresent()) {
			Bus b=op.get();
			b.setFrom(from);
			b.setTo(to);
			dao.update(b);
			res.setData(b);
			res.setMessage("Route has been changed");
			res.setHttpstatus(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<Bus>>(res,HttpStatus.OK);
		}
		throw new IdNotFoundException();
	}
	public ResponseEntity<ResponseStructure<List<Bus>>> FindbyRoutes(String from,String to){
		ResponseStructure<List<Bus>> res=new ResponseStructure<>();
		List<Bus> op=dao.FindByroutes(from, to);
		if(op!=null) {
			res.setData(op);
			res.setMessage("All the buses are fetched");
			res.setHttpstatus(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<List<Bus>>>(res,HttpStatus.OK);
		}
		throw new IdNotFoundException();
	}
	public ResponseEntity<ResponseStructure<Bus>> changetiming(int id,LocalTime departure,LocalTime destination){
		Optional<Bus> op=dao.findbyID(id);
		ResponseStructure<Bus> res=new ResponseStructure<>();
		if(op.isPresent()) {
			Bus b=op.get();
			b.setDeptime(departure);
			b.setDestime(destination);
			dao.update(b);
			res.setData(b);
			res.setMessage("Route timing has been changed");
			res.setHttpstatus(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<Bus>>(res,HttpStatus.OK);
		}
		throw new IdNotFoundException();
	}
	public ResponseEntity<ResponseStructure<Bus>> findbyid(int id){
		Optional<Bus> op=dao.findbyID(id);
		ResponseStructure<Bus> res=new ResponseStructure<>();
		if(op.isPresent()) {
			Bus b=op.get();
			res.setData(b);
			res.setMessage("bus has been found");
			res.setHttpstatus(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<Bus>>(res,HttpStatus.OK);
		}
		throw new IdNotFoundException();
	}
}
