package assignment12;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.scene.control.Label;

import java.awt.*;
import java.util.ArrayList;

public class Window extends Application {

    private static ArrayList<MyPoint> list;
    private static Pane pane;
    private static Label showIt;

    public void init(){

    }

    public void start(Stage primaryStage){

        Label showIt = new Label();
        ArrayList<MyPoint> list = new ArrayList<>();
        this.list = list;
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
        return;
    }

}
