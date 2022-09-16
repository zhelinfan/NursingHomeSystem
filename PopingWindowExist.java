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
		
		alert.setContentText("\t\t\t\t   �Ѵ���\n\t\t\t   �����Ƿ�������ȷ");
		alert.setTitle("��ʾ");
        alert.show();   
		
	}

}
