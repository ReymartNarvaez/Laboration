package se.iths.java21.laboration2;

import se.iths.java21.laboration2.Product;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SearchProduct {

    public static void sortedProducts(List<Product> list) {
        list.stream()
                .sorted(Comparator.comparing(Product::getName))
                .collect(Collectors.toList())
                .forEach(System.out::println);
    }

    public static void findProduct(List<Product> list, String input) {
        list.stream()
                .filter(product -> product.getName().contains(input))
                .forEach(System.out::println);
        list.stream()
                .filter(product -> product.getItemNumber().contains(input))
                .forEach(System.out::println);
        list.stream()
                .filter(product -> product.getBrand().contains(input))
                .forEach(System.out::println);
        list.stream()
                .filter(product -> product.getCategory().contains(input))
                .forEach(System.out::println);
    }

    public static void findPrice(List<Product> list, float lowestPrice, float highestPrice) {
        list.stream()
                .filter(product -> product.getPrice() > lowestPrice && product.getPrice() < highestPrice)
                .sorted(Comparator.comparing(Product::getPrice))
                .forEach(System.out::println);
    }
}
