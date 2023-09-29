package org.JTravels.Reservation_Api.Dto;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Ticket {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(nullable = false)
	private String ticket_no;
	@Column(name = "depature_time")
	private LocalTime deptime;
	@Column(name = "destination_time")
	private LocalTime destime;
	@Column(nullable = false)
	private double amnt_paid;
	@CreationTimestamp
	private LocalDateTime time_of_booking;
	@Column(nullable = false)
	private int number_of_seats;
	@ManyToOne
	@JoinColumn
	@JsonIgnore
	private User user;
	@ManyToOne
	@JoinColumn
	@JsonIgnore
	private Bus bus;
	@OneToMany(mappedBy = "ticket",cascade = CascadeType.ALL)
	private List<Slots> slots;
}
