package com.example.softwaremethodologyproject04;
import java.text.DecimalFormat;

import java.util.ArrayList;

public class Coffee extends MenuItem{

    private String cupSize;
    private int numAddIns = 0;
    private int quantity;
    private ArrayList<String> addIns = new ArrayList<>();

    private static final double SHORT_SIZE_PRICE = 1.89;
    private static final double TALL_SIZE_PRICE = 2.29;
    private static final double GRANDE_SIZE_PRICE = 2.69;
    private static final double VENTI_SIZE_PRICE = 3.09;
    private static final double ADD_IN_PRICE = .30;
    private static final DecimalFormat df = new DecimalFormat("0.00");


    /**
     * Empty constructor.
     */
    public Coffee() {

    }

    /**
     * Getter method, returns the size of a cup of coffee.
     * @return cupSize, the size of the coffee.
     */
    public String getCupSize() {

        return this.cupSize;
    }

    /**
     * Setter method, sets the size of a cup of coffee.
     * @param cupSize, the size of the coffee to be set.
     */
    public void setCupSize(String cupSize) {
        this.cupSize = cupSize;
    }

    /**
     * Getter method, returns the number of add ins for a cup of coffee.
     * @return numAddIns, the number of add ins in a cup of coffee.
     */
    public int getNumAddIns() {

        return this.numAddIns;
    }

    /**
     * Setter method, sets the number of add ins for a cup of coffee.
     * @param numAddIns, the number of add ins in a cup of coffee.
     */
    public void setNumAddIns(int numAddIns) {

        this.numAddIns = numAddIns;
    }

    /**
     * Getter method, returns the list of AddIns.
     * @return addIns, the list of add ins for a cup of coffee.
     */
    public ArrayList<String> getAddIns() {
        return this.addIns;
    }

    /**
     * Getter method, gets the amount of cups of coffee.
     * @return quantity, the amount of cups of coffee.
     */
    public int getQuantity() {

        return this.quantity;
    }

    /**
     * Setter method, sets the amount of cups of coffee.
     * @param quantity, the amount of cups of coffee to be set.
     */
    public void setQuantity(int quantity) {

        this.quantity = quantity;
    }

    /**
     * Adds in a new addIn into the list of AddIns.
     * @param addIn, the choice of an addIn for a cup of coffee.
     */
    public void addToList(String addIn) {
        addIns.add(addIn);
    }


    /**
     * Calculates the price for a cup of coffee, including any add-ins.
     * @return price, the price for a cup of coffee.
     */
    @Override
    public double itemPrice() {

        double price = 0.0;

        if(cupSize.equals("Short")) {
            price = SHORT_SIZE_PRICE;
        }
        else if(cupSize.equals("Tall")) {
            price = TALL_SIZE_PRICE;
        }
        else if(cupSize.equals("Grande")) {
            price = GRANDE_SIZE_PRICE;
        }
        else if(cupSize.equals("Venti")) {
            price = VENTI_SIZE_PRICE;
        }

        double addInCost = (ADD_IN_PRICE * numAddIns);
        price = price + addInCost;
        return price;
    }

    /**
     * Displays the relevant information for a cup of coffee, including any add-ins.
     * @return info, a string containing the number of cups of coffee, their cupsizes and the add-ins.
     */
    @Override
    public String displayInfo() {

        String info = this.quantity + this.cupSize + " Coffee ";
        for(String element: addIns) {
            info += element + ", ";
        }
        return info;
    }

    /**
     * Returns a string containing the amount for a cup of coffee.
     * @return the amount for a cup of coffee.
     */
    @Override
    public String toString() {
        String s = "";
        if(addIns == null || addIns.size() == 0){
            s = "Coffee " + + this.getQuantity() + " " + this.getCupSize();
        }else{
            s = "Coffee " + this.getQuantity() + " " + this.getCupSize() + " " + this.addIns;
        }
        return s;
    }
}