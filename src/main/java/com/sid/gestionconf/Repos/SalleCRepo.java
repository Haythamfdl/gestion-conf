package com.sid.gestionconf.Repos;

import com.sid.gestionconf.Model.Hotel;
import com.sid.gestionconf.Model.SalleConference;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public interface SalleCRepo extends JpaRepository<SalleConference, Long> {
    public List<SalleConference> findAllByDisponibleAndHotelAndDeleted(boolean d, Hotel hotel,boolean dl);
    public List<SalleConference> findAllByHotelAndDeleted(Hotel hotel, boolean d);
}
