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
			System.out.println("û�ҵ�ͼƬ");
		}
		alert.getDialogPane().getButtonTypes().add(ButtonType.OK);
		alert.setHeaderText("�ɹ���");
		alert.setTitle("��ʾ");
		alert.show();
	}

}
