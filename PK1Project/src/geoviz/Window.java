package geoviz;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

import javafx.scene.input.MouseEvent;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Stack;

/**
 * This class is used for displaying and handling the application
 */
public class Window extends Application {

    /**
     * This field represents a BorderPane used for displaying the grid and points, lines, circles and intersectionpoints
     */
    private static BorderPane pane;
    /**
     * This field represents a radiobutton to draw a line
     */
    private static RadioButton radioButtonLine;
    /**
     * This field represents a radiobutton to draw a circle
     */
    private static RadioButton radioButtonCircle;
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
    private static Stack<MyPoint> stackDraw = new Stack<>();
    /**
     * This field stores a group for intersection points
     */
    private static Group intersectionGroup = new Group();

    /**
     * This method is used for the layout of the application
     *
     * @param primaryStage primaryStage
     */
    public void start(Stage primaryStage) {

        Label showIt = new Label();

        //Top Toolbar
        ToolBar toolBarTop = new ToolBar();

        RadioButton radioButtonLine = new RadioButton("Line");
        Window.radioButtonLine = radioButtonLine;
        radioButtonLine.setSelected(true);
        toolBarTop.getItems().add(radioButtonLine);
        toolBarTop.getItems().add(new Separator());
        RadioButton radioButtonCircle = new RadioButton("Circle");
        Window.radioButtonCircle = radioButtonCircle;
        toolBarTop.getItems().add(radioButtonCircle);
        toolBarTop.getItems().add(new Separator());
        ToggleGroup toggleGroup = new ToggleGroup();
        radioButtonLine.setToggleGroup(toggleGroup);
        radioButtonCircle.setToggleGroup(toggleGroup);

        CheckBox checkBoxFill = new CheckBox("Fill");
        toolBarTop.getItems().add(checkBoxFill);
        toolBarTop.getItems().add(new Separator());

        Button buttonIntersection = new Button("Show Intersection(s)");
        toolBarTop.getItems().add(buttonIntersection);
        toolBarTop.getItems().add(new Separator());

        ColorPicker colorPicker = new ColorPicker();
        color = Color.BLACK;
        colorPicker.setValue(Color.BLACK);
        toolBarTop.getItems().add(colorPicker);

        BorderPane topBar = new BorderPane(toolBarTop);

        //Bottom Toolbar
        ToolBar toolBarBottom = new ToolBar();

        Button buttonData = new Button("Load Data");
        toolBarBottom.getItems().add(buttonData);
        toolBarBottom.getItems().add(new Separator());

        Button buttonClear = new Button("Clear Screen");
        toolBarBottom.getItems().add(buttonClear);

        BorderPane bottomBar = new BorderPane(toolBarBottom);

        //Layout
        BorderPane pane = pane();
        this.pane = pane;

        Scene scene = new Scene(pane, 800, 800);

        pane.setTop(topBar);
        pane.setBottom(bottomBar);
        primaryStage.setTitle("PK1 - Project");
        primaryStage.setScene(scene);
        primaryStage.show();

        pane.setOnMouseClicked(new MouseClick(showIt));

        colorPicker.setOnAction(event ->
        {
            color = colorPicker.getValue();
        });

        buttonClear.setOnAction(event ->
        {
            clearScreen();
        });

        buttonData.setOnAction(event ->
        {
            ArrayList<MyPoint> data = new ArrayList<>();
            data = DataLoader.readData();
            for (int i = 0; i < data.size(); i++) {
                addPoint(data.get(i));
            }
        });

        checkBoxFill.setOnAction(event ->
        {
            isFillSelected = !isFillSelected;
        });

        buttonIntersection.setOnAction(event ->
        {
            if (Objects.equals(buttonIntersection.getText(), "Show Intersection(s)")) {
                calcIntersections();
                buttonIntersection.setText("Hide Intersections(s)");
            } else if (Objects.equals(buttonIntersection.getText(), "Hide Intersections(s)")) {
                buttonIntersection.setText("Show Intersection(s)");
                clearIntersection();
            }

        });

    }

    /**
     * The grid is being drawn onto the pane
     * @return pane with grid
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
     *
     * @param point point
     */
    public static void addPoint(MyPoint point) {
        if (!isPointInList(point)) {
            Circle circle = new Circle(point.getX(), point.getY(), 5);
            circle.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
                System.out.println("click");
                stackDraw.push(point);
                if (radioButtonLine.isSelected())
                    addLine();
                if (radioButtonCircle.isSelected()) {
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
     * This method is used for creating intersection points
     *
     * @param point intersection point
     */
    public static void addPointIntersection(MyPoint point) {
        if (!isPointInList(point)) {
            Circle circle = new Circle(point.getX(), point.getY(), 5);
            circle.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
                System.out.println("click");
                stackDraw.push(point);
                if (radioButtonLine.isSelected())
                    addLine();
                if (radioButtonCircle.isSelected()) {
                    addCircle();
                }
            });
            pane.getChildren().add(circle);
            intersectionGroup.getChildren().add(circle);
            circle.setStroke(Color.RED);
            circle.setFill(Color.RED);
            Tooltip.install(circle, new Tooltip("x: " + circle.getCenterX() + " ; y: " + circle.getCenterY()));
            list.add(point);
        } else {
        }
    }

    /**
     * This method checks whether the point has been added to the list
     *
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
        if (stackDraw.size() == 2) {
            MyPoint stackPoint1 = stackDraw.peek();
            stackDraw.pop();
            MyPoint stackPoint2 = stackDraw.peek();
            stackDraw.pop();
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
        if (stackDraw.size() == 2) {
            MyPoint stackPoint1 = stackDraw.peek();
            stackDraw.pop();
            MyPoint stackPoint2 = stackDraw.peek();
            stackDraw.pop();
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
        stackDraw.clear();
        lineList.clear();
        circleList.clear();
        intersectionList.clear();
        list.clear();
        intersectionGroup.getChildren().clear();
    }

    /**
     * This method calculates the Intersections between lines and line, circles and circles and lines and circles and creates the points on the intersection
     */
    public static void calcIntersections() {
        pane.getChildren().add(intersectionGroup);

        for (int i = 0; i < lineList.size(); i++) {
            for (int j = 0; j < lineList.size(); j++) {
                if (Utilities.getPointOfIntersection(lineList.get(i), lineList.get(j)) != null) {
                    MyPoint intersectionLine = new MyPoint(Utilities.getPointOfIntersection(lineList.get(i), lineList.get(j)).getX(), Utilities.getPointOfIntersection(lineList.get(i), lineList.get(j)).getY());
                    intersectionList.add(intersectionLine);
                    intersectionGroup.getChildren().add(intersectionLine);
                    addPointIntersection(intersectionLine);
                }
            }
        }

        for (int i = 0; i < circleList.size(); i++) {
            for (int j = 0; j < circleList.size(); j++) {
                if (Utilities.getPointOfIntersection(circleList.get(i), circleList.get(j)).size() != 0) {
                    System.out.println(circleList.size());
                    for (int k = 0; k < Utilities.getPointOfIntersection(circleList.get(i), circleList.get(j)).size(); k++) {
                        MyPoint intersectionCircle = new MyPoint(Utilities.getPointOfIntersection(circleList.get(i), circleList.get(j)).get(0).getX(), Utilities.getPointOfIntersection(circleList.get(i), circleList.get(j)).get(0).getY());
                        intersectionList.add(intersectionCircle);
                        intersectionGroup.getChildren().add(intersectionCircle);
                        addPointIntersection(intersectionCircle);
                    }
                }
            }
        }

        for (int i = 0; i < lineList.size(); i++) {
            for (int j = 0; j < circleList.size(); j++) {
                if (Utilities.getPointOfIntersection(lineList.get(i), circleList.get(j)).size() != 0) {
                    for (int k = 0; k < Utilities.getPointOfIntersection(lineList.get(i), circleList.get(j)).size(); k++) {
                        MyPoint intersectionLineCircle = new MyPoint(Utilities.getPointOfIntersection(lineList.get(i), circleList.get(j)).get(0).getX(), Utilities.getPointOfIntersection(lineList.get(i), circleList.get(j)).get(0).getY());
                        intersectionGroup.getChildren().add(intersectionLineCircle);
                        addPointIntersection(intersectionLineCircle);
                    }
                }
            }
        }

    }

    /**
     * This method removes all intersection points
     */
    public static void clearIntersection() {
        for (int i = 0; i < pane.getChildren().size(); i++) {
            if (pane.getChildren().get(i) == intersectionGroup) {
                pane.getChildren().remove(i);
            }
        }
    }

}