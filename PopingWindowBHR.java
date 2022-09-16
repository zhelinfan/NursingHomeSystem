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
		alert.setContentText("\t\t\t\t���ݲ����ڻ��Ա�ѹ����");
		alert.setTitle("��ʾ");
        alert.show();   
		
	}
}
