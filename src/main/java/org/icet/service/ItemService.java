package org.icet.service;

import org.icet.dto.Item;

import java.util.List;

public interface ItemService {
    Item addItem(Item item);

    List<Item> getAllItem();

    Item updateItem(Item item);
}
