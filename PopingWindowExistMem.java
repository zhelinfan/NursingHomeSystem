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
		
		alert.setContentText("\t\t\t\t �û�Ա�ѹ���\n\t\t\t   �����Ƿ�������ȷ");
		alert.setTitle("��ʾ");
        alert.show();   
		
	}

	
}
