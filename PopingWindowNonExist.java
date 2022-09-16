package administrationpage;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;


public class PopingWindowNonExist implements PopingWindow{
	private static PopingWindowNonExist singleton = new PopingWindowNonExist();
	Alert alert = new Alert(AlertType.ERROR);
	private PopingWindowNonExist()
	{
		
	}
	static public PopingWindowNonExist getPopingWindow()
	{
		return singleton;
	}
	public void initial()
	{
		alert = new Alert(AlertType.ERROR);
		alert.setContentText("\t\t\t\t不存在\n\t\t请检查是否输入正确");
		alert.setTitle("提示");
        alert.show();       
	}
}
