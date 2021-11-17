package assignment04;

public class Solution05 {

    public static void main(String[] args) {

        int[][] bets = {{3,2,3,2},{1,1,1,0},{2,2,1,1}};

        System.out.println("Points: " + soccerBets(bets));
    }

    /**
     * This method calcutes multiple bets of a single person
     * @param bets multiple bets
     * @return points scored
     */
    public static int soccerBets(int[][] bets){

        int points = 0;
        int numberOfBets = bets.length;

        for (int i=0; i<numberOfBets ; i++) {
             points = points + assignment03.Solution03.soccerBet(bets[i][0], bets[i][1], bets[i][2], bets[i][3]);
        }

        return points;
    }



}
