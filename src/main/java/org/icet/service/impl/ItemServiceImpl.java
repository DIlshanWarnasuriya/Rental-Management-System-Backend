package org.icet.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.icet.dto.Item;
import org.icet.entity.ItemEntity;
import org.icet.repository.ItemRepository;
import org.icet.service.ItemService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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

    @Override
    public List<Item> getAllItem() {
        List<Item> list = new ArrayList<>();
        for (ItemEntity entity : repository.findAll()) {
            list.add(mapper.convertValue(entity, Item.class));
        }
        return list;
    }
}
