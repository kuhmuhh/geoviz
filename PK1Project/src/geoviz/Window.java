package geoviz;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

import java.awt.event.MouseEvent;
import java.beans.EventHandler;
import java.util.function.ToLongBiFunction;

public class Window extends Application {

    private static Pane pane;
    private static Label showIt;
    private static RadioButton radioButton1;
    private static RadioButton radioButton2;

    public void init()  {

    }

    public void start(Stage primaryStage){

        Label showIt = new Label();

        //Top Toolbar
        ToolBar toolBar1 = new ToolBar();

        RadioButton radioButton1 = new RadioButton("Line");
        this.radioButton1 = radioButton1;
        radioButton1.setSelected(true);
        toolBar1.getItems().add(radioButton1);
        toolBar1.getItems().add(new Separator());
        RadioButton radioButton2 = new RadioButton("Circle");
        this.radioButton2 = radioButton2;
        toolBar1.getItems().add(radioButton2);
        toolBar1.getItems().add(new Separator());
        ToggleGroup toggleGroup = new ToggleGroup();
        radioButton1.setToggleGroup(toggleGroup);
        radioButton2.setToggleGroup(toggleGroup);

        CheckBox checkBox = new CheckBox("Fill");
        toolBar1.getItems().add(checkBox);
        toolBar1.getItems().add(new Separator());

        Button button1 = new Button("Show Intersection");
        toolBar1.getItems().add(button1);
        toolBar1.getItems().add(new Separator());

        ColorPicker colorPicker = new ColorPicker();
        toolBar1.getItems().add(colorPicker);

        VBox root = new VBox(toolBar1);

        //Bottom Toolbar
        ToolBar toolBar2 = new ToolBar();

        Button button2 = new Button("Load Data");
        toolBar2.getItems().add(button2);
        toolBar2.getItems().add(new Separator());

        Button button3 = new Button("Clear Screen");
        toolBar2.getItems().add(button3);

        VBox vBox2 = new VBox(toolBar2);

        //Layout
        Pane pane = pane();
        this.pane = pane;
        root.getChildren().add(pane);
        root.getChildren().add(vBox2);
        Scene scene = new Scene(root, 500, 400);
        primaryStage.setTitle("PK1 - Project");
        primaryStage.setScene(scene);
        primaryStage.show();

        pane.setOnMouseClicked(new MouseClick(showIt));
        radioButton1.setOnAction(new ButtonClick(showIt));
        radioButton2.setOnAction(new ButtonClick(showIt));
    }

    private Pane pane(){
        Pane root = new Pane();
        for (int i = 0; i < 1000; i++)   {
            Line line = new Line();
            line.setStyle("-fx-stroke: #5d5d56");           //#5d5d56               #ffff00
            line.setStartX(10 * i);
            line.setStartY(0);
            line.setEndX(10 * i);
            line.setEndY(1500);
            root.getChildren().add(line);
        }
        for (int i = 0; i < 1000; i++){
            Line line = new Line();
            line.setStyle("-fx-stroke: #5d5d56");
            line.setStartX(0);
            line.setStartY(10 * i);
            line.setEndX(2300);
            line.setEndY(10 * i);
            root.getChildren().add(line);
        }
        return root;
    }

    public static void addGeometry(MyPoint point1, MyPoint point2){
        if (radioButton1.isSelected()){
            addLine(point1, point2);
        }
        if (radioButton2.isSelected()){
            addCircle(point1, point2);
        }
    }

    public static void addPoint(MyPoint point){
        Circle circle = new Circle(point.getX(), point.getY(), 5);
        pane.getChildren().add(circle);
        return;
    }

    public static void addLine(MyPoint point1, MyPoint point2){
        Line line = new Line(point1.getX(), point1.getY(), point2.getX(), point2.getY());
        pane.getChildren().add(line);
        return;
    }

    public static void addCircle(MyPoint point1, MyPoint point2){
        Circle circle = new Circle();
    }

}