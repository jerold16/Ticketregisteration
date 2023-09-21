package org.JTravels.Reservation_Api.Exception;

public class InvalidCredentialsException extends RuntimeException {
	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return "Check the email or phone or password";
	}

}
