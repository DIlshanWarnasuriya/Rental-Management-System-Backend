package org.icet.controller;

import lombok.RequiredArgsConstructor;
import org.icet.dto.Rental;
import org.icet.service.RentalService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rental")
@CrossOrigin
@RequiredArgsConstructor
public class RentalController {

    private final RentalService service;

    @PostMapping
    Rental addRental(@RequestBody Rental rental){
        return service.addRental(rental);
    }

    @GetMapping
    List<Rental> getAllRental(){
        return service.getAllRental();
    }

    @PatchMapping
    Rental updateRental(@RequestBody Rental rental){
        return service.updateRental(rental);
    }

}
