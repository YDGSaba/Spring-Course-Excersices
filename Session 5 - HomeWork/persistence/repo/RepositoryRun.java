package ir.freeland.springboot.persistence.repo;

import java.util.Set;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ir.freeland.springboot.persistence.model.Students;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;


import ir.freeland.springboot.persistence.model.CorruptedItem;
import ir.freeland.springboot.persistence.model.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class RepositoryRun {

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private CorruptedItemRepository corruptedItemRepository;

    public void sampleRun() {
        // Create and save new items
        Item item1 = new Item();
        item1.setName("Item1");
        item1.setPrice(10.0);
        item1.setCategory("Category1");
        itemRepository.save(item1);

        Item item2 = new Item();
        item2.setName("Item2");
        item2.setPrice(20.0);
        item2.setCategory("Category2");
        itemRepository.save(item2);

        // Retrieve and print all items
        List<Item> allItems = itemRepository.findAll();
        System.out.println("All items: " + allItems);

        // Retrieve item by ID
        Optional<Item> itemById = itemRepository.findById(item1.getId());
        System.out.println("Item by ID: " + itemById);

        // Update an item
        itemById.ifPresent(item -> {
            item.setPrice(15.0);
            itemRepository.save(item);
            System.out.println("Updated item: " + itemRepository.findById(item.getId()));
        });

        // Delete an item
        itemRepository.deleteById(item2.getId());
        System.out.println("All items after deletion: " + itemRepository.findAll());

        // Create and save a corrupted item
        CorruptedItem corruptedItem = new CorruptedItem();
        corruptedItem.setItem(item1);
        corruptedItem.setReason("Damaged");
        corruptedItemRepository.save(corruptedItem);

        // Retrieve and print all corrupted items
        List<CorruptedItem> allCorruptedItems = corruptedItemRepository.findAll();
        System.out.println("All corrupted items: " + allCorruptedItems);

        // Retrieve corrupted item by ID
        Optional<CorruptedItem> corruptedItemById = corruptedItemRepository.findById(corruptedItem.getId());
        System.out.println("Corrupted item by ID: " + corruptedItemById);

        // Delete a corrupted item
        corruptedItemRepository.deleteById(corruptedItem.getId());
        System.out.println("All corrupted items after deletion: " + corruptedItemRepository.findAll());
    }
}
