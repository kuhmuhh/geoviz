package assignment12;

import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

import java.util.ArrayList;

public class MouseClick implements EventHandler<MouseEvent> {

    private Label showIt;
    private ArrayList<MyPoint> list;

    public MouseClick(Label showIt){
        this.showIt = showIt;
    }

    @Override
    public void handle(MouseEvent event) {
        MyPoint point = new MyPoint(event.getX(), event.getY());
        System.out.println(point);
        assignment12.Window.addPoint(point);
        //this.list = list;
        //list.add(point);
        //assignment12.Window.
    }
}
