package administrationpage;

import javafx.scene.control.Button;

public class PopingWindowF_RSS extends PopingWindowFindSS
{
   Button button = new Button("ɾ��");

	
	public PopingWindowF_RSS()
	{
		super();
		gridpane.add(button, 3, 3);
	}

	public void setHeaderText()
	{
		alert.setHeaderText("���û�����,\n��Ҫɾ����չ������ʾ������Ϣ��");
	}

	public void hide()
	{
		alert.hide();
	}

	public Button getButton()
	{
//		gridpane.add(button, 3, 3);
		return button;
	}
}
