package com.example.itemservice.repos;

import com.example.itemservice.entities.Item;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ItemRepository extends JpaRepository<Item, Long> {
    boolean existsByNameIgnoreCase(String name);
    Optional<Item> findByNameIgnoreCase(String name);
}
