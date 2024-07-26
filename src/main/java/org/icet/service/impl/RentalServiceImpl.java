package org.icet.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.icet.dto.Rental;
import org.icet.entity.RentalEntity;
import org.icet.repository.RentalRepository;
import org.icet.service.RentalService;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

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

    @Override
    public List<Rental> getAllRental() {
        List<Rental> list = new ArrayList<>();
        for (RentalEntity entity : repository.findAll()) {
            list.add(mapper.convertValue(entity, Rental.class));
        }
        return list;
    }

    @Override
    public Rental updateRental(Rental rental) {
        RentalEntity entity = repository.save(mapper.convertValue(rental, RentalEntity.class));
        return mapper.convertValue(entity, Rental.class);
    }
}
