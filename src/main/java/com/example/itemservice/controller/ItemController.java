package com.example.itemservice.controller;

import com.example.itemservice.dto.ItemDto;
import com.example.itemservice.dto.ItemUpdateDto;
import com.example.itemservice.services.ItemService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/items")
class ItemController {

    private final ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    // Get all items
    @GetMapping
    public ResponseEntity<List<ItemDto>> getItems() {
        List<ItemDto> products = itemService.getItems();
        return ResponseEntity.ok(products); // 200 OK
    }


    // Create new item
    @PostMapping
    public ResponseEntity<ItemDto> addItems(@Valid @RequestBody ItemDto dto) {
        ItemDto saved = itemService.createItem(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved); // 201 Created
    }

    // Delete item by name
    @DeleteMapping("/{name}")
    public ResponseEntity<String> deleteItem(@PathVariable String name) {
        return ResponseEntity.ok(itemService.deleteItem(name)); // 200 OK
    }


    // Update item quantity by name
    @PutMapping("/{name}")
    public ResponseEntity<ItemDto> updateProductQuantity(@PathVariable String name,
                                                            @Valid @RequestBody ItemUpdateDto dto) {
        ItemDto updated = itemService.updateItemQuantity(name, dto);
        return ResponseEntity.ok(updated); // 200 OK
    }
}
