package administrationpage;

import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

public abstract class PopingWindowFind
{
	Alert alert = new Alert(null);
	GridPane gridpane = new GridPane();
	Text text = new Text();
	
	public void initial() {
		// TODO Auto-generated method stub
		alert.getDialogPane().setExpandableContent(gridpane);
		gridpane.add(text, 0, 0);
		gridpane.setAlignment(Pos.CENTER);
		alert.getDialogPane().getButtonTypes().add(ButtonType.CLOSE);
        setHeaderText();
		alert.setTitle("ÌבÊ¾");
        alert.show();   
	}
	public abstract void setHeaderText();
	
	public Alert getAlert()
	{
		return alert;
	}
	
}
