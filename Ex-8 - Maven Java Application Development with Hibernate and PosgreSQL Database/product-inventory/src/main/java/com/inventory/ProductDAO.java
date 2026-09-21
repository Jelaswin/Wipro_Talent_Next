package com.inventory;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class ProductDAO {

    private SessionFactory sessionFactory;

    public ProductDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    // ADD PRODUCT
    public void addProduct(Product product) {

        Transaction transaction = null;

        try (Session session = sessionFactory.openSession()) {

            transaction = session.beginTransaction();

            session.persist(product);

            transaction.commit();

            System.out.println("Product added successfully!");

        } catch (Exception e) {

            if (transaction != null) {
                transaction.rollback();
            }

            e.printStackTrace();
        }
    }


    // VIEW PRODUCTS
    public void viewProducts() {

        try (Session session = sessionFactory.openSession()) {

            List<Product> products =
                    session.createQuery(
                            "FROM Product",
                            Product.class
                    ).getResultList();

            if (products.isEmpty()) {

                System.out.println("No products found.");

            } else {

                System.out.println("\n========== PRODUCT INVENTORY ==========");

                for (Product product : products) {
                    System.out.println(product);
                }

                System.out.println("=======================================");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    // UPDATE PRODUCT
    public void updateProduct(Product product) {

        Transaction transaction = null;

        try (Session session = sessionFactory.openSession()) {

            transaction = session.beginTransaction();

            Product existingProduct =
                    session.get(Product.class, product.getId());

            if (existingProduct != null) {

                existingProduct.setName(product.getName());
                existingProduct.setCategory(product.getCategory());
                existingProduct.setPrice(product.getPrice());
                existingProduct.setQuantity(product.getQuantity());

                transaction.commit();

                System.out.println("Product updated successfully!");

            } else {

                System.out.println("Product not found.");

                transaction.rollback();
            }

        } catch (Exception e) {

            if (transaction != null) {
                transaction.rollback();
            }

            e.printStackTrace();
        }
    }


    // DELETE PRODUCT
    public void deleteProduct(int id) {

        Transaction transaction = null;

        try (Session session = sessionFactory.openSession()) {

            transaction = session.beginTransaction();

            Product product =
                    session.get(Product.class, id);

            if (product != null) {

                session.remove(product);

                transaction.commit();

                System.out.println("Product deleted successfully!");

            } else {

                System.out.println("Product not found.");

                transaction.rollback();
            }

        } catch (Exception e) {

            if (transaction != null) {
                transaction.rollback();
            }

            e.printStackTrace();
        }
    }
}