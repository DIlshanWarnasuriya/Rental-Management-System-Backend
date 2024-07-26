package org.icet.controller;

import lombok.RequiredArgsConstructor;
import org.icet.dto.Item;
import org.icet.service.CustomerService;
import org.icet.service.ItemService;
import org.springframework.web.bind.annotation.*;

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
}
