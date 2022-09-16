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
		alert.setContentText("\t\t\t\t������\n\t\t�����Ƿ�������ȷ");
		alert.setTitle("��ʾ");
        alert.show();       
	}
}
