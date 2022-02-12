package geoviz;

import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Circle;

/**
 * This Class implements an EventHandler for a mouseclick
 */
public class MouseClick implements EventHandler<MouseEvent> {
    /**
     * showIt label
     */
    private Label showIt;

    /**
     * Constructor
     * @param showIt
     */
    public MouseClick(Label showIt) {
        this.showIt = showIt;
    }

    /**
     * This method adds a point
     * @param event
     */
    public void handle(MouseEvent event) {
        MyPoint point = new MyPoint(event.getX(), event.getY());
        System.out.println(point);
        geoviz.Window.addPoint(point);
    }

}