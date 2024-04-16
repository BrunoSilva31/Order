package app;

import java.util.Date;
import java.util.Locale;
import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.text.ParseException;

import entities_num.OrderStatus;
import entities.OrderItem;
import entities.Product;
import entities.Client;
import entities.Order;

public class Program{
    public static void main(String[] args) throws ParseException {
        Scanner sc = new Scanner(System.in);
        Locale.setDefault(Locale.US);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        System.out.println("Enter cliente data: ");
        
        System.out.print("Name: ");
        String name = sc.nextLine();

        System.out.print("Email: ");
        String email = sc.nextLine();

        System.out.print("Birth date: ");
        Date birthDate = sdf.parse(sc.next());

        Client client = new Client(name, email, birthDate);

        System.out.println("Enter order data: ");

        System.out.print("Status: ");
        OrderStatus status = OrderStatus.valueOf(sc.next());


        System.out.println("How many items to this order? ");
        int quantity = sc.nextInt();

        Order order = new Order(new Date(), status, client);


        for(int i = 0; i < quantity; i++){
            System.out.println("Enter #" + (i + 1) + " item data: ");

            System.out.println("Product name: ");
            sc.nextLine();
            String itemName = sc.nextLine();

            System.out.println("Product price: ");
            Double itemPrice = sc.nextDouble();

            System.out.println("Quantity: ");
            int itemQuantity = sc.nextInt();

            Product product = new Product(itemName, itemPrice);

            OrderItem orderItem = new OrderItem(itemQuantity, itemPrice, product);

            order.addItem(orderItem);
        }

        System.out.println();
        System.out.println(order);

        sc.close();
    }
}