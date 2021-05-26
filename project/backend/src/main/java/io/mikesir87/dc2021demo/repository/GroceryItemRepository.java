package io.mikesir87.dc2021demo.repository;

import io.mikesir87.dc2021demo.domain.Item;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface GroceryItemRepository extends MongoRepository<Item, String> {
}
