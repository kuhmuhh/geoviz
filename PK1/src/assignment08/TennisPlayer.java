package assignment08;

public class TennisPlayer {

    private String name;
    private int age;
    private TennisPlayer pursuer;
    private int startingNumber;

    private static int START_NUMBER;
    private static int PURSUER_NUMBER = 1;


    public TennisPlayer(String name, int age){
        this.name = name;
        this.age = age;
        START_NUMBER++;
        this.startingNumber = START_NUMBER;
        PURSUER_NUMBER++;
    }

    public TennisPlayer(String name, int age, TennisPlayer pursuer){
        this.name = name;
        this.age = age;
        this.pursuer = pursuer;
        START_NUMBER++;
        this.startingNumber = START_NUMBER;
        PURSUER_NUMBER++;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getStartingNumber() {
        return startingNumber;
    }

    public static int getPursuerNumber() {
        return PURSUER_NUMBER;
    }

    public TennisPlayer getPursuer() {
        return pursuer;
    }

    public boolean isLast(){
        if (pursuer == null){
            return true;
        }
        else {
            return false;
        }
    }

    public static int ageDifference(TennisPlayer p1, TennisPlayer p2){
        int difference;
        difference = Math.abs(p1.getAge()-p2.getAge());
        return difference;
    }

    @Override
    public String toString() {

        if (getPursuer() != null) {
            return name + " (" + startingNumber + ") " + "is better than " + pursuer;
        }
        else {
            return name + " (" + startingNumber + ")";
        }
    }
}