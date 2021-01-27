package com.company.springboot.entities.dto;

import java.math.BigDecimal;

public class ProductImagePathDto {

    private int productId;
    private String name;
    private BigDecimal price;
    private String description;
    private String category;
    private Integer productImageId;
    private String imagePath;
    private String fileName;
    private Integer userId;
    private String firstName;

    public ProductImagePathDto() {
    }

    public ProductImagePathDto(int productId,
            String name, BigDecimal price,
            String description, String category,
            Integer productImageId, String imagePath,
            String fileName, Integer userId, String firstName) {
        this.productId = productId;
        this.name = name;
        this.price = price;
        this.description = description;
        this.category = category;
        this.productImageId = productImageId;
        this.imagePath = imagePath;
        this.fileName = fileName;
        this.userId = userId;
        this.firstName = firstName;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
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

    public Integer getProductImageId() {
        return productImageId;
    }

    public void setProductImageId(Integer productImageId) {
        this.productImageId = productImageId;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
    
    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ProductImagePathDto{productId=").append(productId);
        sb.append(", name=").append(name);
        sb.append(", price=").append(price);
        sb.append(", description=").append(description);
        sb.append(", category=").append(category);
        sb.append(", productImageId=").append(productImageId);
        sb.append(", imagePath=").append(imagePath);
        sb.append(", fileName=").append(fileName);
        sb.append(", userId=").append(userId);
        sb.append(", firstName=").append(firstName);
        sb.append('}');
        return sb.toString();
    }

 

  
    
    

}
