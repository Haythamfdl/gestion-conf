package com.sid.gestionconf.Controller;

import com.sid.gestionconf.Model.Hotel;
import com.sid.gestionconf.Repos.HotelRepo;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class HotelController {
    private HotelRepo hotelRepo;

    public HotelController(HotelRepo hotelRepo) {
        this.hotelRepo = hotelRepo;
    }

    @GetMapping("/hotels")
    public List<Hotel> getHotels(){
        return hotelRepo.findAll();
    }

    @GetMapping("/hotels/{id}")
    public Hotel getHotel(@PathVariable(name = "id") Long id){
        return hotelRepo.findById(id).get();
    }
}
