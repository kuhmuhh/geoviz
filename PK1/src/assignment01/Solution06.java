package assignment01;

public class Solution06 {
    public static void main(String[] args) {

        int givenNumber = 100000000;
        int years = 0;
        int days;
        int hours;
        int minutes;
        int seconds;
        int secondsPerYear = 31536000;
        int secondsPerDay = 86400;
        int secondsPerHour = 3600;
        int secondsPerMinutes = 60;

        years = givenNumber / secondsPerYear;
        days = (givenNumber % secondsPerYear) / secondsPerDay;
        hours = (givenNumber -years * secondsPerYear -days * secondsPerDay)/secondsPerHour;
        minutes = givenNumber / 60 % 60;
        seconds = givenNumber % 60;

        System.out.println("years : " + years);
        System.out.println("days: " + days);
        System.out.println("hours: " + hours);
        System.out.println("minutes: " + minutes);
        System.out.println("seconds: " + seconds);

    }
}
