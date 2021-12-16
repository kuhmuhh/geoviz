package assignment08;

public class Foodtruck {

    private static int satisfied;

    /**
     * This method returns the amount of guests satisfied
     * @return amount of satisfied guests
     */
    public static int getSatisfied() {
        return satisfied;
    }

    /**
     * This method checks whether the guest has eaten enough or has reached his maxAngry level
     * and after checks if the guest has been offered the same food too many times in a row
     * if that is not the case the guest eats
     * it that is the case the guest leaves
     * if the costumer has eaten enough (calories = 0) the satisfied counter gets incremented
     * @param guest HungryGuest instance
     */
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
