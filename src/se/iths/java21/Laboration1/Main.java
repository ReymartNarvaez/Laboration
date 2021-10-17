package se.iths.java21.narvaez.laboration2;

import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;
import static se.iths.java21.narvaez.laboration2.CsvReader.products;

public class Main {
    Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Main main = new Main();
        main.runMenu();
    }

    private void runMenu() {
        CsvReader.csvProductList();
        String choice;
        do {
            printMenu();
            choice = scanner.nextLine();
        } while (menuChoice(choice));
        CsvReader.saveFile();
    }


    private void printMenu() {
        System.out.println("Välkomen!");
        System.out.println("1.PRODUKTER");
        System.out.println("2.SÖK");
        System.out.println("3.SÖK PRISINTERVALL");
        System.out.println("4.LÄGG TILL NY PRODUKT");
        System.out.println("5.TA BORT PRODUKT");
        System.out.println("e.Avsluta");
        System.out.print("Ange ditt val: ");
    }

    private boolean menuChoice(String choice) {
        boolean continueApplication = true;
        switch (choice) {
            case "1" -> ProductService.getProducts().forEach(System.out::println);
            case "2" -> search();
            case "3" -> searchPrice();
            case "4" -> addNewProduct();
            case "5" -> removeProduct();
            case "e", "E" -> continueApplication = false;
            default -> System.out.println("Input ej giltig");
        }
        return continueApplication;
    }

    private void search() {
        String input;
        System.out.print("SÖK: ");
        input = scanner.nextLine().toUpperCase(Locale.ROOT);
        ProductService.findProduct(products, input);
    }

    private void searchPrice() {
        double lowestPrice;
        double highestPrice;

        System.out.print("PRIS FRÅN:");
        lowestPrice = scanner.nextDouble();
        System.out.print("PRIS UPPTILL:");
        highestPrice = scanner.nextDouble();
        ProductService.findPrice(lowestPrice, highestPrice);
    }

    private void addNewProduct() {
        try {
            String itemNumber, name, brand, category;
            double price;
            int balance;
            System.out.print("ARTNR: ");
            itemNumber = scanner.nextLine().toUpperCase(Locale.ROOT);
            System.out.print("PRODUKT: ");
            name = scanner.nextLine().toUpperCase(Locale.ROOT);
            System.out.print("VARUMÄRKE: ");
            brand = scanner.nextLine().toUpperCase(Locale.ROOT);
            System.out.print("KATEGORI: ");
            category = scanner.nextLine().toUpperCase(Locale.ROOT);
            System.out.print("PRIS: ");
            price = scanner.nextDouble();
            System.out.print("LAGERSALDO:");
            balance = scanner.nextInt();
            Product product = new Product(itemNumber, name, brand, category, price, balance);
            ProductService.addProduct(product);
        } catch (InputMismatchException e) {
            System.out.println("PRODUKTEN GICK EJ ATT SKAPA");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void removeProduct() {
        ProductService.getProducts().forEach(System.out::println);
        System.out.println("ANGE ARTNR FÖR ATT TA BORT PRODUKT: : ");
        String input = scanner.nextLine().toUpperCase();
        ProductService.deleteProduct(input);
    }

}