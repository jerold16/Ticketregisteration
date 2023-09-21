package org.JTravels.Reservation_Api.repository;

import java.util.Optional;

import org.JTravels.Reservation_Api.Dto.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AdminRepository extends JpaRepository<Admin, Integer>{
    @Query("select a from Admin a where a.phone=?1 and a.password=?2")
	public Optional<Admin> verifyAdmin(long phone, String password);
    @Query("select a from Admin a where a.email=?1 and a.password=?2")
	public Optional<Admin> verifyAdmin(String email, String password);
    
}
