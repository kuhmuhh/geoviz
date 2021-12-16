package assignment08;

public class Foodtruck {

    private static int satisfied;

    public static int getSatisfied() {
        return satisfied;
    }

    public static void serve(HungryGuest guest) {
        while (guest.getCalories() >= 0 && guest.getAngryLevel() < guest.getMaxAngry()){
            if (guest.getFruitCount() <= 4 && guest.getVegetableCount() <= 4){
                guest.eat();
            }
            else {
                guest.setAngryLevel(guest.getAngryLevel() + 1);
            }
        }
        if (guest.getAngryLevel() >= guest.getMaxAngry()) {
            System.out.println("HungryGuest left!");
        }
        else {
            satisfied++;
        }
    }

}
