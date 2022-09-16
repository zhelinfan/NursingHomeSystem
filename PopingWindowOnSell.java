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
		
		alert.setContentText("\t\t\t\t�÷��仹δ�۳�");
		alert.setTitle("��ʾ");
        alert.show();   
		
	}


}
