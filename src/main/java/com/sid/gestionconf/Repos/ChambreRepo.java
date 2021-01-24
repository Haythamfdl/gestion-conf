package com.sid.gestionconf.Repos;

import com.sid.gestionconf.Model.Chambre;
import com.sid.gestionconf.Model.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public interface ChambreRepo extends JpaRepository<Chambre, Long> {
    public List<Chambre> findAllByDisponibleAndHotelAndDeleted(boolean d, Hotel hotel,boolean dl);
    public List<Chambre> findAllByHotelAndDeleted(Hotel hotel,boolean dl);
}
