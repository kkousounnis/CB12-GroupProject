package com.company.springboot.entities.dto;

import java.math.BigDecimal;

public class ProductDto {

    private String name;
    private BigDecimal price;
    private String description;
    private String category;    

    public ProductDto() {
    }

    public ProductDto(String name, BigDecimal price, String description, String category) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ProductDto{name=").append(name);
        sb.append(", price=").append(price);
        sb.append(", description=").append(description);
        sb.append(", category=").append(category);
        sb.append('}');
        return sb.toString();
    }

}
