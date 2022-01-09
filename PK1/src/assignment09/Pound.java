package assignment09;

public class Pound extends Currency{

    private static double rate;
    private double dollar;
    private double pound;

    Pound(double amount){
        this.pound = amount;
    }

    @Override
    public double dollarValue() {
        return rate * dollar;
    }

    public static void setRate(double rate) {
        rate = rate;
    }
}
