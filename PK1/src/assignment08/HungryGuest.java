package assignment08;

public class HungryGuest {
    private int angryLevel;
    private int calories;
    private int maxAngry;
    private int count;
    private int fruitCount;
    private int vegetableCount;

    public HungryGuest (){
        this.maxAngry = (int) (Math.random() * 50);
        this.calories =(int) (Math.random() * 2000);
        this.angryLevel = 0;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public int getCalories() {
        return calories;
    }

    public void setAngryLevel(int angryLevel) {
        this.angryLevel = angryLevel;
    }

    public int getAngryLevel() {
        return angryLevel;
    }

    public int getMaxAngry() {
        return maxAngry;
    }

    public int getFruitCount() {
        return fruitCount;
    }

    public int getVegetableCount() {
        return vegetableCount;
    }

    public void serve(){
        int fruitCount;
        int vegetableCount;
        while (getCalories() >= 0){
            eat();
        }
    }

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
