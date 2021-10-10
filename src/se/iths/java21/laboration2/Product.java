package se.iths.java21.laboration2;

import java.util.Objects;

public class Product {
    private String itemNumber;
    private String name;
    private String brand;
    private String category;
    private float price;
    private int balance;

    public Product(String itemNumber, String name, String brand, String category, float price, int balance) {
        this.itemNumber = itemNumber;
        this.name = name;
        this.brand = brand;
        this.category = category;
        this.price = price;
        this.balance = balance;
    }

    public String getItemNumber() {
        return itemNumber;
    }

    public void setItemNumber(String itemNumber) {
        this.itemNumber = itemNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Float.compare(product.getPrice(), getPrice()) == 0 && getBalance() == product.getBalance() && Objects.equals(getItemNumber(), product.getItemNumber()) && Objects.equals(getName(), product.getName()) && Objects.equals(getBrand(), product.getBrand()) && Objects.equals(getCategory(), product.getCategory());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getItemNumber(), getName(), getBrand(), getCategory(), getPrice(), getBalance());
    }

    @Override
    public String toString() {
        return
                "ARTNR: " + itemNumber + ", " +
                        "PRODUKT:" + name + ", " +
                        "VARUMÄRKE:" + brand + " " +
                        "KATEGORI:" + category + ", " +
                        "PRIS:" + price + ", " +
                        "LAGERSALDO: " + balance + "St";
    }
}
