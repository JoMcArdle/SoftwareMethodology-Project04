package com.example.softwaremethodologyproject04;

import java.text.DecimalFormat;
public class YeastDonut extends MenuItem{

    private String flavor;
    private int quantity;
    private static final double YEAST_PRICE = 1.59;
    private static final DecimalFormat df = new DecimalFormat("0.00");

    /**
     * Empty constructor.
     */
    public YeastDonut() {

    }

    /**
     * Parameterized constructor, creates a YeastDonut object with the specified parameters.
     * @param price, the price of a YeastDonut.
     * @param flavor, the flavor of a YeastDonut.
     */
    public YeastDonut(double price, String flavor, int quantity) {

        super(price);
        this.flavor = flavor;
        this.quantity = quantity;
    }

    /**
     * Getter method, gets the flavor of a YeastDonut.
     * @return flavor, the flavor of the donut.
     */
    public String getFlavor() {

        return this.flavor;
    }

    /**
     * Setter method, sets the flavor of a YeastDonut.
     * @param flavor, the flavor of the donut to be set.
     */
    public void setFlavor(String flavor) {

        this.flavor = flavor;
    }

    /**
     * Getter method, gets the amount of YeastDonuts.
     * @return quantity, the amount of donuts.
     */
    public int getQuantity() {

        return this.quantity;
    }

    /**
     * Setter method, sets the quantity of YeastDonuts.
     * @param quantity, the amount of donuts to be set.
     */
    public void setQuantity(int quantity) {

        this.quantity = quantity;
    }


    /**
     * Calculates the price of a YeastDonut, without sales tax included.
     * @return price, the price for the donuts.
     */
    @Override
    public double itemPrice() {
        double price = YEAST_PRICE;
        super.setPrice(price * this.quantity);
        return price;
    }

    /**
     * Displays the relevant information for a YeastDonut.
     * @return flavor, the flavor of a YeastDonut and quantity, the number of YeastDonuts.
     */
    @Override
    public String displayInfo() {

        return this.flavor + " " + "Yeast Donut" + " " + this.quantity;
    }

    /**
     * Returns a string containing the amount for a YeastDonut.
     * @return the amount for a YeastDonut.
     */
    @Override
    public String toString() {
        return this.flavor + " (" + this.quantity + ")";

    }
}