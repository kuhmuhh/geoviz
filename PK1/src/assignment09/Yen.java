package assignment09;

public class Yen extends Currency{

    private static double rate;
    private double dollar;
    private double yen;

    Yen(double amount){
        this.yen = amount;
    }

    @Override
    public double dollarValue() {
        return rate * dollar;
    }

    public static void setRate(double rate) {
        rate = rate;
    }
}
