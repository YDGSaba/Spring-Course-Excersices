package ir.freeland.springboot.relation.onetoone.jointable;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Component;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Component
public class JointableRun1 {

    @PersistenceContext
    private EntityManager entityManager;

    public void saveItemAndCorruptedItem() {
        entityManager = entityManager.getEntityManagerFactory().createEntityManager();
        Session session = entityManager.unwrap(Session.class);
        Transaction transaction = session.getTransaction();

        try {
            transaction.begin();

            // Creating and saving an Item and CorruptedItem
            Item item = new Item();
            item.setName("Phone");
            item.setPrice(600.0);
            item.setCategory("Electronics");

            CorruptedItem corruptedItem = new CorruptedItem();
            corruptedItem.setItem(item);
            corruptedItem.setReason("Broken Screen");

            item.setCorruptedItem(corruptedItem);

            // Persisting the item (CorruptedItem is cascaded and saved automatically)
            session.persist(item);

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public Item findItem(Long id) {
        entityManager = entityManager.getEntityManagerFactory().createEntityManager();
        Session session = entityManager.unwrap(Session.class);
        Item item = null;

        try {
            item = session.find(Item.class, id);
        } finally {
            session.close();
        }

        return item;
    }

    public void updateItem(Long id, String newName, String newCategory) {
        entityManager = entityManager.getEntityManagerFactory().createEntityManager();
        Session session = entityManager.unwrap(Session.class);
        Transaction transaction = session.getTransaction();

        try {
            transaction.begin();

            Item item = session.find(Item.class, id);
            if (item != null) {
                item.setName(newName);
                item.setCategory(newCategory);
                session.update(item);
            }

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public void deleteItem(Long id) {
        entityManager = entityManager.getEntityManagerFactory().createEntityManager();
        Session session = entityManager.unwrap(Session.class);
        Transaction transaction = session.getTransaction();

        try {
            transaction.begin();

            Item item = session.find(Item.class, id);
            if (item != null) {
                session.remove(item);
            }

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
}
