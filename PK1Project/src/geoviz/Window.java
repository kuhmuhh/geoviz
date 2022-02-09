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

/**
 * This class is used for displaying and handling of the application TODO
 */
public class Window extends Application {

    /**
     * This field represents a BorderPane used for displaying the grid and points, lines, circles and intersectionpoints
     */
    private static BorderPane pane;
    /**
     * This field represents a radiobutton to draw a line
     */
    private static RadioButton radioButton1;
    /**
     * This field represents a radiobutton to draw a circle
     */
    private static RadioButton radioButton2;
    /**
     * This field represents a color to be picked using the colorpicker
     */
    private static Color color;
    /**
     * This field is used for checking whether the fill checkbox is select or not
     */
    private static boolean isFillSelected;
    /**
     * This field stores MyPoints in an ArrayList to check whether a point is already on the pane
     */
    private static ArrayList<MyPoint> list = new ArrayList<>();
    /**
     * This field stores MyLines in an ArrayList
     */
    private static ArrayList<MyLine> lineList = new ArrayList<>();
    /**
     * This field stores MyCircles in an ArrayList
     */
    private static ArrayList<MyCircle> circleList = new ArrayList<>();
    /**
     * This field stores intersection as MyPoints in an ArrayList
     */
    private static ArrayList<MyPoint> intersectionList = new ArrayList<>();
    /**
     * This field stores two MyPoint instances in a stack to either draw a line or a circle
     */
    private static Stack<MyPoint> stack = new Stack<>();

    /**
     * This method is used for the layout of the application
     * @param primaryStage primaryStage
     */
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

        Scene scene = new Scene(pane, 800, 800);

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
            for (int i = 0; i < data.size(); i++) {
                addPoint(data.get(i));
            }
        });

        checkBox.setOnAction(event ->
        {
            isFillSelected = !isFillSelected;
        });

        buttonIntersection.setOnAction(event ->
        {
            calcIntersections();
        });

    }

    /**
     * TODO
     *
     * @return
     */
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

    /**
     * This method creates a MyPoint instance and draws a point on the pane where it has been clicked
     * @param point point
     */
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
        } else {
        }
    }

    /**
     * This method checks whether the point has been added to the list
     * @param point point to be checked
     * @return true or false
     */
    public static boolean isPointInList(MyPoint point) {
        for (int i = 0; i < list.size(); i++) {
            if (Objects.equals(list.get(i), point)) {
                return true;
            }
        }
        return false;
    }

    /**
     * This method creates a MyLine instance and draws a line on the pane
     */
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
            lineList.add(lineCalc);
        }
    }

    /**
     * This method creates a MyCircle instance and draws a circle on the pane
     */
    public static void addCircle() {
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
            if (isFillSelected) {
                circle.setFill(color);
            } else {
                circle.setFill(null);
            }
            circle.setStroke(color);
            circle.setStrokeWidth(2.5);
            pane.getChildren().add(circle);
            circleList.add(circleCalc);
        }
    }

    /**
     * This method clears the screen of points, lines, circles and intersectionpoints
     */
    public static void clearScreen() {
        pane.getChildren().remove(2002, pane.getChildren().size());
        stack.clear();
        lineList.clear();
        circleList.clear();
        intersectionList.clear();
        list.clear();
    }

    /**
     * This method calculates the Intersections between lines and line, circles and circles and lines and circles and creates the points on the intersection
     */
    public static void calcIntersections() {
        //line line
        for (int i = 0; i < lineList.size(); i++) {
            for (int j = 0; j < lineList.size(); j++) {
                if (Utilities.getPointOfIntersection(lineList.get(i), lineList.get(j)) != null) {
                    MyPoint intersectionLine = new MyPoint(Utilities.getPointOfIntersection(lineList.get(i), lineList.get(j)).getX(), Utilities.getPointOfIntersection(lineList.get(i), lineList.get(j)).getY());
                    intersectionList.add(intersectionLine);
                    //addPoint(intersectionLine);
                }
            }
        }
        //circle circle
        for (int i = 0; i < circleList.size(); i++) {
            for (int j = 0; j < circleList.size(); j++) {
                if (Utilities.getPointOfIntersection(circleList.get(i), circleList.get(j)) != null) {
                    int x = 0;
                    System.out.println(circleList.size());
                    MyPoint intersectionCircle = new MyPoint(Utilities.getPointOfIntersection(circleList.get(i), circleList.get(j)).get(0).getX(), Utilities.getPointOfIntersection(circleList.get(i), circleList.get(j)).get(0).getY());
                    intersectionList.add(intersectionCircle);
                    x++;
                    //addPoint(intersectionCircle);
                }
            }
        }

        //circle line
        for (int i = 0; i < circleList.size(); i++) {
            for (int j = 0; j < lineList.size(); j++) {
                if (Utilities.getPointOfIntersection(lineList.get(i), circleList.get(j)) != null) {
                    int y = 0;
                    MyPoint intersectionLineCircle = new MyPoint(Utilities.getPointOfIntersection(lineList.get(i), circleList.get(j)).get(0).getX(), Utilities.getPointOfIntersection(lineList.get(i), circleList.get(j)).get(0).getY());
                    intersectionList.add(intersectionLineCircle);
                    //addPoint(intersectionLineCircle);
                    y++;
                }
            }
        }

        //adding intersections to pane
        for (int i = 0; i < intersectionList.size(); i++) {
            addPoint(intersectionList.get(i));
        }
    }

}