package assignment08;

public class Food {

    private int calories;

    public Food(){
        this.calories = (int) (Math.random() * 100);
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public int getCalories() {
        return calories;
    }
}
