package io.mikesir87.dc2021demo.controllers;

import io.mikesir87.dc2021demo.domain.Item;
import io.mikesir87.dc2021demo.repository.GroceryItemRepository;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("items")
public class ItemController {

    private final GroceryItemRepository repository;

    public ItemController(GroceryItemRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Item> getAllItems() {
        return repository.findAll();
    }

    @PostMapping
    public Item createItem(@RequestBody Item item) {
        item.setCreationDate(new Date());
        return repository.insert(item);
    }

    @GetMapping("/{id}")
    public Item getItem(@PathVariable("id") String id) {
        return repository.findById(id)
                .orElse(null);
    }

    @PutMapping("/{id}")
    public Item updateItem(@PathVariable("id") String id, @RequestBody Item item) {
        item.setId(id);
        return repository.save(item);
    }

    @DeleteMapping("/{id}")
    public boolean deleteItem(@PathVariable("id") String id) {
        repository.deleteById(id);
        return true;
    }

}
