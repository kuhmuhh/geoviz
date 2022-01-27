package assignment12;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.scene.control.Label;

import java.awt.*;
import java.util.ArrayList;

public class Window extends Application {

    private static ArrayList<MyPoint> list = new ArrayList<MyPoint>();
    private static Pane pane;
    private static Label showIt;

    public void init(){

    }

    public void start(Stage primaryStage){

        Label showIt = new Label();
        Pane root = new Pane();
        this.pane = root;
        Scene scene = new Scene(root, 500, 400);
        primaryStage.setTitle("Assignment 12");
        primaryStage.setScene(scene);
        primaryStage.show();

        pane.setOnMouseClicked(new MouseClick(showIt));
    }

    public static void addPoint(MyPoint point){
        Circle circle = new Circle(point.getX(), point.getY(), 5);
        pane.getChildren().add(circle);
        list.add(point);
        System.out.println(line());
    }

    public static double line(){
        int size = list.size();
        double xAverage = 0;
        double yAverage = 0;
        double b = 0;
        double a = 0;

        for (int i = 0; i < size ; i++) {
            xAverage = list.get(i).getX() + xAverage;
            yAverage = list.get(i).getY() + yAverage;
        }

        xAverage = xAverage / size;
        yAverage = yAverage / size;

        for (int i = 0; i < size; i++){
            b = ((list.get(i).getX() - xAverage)*(list.get(i).getY() - yAverage))/((list.get(i).getX() - xAverage)*(list.get(i).getX() - xAverage));
        }

        a = yAverage - b * xAverage;

        return a;
    }

    public static void addLine(MyPoint point1, MyPoint point2){
        Line line = new Line(point1.getX(), point1.getY(), point2.getX(), point2.getY());
        pane.getChildren().add(line);
    }



}
