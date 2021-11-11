package assignment03;

public class Solution04 {

    public static void main(String[] args) {

        System.out.println(getWeekDay(11, 11, 2021 ));

    }

    /**
     * This method calculates the weekday of a given date
     * @param day
     * @param month
     * @param year
     * @return weekday
     */
    public static String getWeekDay(int day, int month, int year){

        int c;
        int y;
        int h;
        String weekDay;

        if(month <= 2){
            month = month + 10;
            year = year - 1;
        }
        else{
            month = month - 2;
        }

        c = year / 100;
        y = year % 100;
        h = (((26 * month -2) / 10) + day + y + y / 4 + c / 4 - 2 * c) % 7;

        if (h < 0){
            h = h + 7;
        }

        switch (h){
            case 0:
                weekDay = "Sunday";
                break;
            case 1:
                weekDay = "Monday";
                break;
            case 2:
                weekDay = "Tuesday";
                break;
            case 3:
                weekDay = "Wednesday";
                break;
            case 4:
                weekDay = "Thursday";
                break;
            case 5:
                weekDay = "Friday";
                break;
            case 6:
                weekDay = "Saturday";
                break;
            default:
                weekDay = "Error";
                break;
        }

        return weekDay;

    }

}
