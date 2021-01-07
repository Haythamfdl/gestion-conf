package com.sid.gestionconf.Repos;

import com.sid.gestionconf.Model.Reservation;
import com.sid.gestionconf.Model.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public interface ReservationRepo extends JpaRepository<Reservation, Long> {
    public List<Reservation> findAllByClientAndDeleted(Utilisateur utilisateur, boolean d);
}
