package groupId.artifactId.core.dto;

public class ProductCreationDto {
    private String name;
    private int price;
    private int discount;
    private String description;

    public ProductCreationDto() {
    }

    public ProductCreationDto (String name, int price, int discount, String description) {
        this.name = name;
        this.price = price;
        this.discount = discount;
        this.description = description;
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

}
