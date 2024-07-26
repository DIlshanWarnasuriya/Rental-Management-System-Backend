package org.icet.service;

import org.icet.dto.Rental;

import java.util.List;
import java.util.Map;

public interface RentalService {
    Rental addRental(Rental rental);

    List<Rental> getAllRental();

    Rental updateRental(Rental rental);

    Map<String, String> deleteRental(Integer id);
}
