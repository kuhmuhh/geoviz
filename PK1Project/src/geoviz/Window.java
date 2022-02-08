package geoviz;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

import javafx.scene.input.MouseEvent;

import javax.swing.*;
import javax.tools.Tool;
import java.beans.EventHandler;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Stack;

public class Window extends Application {

    private static BorderPane pane;
    private static Label showIt;
    private static RadioButton radioButton1;
    private static RadioButton radioButton2;
    private static Color color;
    private static CheckBox checkBox;
    private static boolean isFillSelected;
    private static ArrayList<MyPoint> list = new ArrayList<>();
    private static Stack<MyPoint> stack = new Stack<>();

    public void init() {

    }

    public void start(Stage primaryStage) {

        Label showIt = new Label();

        //Top Toolbar
        ToolBar toolBar1 = new ToolBar();

        RadioButton radioButtonLine = new RadioButton("Line");
        Window.radioButton1 = radioButtonLine;
        radioButtonLine.setSelected(true);
        toolBar1.getItems().add(radioButtonLine);
        toolBar1.getItems().add(new Separator());
        RadioButton radioButtonCircle = new RadioButton("Circle");
        Window.radioButton2 = radioButtonCircle;
        toolBar1.getItems().add(radioButtonCircle);
        toolBar1.getItems().add(new Separator());
        ToggleGroup toggleGroup = new ToggleGroup();
        radioButtonLine.setToggleGroup(toggleGroup);
        radioButtonCircle.setToggleGroup(toggleGroup);

        CheckBox checkBox = new CheckBox("Fill");
        toolBar1.getItems().add(checkBox);
        toolBar1.getItems().add(new Separator());

        Button buttonIntersection = new Button("Show Intersection");
        toolBar1.getItems().add(buttonIntersection);
        toolBar1.getItems().add(new Separator());

        ColorPicker colorPicker = new ColorPicker();
        color = Color.BLACK;
        colorPicker.setValue(Color.BLACK);
        toolBar1.getItems().add(colorPicker);

        BorderPane root = new BorderPane(toolBar1);

        //Bottom Toolbar
        ToolBar toolBar2 = new ToolBar();

        Button button2 = new Button("Load Data");
        toolBar2.getItems().add(button2);
        toolBar2.getItems().add(new Separator());

        Button button3 = new Button("Clear Screen");
        toolBar2.getItems().add(button3);

        BorderPane vBox2 = new BorderPane(toolBar2);

        //Layout
        BorderPane pane = pane();
        this.pane = pane;

        Scene scene = new Scene(pane, 500, 400);

        pane.setTop(root);
        pane.setBottom(vBox2);
        primaryStage.setTitle("PK1 - Project");
        primaryStage.setScene(scene);
        primaryStage.show();

        pane.setOnMouseClicked(new MouseClick(showIt));

        colorPicker.setOnAction(event ->
        {
            color = colorPicker.getValue();
        });

        button3.setOnAction(event ->
        {
            clearScreen();
        });

        button2.setOnAction(event ->
        {
            ArrayList<MyPoint> data = new ArrayList<>();
            data = DataLoader.readData();
            for (int i = 0; i < data.size()  ; i++) {
                addPoint(data.get(i));
            }
        });

        checkBox.setOnAction(event ->
        {
            isFillSelected =! isFillSelected;
        });


    }

    private BorderPane pane() {
        BorderPane root = new BorderPane();
        for (int i = 0; i < 1000; i++) {
            Line line = new Line();
            line.setStyle("-fx-stroke: #5d5d56");           //#5d5d56               #ffff00
            line.setStartX(10 * i);
            line.setStartY(0);
            line.setEndX(10 * i);
            line.setEndY(1500);
            root.getChildren().add(line);
        }
        for (int i = 0; i < 1000; i++) {
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

    public static void addGeometry() {
        if (radioButton1.isSelected()) {
            addLine();
        }
        if (radioButton2.isSelected()) {
            //addCircle(point1, point2);
        }
    }

    public static void addPoint(MyPoint point) {
        if (!isPointInList(point)) {
            Circle circle = new Circle(point.getX(), point.getY(), 5);
            circle.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
                System.out.println("click");
                stack.push(point);
                if (radioButton1.isSelected())
                    addLine();
                if (radioButton2.isSelected()) {
                    addCircle();
                }
            });
            pane.getChildren().add(circle);
            Tooltip.install(circle, new Tooltip("x: " + circle.getCenterX() + " ; y: " + circle.getCenterY()));
            list.add(point);
        }
        else {}
    }

    public static boolean isPointInList(MyPoint point){
        for (int i = 0; i < list.size() ; i++) {
            if (Objects.equals(list.get(i),point)){
                return true;
            }
        }
        return false;
    }

    public static void addLine() {
        if (stack.size() == 2) {
            MyPoint stackPoint1 = stack.peek();
            stack.pop();
            MyPoint stackPoint2 = stack.peek();
            stack.pop();
            MyLine lineCalc = new MyLine(stackPoint1, stackPoint2);
            double slope = Utilities.getSlope(stackPoint1.getX(), stackPoint1.getY(), stackPoint2.getX(), stackPoint2.getY());
            double looong = slope * 10000 + Utilities.getIntercept(stackPoint1.getX(), stackPoint1.getY(), stackPoint2.getX(), stackPoint2.getY());
            Line line = new Line(0, Utilities.getIntercept(stackPoint1.getX(), stackPoint1.getY(), stackPoint2.getX(), stackPoint2.getY()), 10000, looong);
            Tooltip.install(line, new Tooltip("Slope: " + Utilities.getSlope(stackPoint1.getX(), stackPoint1.getY(), stackPoint2.getX(), stackPoint2.getY()) + " Intercept: " + lineCalc.getIntercept()));
            line.setStroke(color);
            line.setStrokeWidth(2.5);
            pane.getChildren().add(line);
        }
    }

    public static void addCircle() {
        //Circle circle = new Circle();
        if (stack.size() == 2) {
            MyPoint stackPoint1 = stack.peek();
            stack.pop();
            MyPoint stackPoint2 = stack.peek();
            stack.pop();
            MyCircle circleCalc = new MyCircle(stackPoint1, stackPoint2);
            MyPoint center = circleCalc.getCenter();
            double radius = Utilities.getDistance(stackPoint1, stackPoint2);
            Circle circle = new Circle(stackPoint1.getX(), stackPoint1.getY(), radius);
            Tooltip.install(circle, new Tooltip("CenterX: " + center.getX() + " CenterY: " + center.getY() + " Radius: " + radius));
            if (isFillSelected){
                circle.setFill(color);
            }
            else {
                circle.setFill(null);
            }
            circle.setStroke(color);
            circle.setStrokeWidth(2.5);
            pane.getChildren().add(circle);
        }
    }

    public static void clearScreen() {
        pane.getChildren().remove(2002, pane.getChildren().size());
        stack.clear();
    }

}