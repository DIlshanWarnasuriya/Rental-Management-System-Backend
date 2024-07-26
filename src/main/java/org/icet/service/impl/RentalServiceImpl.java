package org.icet.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.icet.dto.Rental;
import org.icet.entity.RentalEntity;
import org.icet.repository.RentalRepository;
import org.icet.service.RentalService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RentalServiceImpl implements RentalService {

    private final RentalRepository repository;
    private final ObjectMapper mapper;

    @Override
    public Rental addRental(Rental rental) {
        RentalEntity entity = repository.save(mapper.convertValue(rental, RentalEntity.class));
        return mapper.convertValue(entity, Rental.class);
    }
}
