package assignment09;

/**
 * This subclass of Currency implements the currency Pound
 */
public class Pound extends Currency{

    private static double rate;
    private double dollar;
    private double pound;

    /**
     * Construcot
     * @param amount amount in Pound
     */
    Pound(double amount){
        this.pound = amount;
    }

    /**
     * This method calculates the USDollar value of Pound
     * @return
     */
    @Override
    public double dollarValue() {
        return rate * dollar;
    }

    /**
     * This method sets the rate for the conversion to USDollar
     * @param rate rate in double
     */
    public static void setRate(double rate) {
        rate = rate;
    }
}
