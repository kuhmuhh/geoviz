package assignment08;

public class TennisPlayer {

    private String name;
    private int age;
    private TennisPlayer pursuer;
    private int startingNumber;

    private static int START_NUMBER;
    private static int PURSUER_NUMBER = 1;

    /**
     * Constructor
     * @param name name as String
     * @param age age as int
     */
    public TennisPlayer(String name, int age){
        this.name = name;
        this.age = age;
        START_NUMBER++;
        this.startingNumber = START_NUMBER;
        PURSUER_NUMBER++;
    }

    /**
     * Constructor
     * @param name name as String
     * @param age age as int
     * @param pursuer pursuer as TennisPlayer
     */
    public TennisPlayer(String name, int age, TennisPlayer pursuer){
        this.name = name;
        this.age = age;
        this.pursuer = pursuer;
        START_NUMBER++;
        this.startingNumber = START_NUMBER;
        PURSUER_NUMBER++;
    }

    /**
     * This method sets the age
     * @param age age
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * This method gets the age
     * @return age
     */
    public int getAge() {
        return age;
    }

    /**
     * This method sets the name
     * @param name name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * This method gets the name
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * This method gets the starting number
     * @return starting number
     */
    public int getStartingNumber() {
        return startingNumber;
    }

    /**
     * This method returns the pursuer number
     * @return pursuer number
     */
    public static int getPursuerNumber() {
        return PURSUER_NUMBER;
    }

    /**
     * This method returns the pursuer
     * @return pursuer
     */
    public TennisPlayer getPursuer() {
        return pursuer;
    }

    /**
     * This method checks whether a player is last in the world ranking
     * @return true or false
     */
    public boolean isLast(){
        if (pursuer == null){
            return true;
        }
        else {
            return false;
        }
    }

    /**
     * This method calculates the age difference between two players
     * @param p1 player 1
     * @param p2 player 2
     * @return age difference
     */
    public static int ageDifference(TennisPlayer p1, TennisPlayer p2){
        int difference;
        difference = Math.abs(p1.getAge()-p2.getAge());
        return difference;
    }

    /**
     * This method prints out the name and the starting number and if available the pursuer of that player
     * @return String
     */
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