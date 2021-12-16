package assignment08;

public class Solution08 {

    public static void main(String[] args) {
        /*
        TennisPlayer t1 = new TennisPlayer("Roger Federer", 39);
        TennisPlayer t2 = new TennisPlayer("Boris Becker", 53, t1);
        TennisPlayer t3 = new TennisPlayer("Michael Stich", 52, t2);

        System.out.println(TennisPlayer.getPursuerNumber());

        System.out.println(t1);
        System.out.println(t3);
        System.out.println(t3.getStartingNumber());
        System.out.println(TennisPlayer.ageDifference(t1, t3));
        System.out.println(t1.isLast() + " " + t2.isLast());
         */

        Foodtruck truck = new Foodtruck();

        for (int i=1; i <=10; i++){
            HungryGuest guest = new HungryGuest();
            System.out.println("New Guest: " + i + "/10 needs " + guest.getCalories() + " calories and has a maximum angriness level of " + guest.getMaxAngry());
            truck.serve(guest);
        }
        System.out.println("We had " + truck.getSatisfied() + " satisfied guests.");
    }

}
