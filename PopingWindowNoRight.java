package administrationpage;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class PopingWindowNoRight implements PopingWindow{
	Alert alert = new Alert(AlertType.WARNING);

	@Override
	public void initial() {
		
		alert.setContentText("\t\t\t\t没有权限修改该用户");
		alert.setTitle("提示");
        alert.show();   
		
	}


}
