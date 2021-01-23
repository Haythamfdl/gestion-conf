package com.sid.gestionconf.Controller;

import com.sid.gestionconf.Model.Hotel;
import com.sid.gestionconf.Repos.HotelRepo;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
        return hotelRepo.findAllByDeleted(false);
    }

    @GetMapping("/hotels/{id}")
    public Hotel getHotel(@PathVariable(name = "id") Long id){
        return hotelRepo.findById(id).get();
    }

    @RequestMapping(value = "/hotels",method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Hotel> addHotel(@RequestBody Hotel hotel)
    {
        Hotel h = hotelRepo.save(hotel);
        ResponseEntity<Hotel> res=new ResponseEntity<>(h, HttpStatus.ACCEPTED);
        return res;
    }

    @RequestMapping(value = "/hotels",method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Hotel> updateHotel(@RequestBody Hotel hotel)
    {
        Hotel h = hotelRepo.save(hotel);
        ResponseEntity<Hotel> res=new ResponseEntity<>(h, HttpStatus.ACCEPTED);
        return res;
    }
}
