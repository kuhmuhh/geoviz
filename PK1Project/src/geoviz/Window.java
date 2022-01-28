package geoviz;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Stack;

public class Window extends Application {

    private static Pane pane;
    private static Label showIt;
    private static RadioButton radioButton1;
    private static RadioButton radioButton2;
    private static Color color;
    private static ArrayList<MyPoint> list = new ArrayList<>();
    private static Stack<MyPoint> stack = new Stack<>();

    public void init()  {

    }

    public void start(Stage primaryStage){

        Label showIt = new Label();

        //Top Toolbar
        ToolBar toolBar1 = new ToolBar();

        RadioButton radioButton1 = new RadioButton("Line");
        Window.radioButton1 = radioButton1;
        radioButton1.setSelected(true);
        toolBar1.getItems().add(radioButton1);
        toolBar1.getItems().add(new Separator());
        RadioButton radioButton2 = new RadioButton("Circle");
        Window.radioButton2 = radioButton2;
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
        color = Color.BLACK;
        colorPicker.setValue(Color.BLACK);
        toolBar1.getItems().add(colorPicker);
        toolBar1.getItems().add(new Separator());

        Button test = new Button("Test");
        toolBar1.getItems().add(test);

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
        /*
        radioButton1.addEventHandler(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

            }
        });
        /*
        radioButton1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                addLine();
            }
        });
        radioButton2.setOnAction(new ButtonClick(showIt));

         */

        /*
        toggleGroup.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
            @Override
            public void changed(ObservableValue<? extends Toggle> observable, Toggle oldValue, Toggle newValue) {
                if (radioButton1.isSelected()){
                        addLine();
                }
                if (radioButton2.isSelected()){
                    System.out.println("yo");
                }
            }
        });

         */


        radioButton1.setOnAction(event ->
        {
                addGeometry();
        });

        radioButton2.setOnAction(event ->
        {
            System.out.println("yo");
        });

        colorPicker.setOnAction(event ->
        {
            color = colorPicker.getValue();
        });

        test.setOnAction(event ->
        {
            addLine();
        });

        button3.setOnAction(event ->
        {
            clearScreen();
        });


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

    public static void addGeometry(){
        if (radioButton1.isSelected()){
            addLine();
        }
        if (radioButton2.isSelected()){
            //addCircle(point1, point2);
        }
    }

    public static void addPoint(MyPoint point){
        Circle circle = new Circle(point.getX(), point.getY(), 5);
        pane.getChildren().add(circle);
        list.add(point);
        stack.push(point);
    }

    public static void addLine(){
            if (stack.size() == 2) {
                MyPoint stackPoint1 = stack.peek();
                stack.pop();
                MyPoint stackPoint2 = stack.peek();
                stack.pop();
                MyLine lineCalc = new MyLine(stackPoint1, stackPoint2);
                Line line = new Line(stackPoint1.getX(), stackPoint1.getY(), stackPoint2.getX(), stackPoint2.getY());
                line.setStroke(color);
                line.setStrokeWidth(2.5);
                pane.getChildren().add(line);
            }
        /*
        MyPoint stackPoint1 = stack.peek();
        stack.pop();
        MyPoint stackPoint2 = stack.peek();
        stack.pop();
        Line line = new Line(stackPoint1.getX(), stackPoint1.getY(), stackPoint2.getX(), stackPoint2.getY());
        pane.getChildren().add(line);

         */

    }

    public static void addCircle(MyPoint point1, MyPoint point2){
        Circle circle = new Circle();
    }

    public static void clearScreen(){
        pane.getChildren().remove(2000,pane.getChildren().size());
        stack.clear();
    }

}