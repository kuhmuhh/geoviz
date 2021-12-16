package assignment08;

public class Food {

    private int calories;

    /**
     * Constructor
     * initializes calories with a random number between 1 and 100
     */
    public Food(){
        this.calories = (int) (Math.random() * 100);
    }

    /**
     * This method sets the calories
     * @param calories calories
     */
    public void setCalories(int calories) {
        this.calories = calories;
    }

    /**
     * This method get the calories
     * @return calories
     */
    public int getCalories() {
        return calories;
    }
}
