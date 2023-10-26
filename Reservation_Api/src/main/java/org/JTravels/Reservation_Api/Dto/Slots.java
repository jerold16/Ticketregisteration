package org.JTravels.Reservation_Api.Dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Slots {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
    private String seat_no;
    private double seat_cost;
    @ManyToOne
    @JoinColumn
    @JsonIgnore
    private Ticket ticket;
    @Override
	public String toString() {
		return "Slots [id=" + id + ", seat_no=" + seat_no + ", seat_cost=" + seat_cost + "]";
	}
}
