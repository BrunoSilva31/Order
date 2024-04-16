package entities;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import entities_num.OrderStatus;

public class Order {

    private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

    private Date moment;
    private OrderStatus status;

    private Client client;

    private List<OrderItem> items = new ArrayList<>();


    public Order(Date moment, OrderStatus status, Client client) {
        this.moment = moment;
        this.status = status;
        this.client = client;
    }


    public Date getMoment() {
        return moment;
    }
    public void setMoment(Date moment) {
        this.moment = moment;
    }

    public OrderStatus getStatus() {
        return status;
    }
    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public Client getClient() {
        return client;
    }
    public void setClient(Client client) {
        this.client = client;
    }


    public void addItem(OrderItem item){
        items.add(item);
    }
    public void removeItem(OrderItem item){
        items.remove(item);
    }


    public Double total(){
        double sum = 0;
        for (OrderItem orderItem : items) {
            sum += orderItem.subTotal();
        }
        return sum;
    }


    @Override
    public String toString() {
        return "Order moment: " +
        sdf.format(moment) + " \n" +
        "Order status: " + status + "\n" +
        "Client: " + client + "\n" +
        "Order items: " + items + "\n" + 
        "Total price: R$" + String.format("%.2f", total());
    }

    
}
