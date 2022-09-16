package administrationpage;

import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;

public class ButtonLeft {

	static public void buttonLeft(Button button)
	{
		button.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {

			public void handle(MouseEvent arg0) {
				
				  button.setStyle("-fx-background-color: darkslateblue; -fx-text-fill: white;");
				  System.exit(0);			  
			}
		
	    });
	}
}
