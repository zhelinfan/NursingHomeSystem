package administrationpage;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class PopingWindowBHR implements PopingWindow{
	Alert alert = new Alert(AlertType.WARNING);
	private static PopingWindowBHR singleton = new PopingWindowBHR();
	private PopingWindowBHR()
	{
		
	}
	static public PopingWindowBHR getPopingWindow()
	{
		return singleton;
	}
	@Override
	public void initial()
	{
		alert.setContentText("\t\t\t\t房屋不存在或会员已购买过");
		alert.setTitle("提示");
        alert.show();   
		
	}
}
