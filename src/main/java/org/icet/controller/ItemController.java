package org.icet.controller;

import lombok.RequiredArgsConstructor;
import org.icet.dto.Item;
import org.icet.service.ItemService;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/item")
@CrossOrigin
@RequiredArgsConstructor
public class ItemController {

    private final ItemService service;

    @PostMapping
    Item addItem(@RequestBody Item item){
        return service.addItem(item);
    }

    @GetMapping
    List<Item> getAllItem(){
        List<Item> allItem = service.getAllItem();
        Collections.reverse(allItem);
        return allItem;
    }

    @PatchMapping
    Item updateItem(@RequestBody Item item){
        return service.updateItem(item);
    }

    @DeleteMapping("/{id}")
    Map<String, String> deleteItem(@PathVariable Integer id){
        return service.deleteItem(id);
    }

    @GetMapping("/{data}")
    Item SearchItem(@PathVariable String data){
        return service.SearchItem(data);
    }

    @GetMapping("/available")
    List<Item> getAvailableItem(){
        List<Item> availableItem = service.getAvailableItem();
        Collections.reverse(availableItem);
        return availableItem;
    }
}
