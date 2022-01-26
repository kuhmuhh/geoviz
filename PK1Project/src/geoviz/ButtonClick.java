package geoviz;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Label;

import java.awt.*;

public class ButtonClick implements EventHandler<ActionEvent> {

    private Label showIt;

    public ButtonClick(Label showIt){
        this.showIt = showIt;
    }

    public void handle(ActionEvent event){
        showIt.setText("Hello World");
    }


}
