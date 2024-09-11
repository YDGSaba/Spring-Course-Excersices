package ir.freeland.springboot.relation.onetoone.practice4;


import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import jakarta.persistence.EntityManager;

public class JpaCorruptedItemRun {
    private EntityManager entityManager;

    public void corruptedItemRun() {
        entityManager = entityManager.getEntityManagerFactory().createEntityManager();
        Session session = entityManager.unwrap(Session.class);
        Transaction transaction = session.getTransaction();

        // Find Items by category2
        transaction.begin();
        List<Item> category2Items = session.createQuery("from Item i where i.category like '%category2%'", Item.class)
                                           .getResultList();
        category2Items.forEach(i -> System.out.println("Item: " + i.getName() + " in " + i.getCategory()));
        transaction.commit();

        // Save a CorruptedItem
        if (!category2Items.isEmpty()) {
            transaction.begin();
            CorruptedItem corruptedItem = new CorruptedItem();
            corruptedItem.setItem(category2Items.get(0));
            corruptedItem.setReason("Expired");
            session.persist(corruptedItem);
            transaction.commit();
        }

        // Find all CorruptedItems
        transaction.begin();
        List<CorruptedItem> allCorruptedItems = session.createQuery("from CorruptedItem", CorruptedItem.class)
                                                       .getResultList();
        allCorruptedItems.forEach(c -> {
            System.out.println("Corrupted Item: " + c.getItem().getName() + " Reason: " + c.getReason());
        });
        transaction.commit();

        // Update a CorruptedItem's reason
        if (!allCorruptedItems.isEmpty()) {
            transaction.begin();
            allCorruptedItems.get(0).setReason("Bad Product");
            session.merge(allCorruptedItems.get(0));
            transaction.commit();
        }

        // Delete a CorruptedItem
        if (!allCorruptedItems.isEmpty()) {
            transaction.begin();
            session.remove(allCorruptedItems.get(0));
            transaction.commit();
        }
    }
}
