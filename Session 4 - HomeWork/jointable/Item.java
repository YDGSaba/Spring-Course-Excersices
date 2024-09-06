package ir.freeland.springboot.relation.onetoone.jointable;

import jakarta.persistence.*;

@Entity
@Table(name = "item")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private Double price;

    @Column(name = "category")
    private String category;

    @OneToOne(mappedBy = "item", cascade = CascadeType.ALL)
    private CorruptedItem corruptedItem;

    // Getters and setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public CorruptedItem getCorruptedItem() {
        return corruptedItem;
    }

    public void setCorruptedItem(CorruptedItem corruptedItem) {
        this.corruptedItem = corruptedItem;
    }
}
