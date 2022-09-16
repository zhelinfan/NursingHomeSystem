package administrationpage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


public class PopingWindowSuccess implements PopingWindow
{
    Alert alert = new Alert(null);
    Image image ;
    ImageView imaginView;
	@Override
	public void initial()
	{
		try
		{
			image = new Image(new FileInputStream("lib/xiaolian.jpg"));
			imaginView = new ImageView(image);
			imaginView.setFitHeight(100);
			imaginView.setFitWidth(100);
			alert.setGraphic(imaginView);
		} catch (FileNotFoundException e)
		{
			System.out.println("没找到图片");
		}
		alert.getDialogPane().getButtonTypes().add(ButtonType.OK);
		alert.setHeaderText("成功！");
		alert.setTitle("提示");
		alert.show();
	}

}
