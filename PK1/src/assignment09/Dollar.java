package assignment09;

public class Dollar extends Currency{

    private double dollar;

    Dollar(double amount){
        this.dollar = amount;
    }

    @Override
    public double dollarValue() {
        return dollar;
    }
}
