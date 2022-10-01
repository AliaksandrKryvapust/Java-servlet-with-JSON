package groupId.artifactId.storage.entity;

public class Product {
    private Integer id;
    private String name;
    private int price;
    private int discount;
    private String description;
    Product(){}

    Product(String name, int price, int discount, String description) {
        this.name = name;
        this.price = price;
        this.discount = discount;
        this.description = description;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public int getDiscount() {
        return discount;
    }

    public String getDescription() {
        return description;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", discount=" + discount +
                ", description='" + description + '\'' +
                '}';
    }
}
