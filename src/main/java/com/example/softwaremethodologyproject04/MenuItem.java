package com.example.softwaremethodologyproject04;

public abstract class MenuItem {


    private double price;

    /**
     * Empty constructor.
     */
    public MenuItem() {

    }

    /**
     * Parameterized constructor, constructs a MenuItem object with a specified price.
     * @param price, the price of the menu item to be set.
     */
    public MenuItem(double price) {

        this.price = price;
    }

    /**
     * Setter method, sets the price of a menu item.
     * @param price, the price of the menu item to be set.
     */
    public void setPrice(double price) {

        this.price = price;
    }

    /**
     * Getter method, gets the price of a menu item.
     * @return price of the menu item.
     */
    public double getPrice() {

        return this.price;
    }

    /**
     * Abstract method to calculate the price of menu items without sales tax included.
     * @return
     */
    public abstract double itemPrice(); //subclasses must implement this method

    /**
     * Displays the relevant information for a given menu item.
     * @return
     */
    public abstract String displayInfo();

}
