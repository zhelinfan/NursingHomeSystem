package administrationpage;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class PopingWindowExistMem
{
	Alert alert = new Alert(AlertType.WARNING);
	private static PopingWindowExistMem singleton = new PopingWindowExistMem();
	private PopingWindowExistMem()
	{
		
	}
	static public PopingWindowExistMem getPopingWindow()
	{
		return singleton;
	}

	public void initial() {
		
		alert.setContentText("\t\t\t\t 该会员已购房\n\t\t\t   请检查是否输入正确");
		alert.setTitle("提示");
        alert.show();   
		
	}

	
}
