package geoviz;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DataLoader {

    public static ArrayList<MyPoint> readData() {

        BufferedReader in;

        File file = new File("src" + File.separator + "geoviz" + File.separator + "/data.txt");
        ArrayList<MyPoint> end = new ArrayList<>();

        try {
            in = new BufferedReader(new FileReader(file));
            String content;
            String[] tokens;


            while ((content = in.readLine()) != null) {
                tokens = content.split(",");
                for (int i = 0; i < tokens.length; i=i+2) {
                    end.add(new MyPoint(Double.parseDouble(tokens[i]), Double.parseDouble(tokens[i+1])));
                }

            }

            in.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return end;

    }

}
