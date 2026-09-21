package com.inventory;

import java.util.Scanner;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class MainProgram {

    public static void main(String[] args) {

        // Create Hibernate SessionFactory
        SessionFactory sessionFactory =
                new Configuration()
                        .configure("hibernate.cfg.xml")
                        .buildSessionFactory();

        ProductDAO dao = new ProductDAO(sessionFactory);

        Scanner scanner = new Scanner(System.in);

        int choice;

        do {

            System.out.println("\n=================================");
            System.out.println("     PRODUCT INVENTORY SYSTEM");
            System.out.println("=================================");
            System.out.println("1. Add Product");
            System.out.println("2. View Products");
            System.out.println("3. Update Product");
            System.out.println("4. Delete Product");
            System.out.println("5. Exit");
            System.out.println("=================================");

            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {

                case 1:

                    System.out.print("Enter Product ID: ");
                    int id = scanner.nextInt();

                    scanner.nextLine();

                    System.out.print("Enter Product Name: ");
                    String name = scanner.nextLine();

                    System.out.print("Enter Category: ");
                    String category = scanner.nextLine();

                    System.out.print("Enter Price: ");
                    double price = scanner.nextDouble();

                    System.out.print("Enter Quantity: ");
                    int quantity = scanner.nextInt();

                    Product product =
                            new Product(id, name, category, price, quantity);

                    dao.addProduct(product);

                    break;

                case 2:

                    dao.viewProducts();

                    break;

                case 3:

                    System.out.print("Enter Product ID to update: ");
                    int updateId = scanner.nextInt();

                    scanner.nextLine();

                    System.out.print("Enter New Product Name: ");
                    String updateName = scanner.nextLine();

                    System.out.print("Enter New Category: ");
                    String updateCategory = scanner.nextLine();

                    System.out.print("Enter New Price: ");
                    double updatePrice = scanner.nextDouble();

                    System.out.print("Enter New Quantity: ");
                    int updateQuantity = scanner.nextInt();

                    Product updatedProduct =
                            new Product(
                                    updateId,
                                    updateName,
                                    updateCategory,
                                    updatePrice,
                                    updateQuantity
                            );

                    dao.updateProduct(updatedProduct);

                    break;

                case 4:

                    System.out.print("Enter Product ID to delete: ");
                    int deleteId = scanner.nextInt();

                    dao.deleteProduct(deleteId);

                    break;

                case 5:

                    System.out.println("Exiting application...");

                    break;

                default:

                    System.out.println("Invalid choice!");

            }

        } while (choice != 5);

        scanner.close();

        sessionFactory.close();

        System.out.println("Application closed.");
    }
}