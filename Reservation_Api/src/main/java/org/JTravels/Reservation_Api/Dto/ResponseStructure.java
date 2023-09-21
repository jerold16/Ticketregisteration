package org.JTravels.Reservation_Api.Dto;

import lombok.Data;

@Data
public class ResponseStructure<T> {
	private T data;
	private String message;
	private int httpstatus;

}
