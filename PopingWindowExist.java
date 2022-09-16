package administrationpage;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class PopingWindowExist implements PopingWindow{
	Alert alert = new Alert(AlertType.WARNING);
	private static PopingWindowExist singleton = new PopingWindowExist();
	private PopingWindowExist()
	{
		
	}
	static public PopingWindowExist getPopingWindow()
	{
		return singleton;
	}
	@Override
	public void initial() {
		
		alert.setContentText("\t\t\t\t   已存在\n\t\t\t   请检查是否输入正确");
		alert.setTitle("提示");
        alert.show();   
		
	}

}
