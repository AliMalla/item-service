package com.example.itemservice.services;

import com.example.itemservice.dto.ItemDto;
import com.example.itemservice.dto.ItemUpdateDto;
import com.example.itemservice.entities.Item;
import com.example.itemservice.repos.ItemRepository;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Service
public class ItemService {

    private final ItemRepository itemRepository;

    public ItemService(ItemRepository itemRepository){
        this.itemRepository = itemRepository;
    }

    public List<ItemDto> getItems() {
        return itemRepository.findAll().stream()
                .map(item -> new ItemDto(
                        item.getName(),
                        item.getQuantity(),
                        item.getUnity()
                ))
                .toList();
    }

    // Create new item
    public ItemDto createItem(ItemDto dto) {
        if (itemRepository.existsByNameIgnoreCase(dto.getName())){
            throw new DataIntegrityViolationException("Item with name '" + dto.getName() + "' already exists");
        }

        Item item = new Item();
        item.setName(dto.getName());
        item.setQuantity(dto.getQuantity());
        item.setUnity(dto.getUnity());

        Item saved = itemRepository.save(item);

        return new ItemDto(saved.getName(), saved.getQuantity(), saved.getUnity());
    }

    // Delete item
    public String deleteItem(String name) {
        return itemRepository.findByNameIgnoreCase(name)
                .map(item -> {
                    itemRepository.delete(item);
                    return "item deleted with name " + name;
                })
                .orElseThrow(() -> new RuntimeException("item not found with name " + name));
    }


    // Update item quantity
    public ItemDto updateItemQuantity(String name, ItemUpdateDto dto) {
        return itemRepository.findByNameIgnoreCase(name)
                .map(item -> {
                    item.setQuantity(dto.getQuantity());
                    Item updated = itemRepository.save(item);
                    return new ItemDto(updated.getName(), updated.getQuantity(), updated.getUnity());
                })
                .orElseThrow(() -> new RuntimeException("Item not found with name " + name));
    }
}
