package com.sid.gestionconf.Repos;

import com.sid.gestionconf.Model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface ReservationRepo extends JpaRepository<Reservation, Long> {
}
