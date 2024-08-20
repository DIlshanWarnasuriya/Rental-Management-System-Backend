package org.icet.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.icet.dto.Item;
import org.icet.dto.Rental;
import org.icet.entity.ItemEntity;
import org.icet.entity.RentalEntity;
import org.icet.repository.ItemRepository;
import org.icet.repository.RentalRepository;
import org.icet.service.RentalService;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.TimeUnit;

@Service
@RequiredArgsConstructor
public class RentalServiceImpl implements RentalService {

    private final RentalRepository repository;
    private final ItemRepository itemRepository;
    private final ObjectMapper mapper;

    @Override
    public Rental addRental(Rental rental) {
        RentalEntity entity = repository.save(mapper.convertValue(rental, RentalEntity.class));
        Rental rental1 = mapper.convertValue(entity, Rental.class);

        ItemEntity itemEntity = mapper.convertValue(itemRepository.findById(entity.getItemId()), ItemEntity.class);
        itemEntity.setAvailable(false);
        itemRepository.save(itemEntity);

        return rental1;
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

        if (rental.getReturnDate() != null){
            ItemEntity itemEntity = mapper.convertValue(itemRepository.findById(rental.getItemId()), ItemEntity.class);
            itemEntity.setAvailable(true);
            itemRepository.save(itemEntity);
        }
        RentalEntity entity = repository.save(mapper.convertValue(rental, RentalEntity.class));
        return mapper.convertValue(entity, Rental.class);
    }

    @Override
    public Map<String, String> deleteRental(Integer id) {
        RentalEntity rentalEntity = mapper.convertValue(repository.findById(id), RentalEntity.class);

        if(rentalEntity.getReturnDate() == null){
            Integer itemId = rentalEntity.getItemId();
            repository.deleteById(id);

            ItemEntity entity = mapper.convertValue(itemRepository.findById(itemId), ItemEntity.class);
            entity.setAvailable(true);
            itemRepository.save(entity);
        }
        else {
            repository.deleteById(id);
        }
        return Collections.singletonMap("response", "Deleted");
    }

    @Override
    public Rental searchById(Integer id) {
        Optional<RentalEntity> entity = repository.findById(id);
        return mapper.convertValue(entity, Rental.class);
    }

    @Override
    public Rental returnRental(Integer id) {

        double total = 0.0;
        double fine = 0.0;
        int dueDates = 0;

        RentalEntity rental = mapper.convertValue(searchById(id), RentalEntity.class);
        ItemEntity item = itemRepository.findById(rental.getItemId()).get();
        Date today = new Date();


        long numberOfDays = calculateDifferenceDays(rental.getRentalDate().getTime() ,today.getTime());
        total += numberOfDays * item.getRentalPerDay();
        if (numberOfDays == 0){
            total = item.getRentalPerDay();
        }
        else{
            total += numberOfDays * item.getRentalPerDay();
        }


        long differenceInDays = calculateDifferenceDays(rental.getExpectedDate().getTime(), today.getTime());
        if (differenceInDays > 0){
            dueDates = (int) differenceInDays;
            fine = item.getFinePerDay() * differenceInDays;
            total+= fine;
        }

        rental.setReturnDate(today);
        rental.setDueDate(dueDates);
        rental.setFine(fine);
        rental.setTotalCost(total);

        item.setAvailable(true);
        itemRepository.save(item);

        return mapper.convertValue(repository.save(rental), Rental.class);
    }

    private long calculateDifferenceDays(long before , long after){
        long differenceInMillis = after - before;
        return TimeUnit.MILLISECONDS.toDays(differenceInMillis);
    }


}
