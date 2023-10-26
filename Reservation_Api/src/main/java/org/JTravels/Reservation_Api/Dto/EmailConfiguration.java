package org.JTravels.Reservation_Api.Dto;

import org.springframework.stereotype.Controller;

import lombok.Data;

@Controller
@Data
public class EmailConfiguration {
	private String to,subject,text;

}
