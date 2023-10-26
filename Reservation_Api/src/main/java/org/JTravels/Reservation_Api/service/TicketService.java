package org.JTravels.Reservation_Api.service;

import java.util.List;
import java.util.Optional;

import org.JTravels.Reservation_Api.Dto.Bus;
import org.JTravels.Reservation_Api.Dto.EmailConfiguration;
import org.JTravels.Reservation_Api.Dto.ResponseStructure;
import org.JTravels.Reservation_Api.Dto.Slots;
import org.JTravels.Reservation_Api.Dto.Ticket;
import org.JTravels.Reservation_Api.Dto.User;
import org.JTravels.Reservation_Api.Exception.IdNotFoundException;
import org.JTravels.Reservation_Api.dao.BusDao;
import org.JTravels.Reservation_Api.dao.TicketDao;
import org.JTravels.Reservation_Api.dao.UserDao;
import org.aspectj.weaver.patterns.ConcreteCflowPointcut.Slot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class TicketService {
	@Autowired
	private TicketDao dao;
	@Autowired
	private UserDao udao;
	@Autowired
	private BusDao bdao;
	@Autowired
	private EmailService service;
	@Autowired
	private EmailConfiguration config;
	public ResponseEntity<ResponseStructure<Ticket>> BookTicket(int user_id,int bus_id,Ticket t){
		ResponseStructure<Ticket> res=new ResponseStructure<>();
		Optional<User> opu=udao.findbyid(user_id);
		Optional<Bus> opb=bdao.findbyID(bus_id);
		if(opu.isPresent() && opb.isPresent()) {
			User u=opu.get();
			Bus b=opb.get();
			u.getTickets().add(t);
			b.getTickets().add(t);
			t.setBus(b);
			t.setUser(u);
			List<Slots> ls=t.getSlots();
			
			for(Slots s : ls) {
				s.setTicket(t);
				
			}
			udao.Update(u);
			bdao.update(b);
			dao.bookticket(t);
			
			
			//email content
			String seatnumber="";
			String price="";
			for(Slots s: ls) {
				seatnumber+=s.getSeat_no()+"  ";
				price+=String.valueOf(s.getSeat_cost())+"  ";
			}
			config.setTo(u.getEmail());
			config.setSubject("Booking Confirmation");
			config.setText("Ticket no : "+t.getTicket_no()+"\n"
			+"Booking time : "+t.getTime_of_booking()+"\n"
			+"Seat no : " + seatnumber +"\n"
			+"Price of seats : "+ price+"\n"
			+"Total amount paid : "+t.getAmnt_paid()+"\n" 
			+"Depature place & Time : "+t.getBoarding()+" & "+t.getDeptime()+"\n"
			+"Dropping place & Time : "+t.getDroping()+" & "+t.getDestime()+"\n"
			+"Bus Number : "+ b.getBusnum());
			service.sendemail(config);
			
			
			//structure creation
			res.setData(t);
			res.setHttpstatus(HttpStatus.CREATED.value());
			res.setMessage("ticket booked");
			return new ResponseEntity<ResponseStructure<Ticket>>(res,HttpStatus.CREATED);
		}
		throw new IdNotFoundException();
	}
     public ResponseEntity<ResponseStructure<String>> cancel(int id){
    	 ResponseStructure<String> res=new ResponseStructure<>();
    	 Optional<Ticket> op=dao.findbyid(id);
    	 if(op.isPresent()) {
    		 String email=op.get().getUser().getEmail();
    		 config.setTo(email);
    		 config.setSubject("Ticket Cancelation confirmation");
    		 config.setText("Your Ticket number : "+op.get().getTicket_no()+" has been canceled."+"\n"
    		 		+ " Refund of your ticket amount "+op.get().getAmnt_paid()+" will be initialed to your registered bank account within 5-6 working days");
    		 service.sendemail(config);
    		 dao.cancel(id);
    		 res.setData("Ticket has been canceled");
    		 res.setMessage("Mail sended");
    		 res.setHttpstatus(HttpStatus.OK.value());
    		 return new ResponseEntity<ResponseStructure<String>>(res,HttpStatus.OK);
    	 }
    	 throw new IdNotFoundException();
     }
     public ResponseEntity<ResponseStructure<Ticket>> findbyid(int id){
    	 ResponseStructure<Ticket> res=new ResponseStructure<>();
    	 Optional<Ticket> op=dao.findbyid(id);
    	 if(op.isPresent()) {
    		 res.setData(op.get());
    		 res.setMessage("Ticket found");
    		 res.setHttpstatus(HttpStatus.OK.value());
    		 return new ResponseEntity<ResponseStructure<Ticket>>(res,HttpStatus.OK);
    	 }
    	 throw new IdNotFoundException();
     }
     
}
