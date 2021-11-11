package assignment03;

public class Solution03 {

    public static void main(String[] args) {

        int home = (int) (Math.random() * 5);
        int guest = (int) (Math.random() * 5);

        int homeBet = 1;
        int guestBet =1;

        System.out.println("Result: " + home + ":" + guest);
        System.out.println("bet: " + homeBet + ":" + guestBet);
        System.out.println("points scored: " + soccerBet(home, guest, homeBet, guestBet));

    }

    /**
     * This method takes the result of a soccer match
     * and compares the result to a bet.
     *
     * @param home
     * @param guest
     * @param betHome
     * @param betGuest
     * @return points scored
     */
    public static int soccerBet(int home, int guest, int betHome, int betGuest) {

        int result;

        if ((home == betHome) && (guest == betGuest)){
            result = 3;
        }
        else if((home == guest) && (betHome == betGuest)){
            result = 1;
        }
        else if((home > guest) && (betHome > betGuest )){
            result = 1;
        }
        else if((home < guest) && (betHome < betGuest)){
            result = 1;
        }
        else{
            result = 0;
        }

        return result;

    }

}
