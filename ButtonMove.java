package administrationpage;

import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;

public class ButtonMove {
		static public void buttonMove(Button button)
		{
			button.addEventHandler(MouseEvent.MOUSE_MOVED, new EventHandler<MouseEvent>() {

				@Override
				public void handle(MouseEvent arg0) {
					// TODO Auto-generated method stub
					
					  button.setStyle("-fx-background-color: darkslateblue; -fx-text-fill: white;"); 
				}
			
		    });
		}
}
