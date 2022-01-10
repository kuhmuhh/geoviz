package assignment09;

/**
 * This subclass of Currency implements the currency USDollar
 */
public class Dollar extends Currency{

    private double dollar;

    /**
     * Constructor
     * @param amount amount in USDollar
     */
    Dollar(double amount){
        this.dollar = amount;
    }

    /**
     * This method returns the USDollar amount
     * @return amount in USDollar
     */
    @Override
    public double dollarValue() {
        return dollar;
    }
}
