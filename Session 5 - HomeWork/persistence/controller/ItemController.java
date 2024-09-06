package ir.freeland.springboot.persistence.controller;


import ir.freeland.springboot.persistence.model.CorruptedItem;
import ir.freeland.springboot.persistence.model.Item;
import ir.freeland.springboot.persistence.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/items")
public class ItemController {

    @Autowired
    private ItemService itemService;

    @PostMapping
    public Item createItem(@RequestBody Item item) {
        return itemService.createItem(item);
    }

    @GetMapping("/{id}")
    public Optional<Item> getItemById(@PathVariable Long id) {
        return itemService.getItemById(id);
    }

    @PutMapping("/{id}")
    public Item updateItem(@PathVariable Long id, @RequestBody Item itemDetails) {
        return itemService.updateItem(id, itemDetails);
    }

    @DeleteMapping("/{id}")
    public void deleteItem(@PathVariable Long id) {
        itemService.deleteItem(id);
    }

    @PostMapping("/{id}/corrupted")
    public CorruptedItem markItemAsCorrupted(@PathVariable Long id, @RequestBody String reason) {
        return itemService.markItemAsCorrupted(id, reason);
    }
}
