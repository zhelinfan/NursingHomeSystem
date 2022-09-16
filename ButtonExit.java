package administrationpage;

import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;

public class ButtonExit {
	static public void buttonExit(Button button)
	{
		button.addEventHandler(MouseEvent.MOUSE_EXITED, new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
				  button.setStyle("-fx-background-color: #36648B; -fx-text-fill: white;"); 
			}
		
	    });
	}
}
