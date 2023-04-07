package com.example.softwaremethodologyproject04;

import java.text.DecimalFormat;
import java.util.ArrayList;
public class Order {
    private static int count;
    private int orderNumber;
    private double subtotal = 0.0;
    private double total = 0.0;
    private ArrayList<MenuItem> itemsList = new ArrayList<>();
    private static final DecimalFormat df = new DecimalFormat("0.00");
    private static final double SALES_TAX = .0625;
    private static final double HUNDRED = 100.0; //used for rounding to two decimal places


    /**
     * Empty constructor.
     */
    public Order() {
        this.orderNumber = ++Order.count;
    }

    /**
     * Getter method, gets the total price without sales tax.
     * @return subtotal, the price of items without tax.
     */
    public double getSubTotal() {
        return this.subtotal;
    }

    /**
     * Setter method, sets the price of an order without sales tax.
     * @param subtotal, the price of the items without tax that is to be set.
     */
    public void setSubTotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public String toString(Object obj) {
        /*
        if (obj instanceof Coffee) {
            MenuItem coffee = (MenuItem) obj;
            return coffee.displayInfo();
        }
        else if (obj instanceof YeastDonut) {
            MenuItem yeastDonut = (MenuItem) obj;
            return yeastDonut.displayInfo();
        }
        else if (obj instanceof CakeDonut) {
            MenuItem cakeDonut = (MenuItem) obj;
            return cakeDonut.displayInfo();
        }
        else {
            MenuItem donutHole = (MenuItem) obj;
            return donutHole.displayInfo();
        }

         */
        return "blablabla";
    }

    /**
     * Calculates the total of all menu items with tax included.
     * @return total, the total amount for all menu items with tax included.
     */
    public double getTotal() {
        this.total = subtotal + (subtotal * SALES_TAX);
        this.total = Math.round(total * HUNDRED) / HUNDRED;
        return this.total;
    }

    /**
     * Adds a menu item to the list.
     * @param item, the item to be added to the list.
     */
    public void add(MenuItem item) {
        itemsList.add(item);
    }

    /**
     * Removes a menu item from the list.
     * @param item, the item to be removed from the list.
     * @return false if the orderNumber is less than 0 and true otherwise.
     */
    public boolean remove(MenuItem item) {

        if(orderNumber < 0) {
            return false;
        }
        itemsList.remove(item);
        orderNumber--;
        return true;
    }

    /**
     * Places an order from the basket into a list of total orders.
     * @return orders, the list of all placed orders.
     */
    public ArrayList<String> totalOrders() {
        ArrayList<String> orders = new ArrayList<>();
        for(int i = 0; i < itemsList.size(); i++) {
            orders.add(toString(itemsList.get(i)));
        }
        return orders;
    }

    public static void main(String[] args){
        Order order1 = new Order();
        System.out.println(order1.orderNumber);
        Order order2 = new Order();
        System.out.println(order2.orderNumber);
    }

}
