package org.icet.controller;

import lombok.RequiredArgsConstructor;
import org.icet.dto.Rental;
import org.icet.service.RentalService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

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

    @DeleteMapping("/{id}")
    Map<String, String> deleteRental(@PathVariable Integer id){
        return service.deleteRental(id);
    }

    @GetMapping("/{id}")
    Rental searchById(@PathVariable Integer id){
        return service.searchById(id);
    }
}
