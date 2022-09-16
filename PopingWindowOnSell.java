package administrationpage;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class PopingWindowOnSell implements PopingWindow{
	Alert alert = new Alert(AlertType.WARNING);
	private static PopingWindowOnSell singleton = new PopingWindowOnSell();
	private PopingWindowOnSell()
	{
		
	}
	static public PopingWindowOnSell getPopingWindow()
	{
		return singleton;
	}
	@Override
	public void initial() {
		
		alert.setContentText("\t\t\t\t该房间还未售出");
		alert.setTitle("提示");
        alert.show();   
		
	}


}
