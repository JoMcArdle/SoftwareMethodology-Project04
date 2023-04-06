package com.example.softwaremethodologyproject04;
import java.text.DecimalFormat;

public class DonutHole extends MenuItem{


    private String flavor;
    private int quantity;
    private static final double DONUT_HOLE_PRICE = .39;
    private static final DecimalFormat df = new DecimalFormat("0.00");

    /**
     * Empty constructor.
     */
    public DonutHole() {

    }

    /**
     * Parameterized constructor, creates a DonutHole object with the specified parameters.
     * @param price, the price of a DonutHole.
     * @param flavor, the flavor of a DonutHole.
     */
    public DonutHole(double price, String flavor, int quantity) {

        super(price);
        this.flavor = flavor;
        this.quantity = quantity;
    }

    /**
     * Getter method, gets the flavor of a DonutHole.
     * @return flavor, the flavor of the donut.
     */
    public String getFlavor() {

        return this.flavor;
    }

    /**
     * Setter method, sets the flavor of a DonutHole.
     * @param flavor, the flavor of the donut to be set.
     */
    public void setFlavor(String flavor) {

        this.flavor = flavor;
    }

    /**
     * Getter method, gets the amount of DonutHoles.
     * @return quantity, the amount of donuts.
     */
    public int getQuantity() {

        return this.quantity;
    }

    /**
     * Setter method, sets the quantity of DonutHoles.
     * @param quantity, the amount of donuts to be set.
     */
    public void setQuantity(int quantity) {

        this.quantity = quantity;
    }

    /**
     * Calculates the price of a DonutHole, without sales tax included.
     * @return price, the price for the donuts.
     */
    @Override
    public double itemPrice() {
        double price = DONUT_HOLE_PRICE;
        super.setPrice(price * this.quantity);
        return price;
    }

    /**
     * Displays the relevant information for a DonutHole.
     * @return flavor, the flavor of a DonutHole and quantity, the number of DonutHoles.
     */
    @Override
    public String displayInfo() {

        return this.flavor + " " + "Donut Hole" + " " + this.quantity;
    }

    /**
     * Returns a string containing the amount for a DonutHole.
     * @return the amount for a DonutHole.
     */
    @Override
    public String toString() {
        return this.flavor + " " + this.quantity ;
    }
    public double getDonutHolePrice(){
        return this.DONUT_HOLE_PRICE;
    }
}