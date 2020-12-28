package com.sid.gestionconf.Repos;

import com.sid.gestionconf.Model.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface HotelRepo extends JpaRepository<Hotel, Long> {
}
