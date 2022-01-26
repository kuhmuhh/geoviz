package geoviz;

import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Circle;

public class MouseClick implements EventHandler<MouseEvent>
{
    private Label showIt;
    public MouseClick(Label showIt)
    {
        this.showIt = showIt;
    }
    public void handle(MouseEvent event)
    {
        MyPoint point = new MyPoint(event.getX(), event.getY());
        System.out.println(point);
        geoviz.Window.addPoint(point);
    }

}