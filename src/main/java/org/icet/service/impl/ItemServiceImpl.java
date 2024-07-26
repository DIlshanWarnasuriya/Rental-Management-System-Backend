package org.icet.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.icet.dto.Item;
import org.icet.entity.ItemEntity;
import org.icet.repository.ItemRepository;
import org.icet.service.ItemService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ItemServiceImpl implements ItemService {

    private final ItemRepository repository;
    private final ObjectMapper mapper;

    @Override
    public Item addItem(Item item) {
        ItemEntity entity = repository.save(mapper.convertValue(item, ItemEntity.class));
        return mapper.convertValue(entity, Item.class);
    }
}
