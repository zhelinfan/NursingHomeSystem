package administrationpage;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class PopingWindowNoRight implements PopingWindow{
	Alert alert = new Alert(AlertType.WARNING);

	@Override
	public void initial() {
		
		alert.setContentText("\t\t\t\tû��Ȩ���޸ĸ��û�");
		alert.setTitle("��ʾ");
        alert.show();   
		
	}


}
