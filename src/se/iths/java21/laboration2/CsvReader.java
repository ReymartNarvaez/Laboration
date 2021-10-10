package se.iths.java21.laboration2;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CsvReader {
    private static Pattern pattern = Pattern.compile(",");
    static Path csvPath = Path.of("resources", "produktfillab2.csv");
    static List<Product> products = List.of();

    public static void csvProductList() {
        try (Stream<String> lines = Files.lines(csvPath)) {
            products = lines.skip(1)
                    .map(CsvReader::createProducts)
                    .collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static Product createProducts(String line) {
        String[] arr = pattern.split(line);

        return new Product(arr[0], arr[1], arr[2], arr[3], Float.parseFloat(arr[4]), Integer.parseInt(arr[5]));
    }

    public static void addProduct(String itemNumber, String name, String brand, String category, String price, String balance) {
        List<String> productList = List.of(itemNumber + ", " + name + ", " + brand + ", " + category + ", " + price + "," + balance);
        if (!Files.exists(csvPath)) {
            try {
                Files.createDirectory(csvPath.getParent());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            Files.write(csvPath, productList, StandardOpenOption.APPEND);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}








