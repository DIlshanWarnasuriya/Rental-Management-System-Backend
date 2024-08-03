package org.icet.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.icet.dto.Item;
import org.icet.entity.ItemEntity;
import org.icet.repository.ItemRepository;
import org.icet.service.ItemService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

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

    @Override
    public Item updateItem(Item item) {
        ItemEntity entity = repository.save(mapper.convertValue(item, ItemEntity.class));
        return mapper.convertValue(entity, Item.class);
    }

    @Override
    public Map<String, String> deleteItem(Integer id) {
        repository.deleteById(id);
        return Collections.singletonMap("response", "Deleted");
    }

    @Override
    public Item SearchItem(String data) {
        for (ItemEntity entity : repository.findAll()) {
            if (Integer.toString(entity.getId()).equals(data) || entity.getName().equals(data)){
                return mapper.convertValue(entity, Item.class);
            }
        }
        return null;
    }

    @Override
    public List<Item> getAvailableItem() {
        List<Item> list = new ArrayList<>();
        for (ItemEntity entity : repository.findAll()) {
            if (entity.getAvailable()){
                list.add(mapper.convertValue(entity, Item.class));
            }
        }
        return list;
    }
}
