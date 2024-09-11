package ir.freeland.springboot.relation.onetoone.practice4;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import jakarta.persistence.EntityManager;

public class JpaItemRun {
    private EntityManager entityManager;

    public void itemRun() {
        entityManager = entityManager.getEntityManagerFactory().createEntityManager();
        Session session = entityManager.unwrap(Session.class);
        Transaction transaction = session.getTransaction();

        // Save new Item 1
        transaction.begin();
        Item item = new Item();
        item.setName("item1");
        item.setCategory("category1");
        item.setPrice(152.25);
        session.persist(item);
        transaction.commit();

        // Save new Item 2
        transaction.begin();
        Item item2 = new Item();
        item2.setName("item2");
        item2.setCategory("category1");
        item2.setPrice(28.325);
        session.persist(item2);
        transaction.commit();

        // Save new Item 3
        transaction.begin();
        Item item3 = new Item();
        item3.setName("item3");
        item3.setCategory("category2");
        item3.setPrice(145.00);
        session.persist(item3);
        transaction.commit();

        // Find and print all Items
        transaction.begin();
        List<Item> allItems = session.createQuery("from Item", Item.class).getResultList();
        allItems.forEach(i -> System.out.println(i.getName() + ": " + i.getCategory() + " - $" + i.getPrice()));
        transaction.commit();

        // Update an Item
        transaction.begin();
        allItems.get(1).setName("itemUpdated");
        session.merge(allItems.get(1));
        transaction.commit();

        // Delete an Item
        transaction.begin();
        session.remove(allItems.get(0));
        transaction.commit();
    }
}
