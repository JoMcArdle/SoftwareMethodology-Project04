package com.example.softwaremethodologyproject04;
import java.text.DecimalFormat;

public class CakeDonut extends MenuItem{


    private String flavor;
    private int quantity;
    private static final double CAKE_PRICE = 1.79;
    private static final DecimalFormat df = new DecimalFormat("0.00");

    /**
     * Empty constructor.
     */
    public CakeDonut() {

    }

    /**
     * Parameterized constructor, creates a CakeDonut object with the specified parameters.
     * @param price, the price of a CakeDonut.
     * @param flavor, the flavor of a CakeDonut.
     */
    public CakeDonut(double price, String flavor, int quantity) {

        super(price);
        this.flavor = flavor;
        this.quantity = quantity;
    }

    /**
     * Getter method, gets the flavor of a CakeDonut.
     * @return flavor, the flavor of the donut.
     */
    public String getFlavor() {

        return this.flavor;
    }

    /**
     * Setter method, sets the flavor of a CakeDonut.
     * @param flavor, the flavor of the donut to be set.
     */
    public void setFlavor(String flavor) {

        this.flavor = flavor;
    }

    /**
     * Getter method, gets the amount of CakeDonuts.
     * @return quantity, the amount of donuts.
     */
    public int getQuantity() {

        return this.quantity;
    }

    /**
     * Setter method, sets the quantity of CakeDonuts.
     * @param quantity, the amount of donuts to be set.
     */
    public void setQuantity(int quantity) {

        this.quantity = quantity;
    }

    /**
     * Calculates the price of a CakeDonut, without sales tax included.
     * @return price, the price for the donuts.
     */
    @Override
    public double itemPrice() {
        double price = CAKE_PRICE;
        super.setPrice(price * this.quantity);
        return price;
    }

    /**
     * Displays the relevant information for a CakeDonut.
     * @return flavor, the flavor of a CakeDonut and quantity, the number of CakeDonuts.
     */
    @Override
    public String displayInfo() {

        return this.flavor + " " + "Cake Donut" + " " + this.quantity;
    }

    /**
     * Returns a string containing the amount for a CakeDonut.
     * @return the amount for a CakeDonut.
     */
    @Override
    public String toString() {

        return this.flavor + " " + this.quantity;
    }
    public  double getCakePrice(){
        return this.CAKE_PRICE;
    }

}
