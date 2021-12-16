package assignment08;

public class HungryGuest {
    private int angryLevel;
    private int calories;
    private int maxAngry;
    private int count;
    private int fruitCount;
    private int vegetableCount;

    /**
     * Constructor
     * initializes maxAngry with a random number between 1 and 10
     * initializes calories with a random number between 1 and 2000
     * initializes angryLevel with 0
     */
    public HungryGuest (){
        this.maxAngry = (int) (Math.random() * 10);
        this.calories =(int) (Math.random() * 2000);
        this.angryLevel = 0;
    }

    /**
     * This method sets the calories
     * @param calories calories
     */
    public void setCalories(int calories) {
        this.calories = calories;
    }

    /**
     * This method gets the calories
     * @return calories
     */
    public int getCalories() {
        return calories;
    }

    /**
     * This method sets the angryLevel
     * @param angryLevel angryLevel
     */
    public void setAngryLevel(int angryLevel) {
        this.angryLevel = angryLevel;
    }

    /**
     * This method gets the angryLevel
     * @return angryLevel
     */
    public int getAngryLevel() {
        return angryLevel;
    }

    /**
     * This method gets maxAngry
     * @return maxAngry
     */
    public int getMaxAngry() {
        return maxAngry;
    }

    /**
     * This method gets the fruitCount
     * @return fruitCount
     */
    public int getFruitCount() {
        return fruitCount;
    }

    /**
     * This method gets the vegetableCount
     * @return vegetableCount
     */
    public int getVegetableCount() {
        return vegetableCount;
    }

    /**
     * This method decides if the guest gets a vegetable or fruit with a 50% each
     * and subtracts the calories from the food of the calories from the guest
     * and increases the angryLevel of the guest if the same food is offered more than 4 times in a row
     */
    public void eat(){
        int rand = (int)Math.random() * 100;
        if (rand <= 50) {
            Fruits fruit = new Fruits();
            fruitCount++;
            vegetableCount = 0;
            if (fruitCount >= 5) {
                System.out.println("Please, no more Fruits.");
                System.out.println("I need something else first");
            } else {
                System.out.println("HungryGuest is eating: Fruits (" + fruit.getCalories() + ")" + this.getCalories());
                this.setCalories(this.getCalories() - fruit.getCalories());
            }
        }
        else {
            Vegetables vegetable = new Vegetables();
            vegetableCount++;
            fruitCount = 0;
            if (vegetableCount >= 5){
                System.out.println("Please. no more Fruits.");
                System.out.println("I need something else first");
            }
            else {
                System.out.println("HungryGuest is eating: Vegetables (" + vegetable.getCalories() + ")" + this.getCalories());
                this.setCalories(this.getCalories() - vegetable.getCalories());
            }
        }
    }

}
