package se.iths.java21.narvaez.laboration2;



import java.util.Comparator;
import java.util.List;
import static se.iths.java21.narvaez.laboration2.CsvReader.products;

public class ProductService {

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

    public static void findPrice(double lowestPrice, double highestPrice) {
        products.stream()
                .filter(product -> product.getPrice() > lowestPrice && product.getPrice() < highestPrice)
                .sorted(Comparator.comparing(Product::getPrice))
                .forEach(System.out::println);
    }

    public static void deleteProduct(String itemNumber) {
        products.stream()
                .filter(product -> product.getItemNumber().equals(itemNumber))
                .findFirst()
                .ifPresent(products::remove);
    }
    protected static void addProduct(Product product) {
        if (products.contains(product))
            return; products.add(product);
    }

    protected static List<Product> getProducts() {
        return List.copyOf(products);
    }

}
