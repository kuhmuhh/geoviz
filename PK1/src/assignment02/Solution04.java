package assignment02;

public class Solution04 {
    public static void main(String[] args) {

        boolean switchA;
        boolean switchB;
        boolean switchC;
        boolean bulb;

        /*
        Hier die Werte für die jeweiligen Schalter eintragen
        Unten ist ein Beispiel gegeben
        */
        switchA = false;
        switchB = true;
        switchC = true;

        /*
        Wenn Schalter A oder B oder beide an sind und C an ist, leuchtet die Glühbirne
        */
        bulb = (switchA || switchB) && switchC;

        System.out.println("Bulb glows: " + bulb);

    }
}
