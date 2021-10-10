package se.iths.java21.laboration2;

import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    List<Product> productList = CsvReader.products;
    Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        CsvReader.csvProductList();
        Main main = new Main();

        main.runMenu();
    }

    private void runMenu() {
        String choice;

        while (true) {
            System.out.println("Välkomen!");
            System.out.println("1.PRODUKTER");
            System.out.println("2.SÖK");
            System.out.println("3.SÖK PRISINTERVALL");
            System.out.println("4.LÄGG TILL NY PRODUKT");
            System.out.println("e.Avsluta");
            System.out.print("Ange ditt val: ");
            choice = scanner.nextLine();

            switch (choice) {
                case "1" -> SearchProduct.sortedProducts(productList);
                case "2" -> search();
                case "3" -> searchPrice();
                case "4" -> addNewProduct();
                case "e", "E" -> System.exit(0);
            }
        }
    }

    private void search() {
        String input;

        System.out.print("SÖK: ");
        input = scanner.nextLine().toUpperCase(Locale.ROOT);
        SearchProduct.findProduct(productList, input);
    }

    private void searchPrice() {
        float lowestPrice;
        float highestPrice;

        System.out.print("PRIS FRÅN:");
        lowestPrice = scanner.nextFloat();
        System.out.print("PRIS UPPTILL:");
        highestPrice = scanner.nextFloat();
        SearchProduct.findPrice(productList, lowestPrice, highestPrice);
    }

    private void addNewProduct() {
        String itemNumber, name, brand, category, price, balance;

        System.out.print("ARTNR: ");
        itemNumber = scanner.nextLine().toUpperCase(Locale.ROOT);
        System.out.print("PRODUKT: ");
        name = scanner.nextLine().toUpperCase(Locale.ROOT);
        System.out.print("VARUMÄRKE: ");
        brand = scanner.nextLine().toUpperCase(Locale.ROOT);
        System.out.print("KATEGORI: ");
        category = scanner.nextLine().toUpperCase(Locale.ROOT);
        System.out.print("PRIS: ");
        price = scanner.nextLine().toUpperCase(Locale.ROOT);
        System.out.print("LAGERSALDO:");
        balance = scanner.nextLine().toUpperCase(Locale.ROOT);
        CsvReader.addProduct(itemNumber, name, brand, category, price, balance);
    }
}
