package assignment09;

/**
 * This subclass of Currency implements the curreny Yen
 */
public class Yen extends Currency{

    private static double rate;

    private double yen;

    /**
     * Constructor
     * @param amount amount in Yen
     */
    Yen(double amount){
        this.yen = amount;
    }

    /**
     * This method calculates the USDollar value of Yen
     * @return
     */
    @Override
    public double dollarValue() {
        return rate * yen;
    }

    /**
     * This method sets the rate for the conversion to USDollar
     * @param newRate rate in double
     */
    public static void setRate(double newRate) {
        rate = newRate;
    }
}
