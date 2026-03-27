package com.skills.app;

import java.util.Scanner;
import com.skills.entity.Book;
import com.skills.service.*;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        BookService service = new BookServiceImpl();

        while (true) {
            try {
                System.out.println("\n====== BOOK MENU ======");
                System.out.println("1. Add Book");
                System.out.println("2. Delete Book");
                System.out.println("3. Search Book");
                System.out.println("4. Display All Books");
                System.out.println("5. Count Books");
                System.out.println("6. Exit");
                System.out.print("Enter choice: ");

                int ch = sc.nextInt();

                switch (ch) {
                    case 1:
                        System.out.print("Enter ID: ");
                        int id = sc.nextInt();

                        System.out.print("Enter Name: ");
                        String name = sc.next();

                        service.add(new Book(id, name));
                        break;

                    case 2:
                        System.out.print("Enter ID to delete: ");
                        service.delete(sc.nextInt());
                        break;

                    case 3:
                        System.out.print("Enter ID to search: ");
                        Book b = service.search(sc.nextInt());
                        if (b != null)
                            System.out.println(b);
                        else
                            System.out.println("Book Not Found");
                        break;

                    case 4:
                        System.out.println("\n--- Book List ---");
                        service.display();
                        break;

                    case 5:
                        System.out.println("Total Books: " + service.count());
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