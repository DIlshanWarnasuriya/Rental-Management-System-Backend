package org.icet.controller;

import lombok.RequiredArgsConstructor;
import org.icet.dto.Item;
import org.icet.service.CustomerService;
import org.icet.service.ItemService;
import org.springframework.web.bind.annotation.*;

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
        return service.getAllItem();
    }

    @PatchMapping
    Item updateItem(@RequestBody Item item){
        return service.updateItem(item);
    }

    @DeleteMapping("/{id}")
    Map<String, String> deleteItem(@PathVariable Integer id){
        return service.deleteItem(id);
    }
}
