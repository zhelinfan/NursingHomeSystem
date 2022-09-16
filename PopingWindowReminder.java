package administrationpage;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class PopingWindowReminder implements PopingWindow{
	Alert alert = new Alert(AlertType.WARNING);
	private static PopingWindowReminder singleton = new PopingWindowReminder();
	private PopingWindowReminder()
	{
		
	}
	static public PopingWindowReminder getPopingWindow()
	{
		return singleton;
	}
	@Override
	public void initial() {
		
		alert.setContentText("\t\t\t\t请检查您的输入");
		alert.setTitle("提示");
        alert.show();   
		
	}
}
