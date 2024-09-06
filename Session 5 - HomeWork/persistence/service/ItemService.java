package ir.freeland.springboot.persistence.service;

import ir.freeland.springboot.persistence.model.CorruptedItem;
import ir.freeland.springboot.persistence.model.Item;
import ir.freeland.springboot.persistence.repo.CorruptedItemRepository;
import ir.freeland.springboot.persistence.repo.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ItemService {

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private CorruptedItemRepository corruptedItemRepository;

    public Item createItem(Item item) {
        return itemRepository.save(item);
    }

    public Optional<Item> getItemById(Long id) {
        return itemRepository.findById(id);
    }

    public Item updateItem(Long id, Item itemDetails) {
        Item item = itemRepository.findById(id).orElseThrow(() -> new RuntimeException("Item not found"));

        item.setName(itemDetails.getName());
        item.setPrice(itemDetails.getPrice());
        item.setCategory(itemDetails.getCategory());

        return itemRepository.save(item);
    }

    public void deleteItem(Long id) {
        itemRepository.deleteById(id);
    }

    public CorruptedItem markItemAsCorrupted(Long itemId, String reason) {
        Item item = itemRepository.findById(itemId).orElseThrow(() -> new RuntimeException("Item not found"));

        CorruptedItem corruptedItem = new CorruptedItem();
        corruptedItem.setItem(item);
        corruptedItem.setReason(reason);

        item.setCorruptedItem(corruptedItem);

        return corruptedItemRepository.save(corruptedItem);
    }
}
