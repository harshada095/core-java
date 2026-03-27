package com.skills.app;

import java.util.Scanner;
import com.skills.entity.Product;
import com.skills.service.*;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ProductService service = new ProductServiceImpl();

        while (true) {
            try {
                System.out.println("\n====== PRODUCT MENU ======");
                System.out.println("1. Add Product");
                System.out.println("2. Update Product");
                System.out.println("3. Delete Product");
                System.out.println("4. Search Product");
                System.out.println("5. Display All Products");
                System.out.println("6. Exit");
                System.out.print("Enter choice: ");

                int ch = sc.nextInt();

                switch (ch) {
                    case 1:
                        service.add(new Product(sc.nextInt(), sc.next()));
                        break;

                    case 2:
                        service.update(new Product(sc.nextInt(), sc.next()));
                        break;

                    case 3:
                        service.delete(sc.nextInt());
                        break;

                    case 4:
                        Product p = service.search(sc.nextInt());
                        if (p != null)
                            System.out.println(p);
                        else
                            System.out.println("Product Not Found");
                        break;

                    case 5:
                        System.out.println("\n--- Product List ---");
                        service.display();
                        break;

                    case 6:
                        System.exit(0);
                }

            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
                sc.nextLine();
            }
        }
    }
}