package se.iths.java21.narvaez.laboration2;

import java.util.Objects;

public class Product {
    private String itemNumber;
    private String name;
    private String brand;
    private String category;
    private double price;
    private int balance;

    public Product(String itemNumber, String name, String brand, String category, double price, int balance) {
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

    public String getName() {
        return name;
    }

    public String getBrand() {
        return brand;
    }

    public String getCategory() {
        return category;
    }

    public double getPrice() {
        return price;
    }

    public int getBalance() {
        return balance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Double.compare(product.price, price) == 0 && balance == product.balance && Objects.equals(itemNumber, product.itemNumber) && Objects.equals(name, product.name) && Objects.equals(brand, product.brand) && Objects.equals(category, product.category);
    }

    @Override
    public int hashCode() {
        return Objects.hash(itemNumber, name, brand, category, price, balance);
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
