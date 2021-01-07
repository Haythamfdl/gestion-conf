package com.sid.gestionconf.Controller;

import com.sid.gestionconf.Model.Chambre;
import com.sid.gestionconf.Model.Hotel;
import com.sid.gestionconf.Model.SalleConference;
import com.sid.gestionconf.Repos.ChambreRepo;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class ChambreController {
    private ChambreRepo chambreRepo;

    public ChambreController(ChambreRepo chambreRepo) {
        this.chambreRepo = chambreRepo;
    }

    @GetMapping("/chambres")
    public List<Chambre> getChambres(){
        return chambreRepo.findAll();
    }

    @GetMapping("/chambres/disponible/{id}")
    public List<Chambre> getChambredis(@PathVariable(name = "id") Long id){
        Hotel hotel = new Hotel();
        hotel.setId(id);
        return chambreRepo.findAllByDisponibleAndHotel(true, hotel);
    }
}
