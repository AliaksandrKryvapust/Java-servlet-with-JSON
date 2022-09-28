package groupId.artifactId.core.dto;

public class ProductCreationDto {
    private String name;
    private Integer price;
    private Integer discount;
    private String description;

    public ProductCreationDto() {
    }

    public ProductCreationDto(String name, Integer price, Integer discount, String description) {
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
