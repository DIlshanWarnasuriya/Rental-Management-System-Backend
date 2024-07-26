package org.icet.service;

import org.icet.dto.Item;

import java.util.List;
import java.util.Map;

public interface ItemService {
    Item addItem(Item item);

    List<Item> getAllItem();

    Item updateItem(Item item);

    Map<String, String> deleteItem(Integer id);
}
