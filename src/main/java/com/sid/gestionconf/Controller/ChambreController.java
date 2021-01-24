package com.sid.gestionconf.Controller;

import com.sid.gestionconf.Model.Chambre;
import com.sid.gestionconf.Model.Hotel;
import com.sid.gestionconf.Model.SalleConference;
import com.sid.gestionconf.Repos.ChambreRepo;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/chambres/{id}")
    public List<Chambre> getAllChambrehot(@PathVariable(name = "id") Long id){
        Hotel hotel = new Hotel();
        hotel.setId(id);
        return chambreRepo.findAllByHotelAndDeleted(hotel,false);
    }

    @GetMapping("/chambres/disponible/{id}")
    public List<Chambre> getChambredis(@PathVariable(name = "id") Long id){
        Hotel hotel = new Hotel();
        hotel.setId(id);
        return chambreRepo.findAllByDisponibleAndHotelAndDeleted(true, hotel,false);
    }

    @RequestMapping(value = "/chambres",method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Chambre> addChambre(@RequestBody Chambre chambre)
    {
        Chambre c = chambreRepo.save(chambre);
        ResponseEntity<Chambre> res=new ResponseEntity<>(c, HttpStatus.ACCEPTED);
        return res;
    }

    @RequestMapping(value = "/chambres",method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Chambre> updateChambre(@RequestBody Chambre chambre)
    {
        Chambre c = chambreRepo.save(chambre);
        ResponseEntity<Chambre> res=new ResponseEntity<>(c, HttpStatus.ACCEPTED);
        return res;
    }
}
