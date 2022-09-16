package administrationpage;

import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class CloseButton
{
	Button button;
	Stage stage;

	public CloseButton(Button button, Stage stage)
	{
		this.button = button;
		this.stage = stage;
	}

	public void close()
	{
		button.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>()
		{

			@Override
			public void handle(MouseEvent arg0)
			{
				stage.close();
			}

		});
	}
}
