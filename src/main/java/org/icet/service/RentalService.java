package org.icet.service;

import org.icet.dto.Rental;

import java.util.List;

public interface RentalService {
    Rental addRental(Rental rental);

    List<Rental> getAllRental();
}
