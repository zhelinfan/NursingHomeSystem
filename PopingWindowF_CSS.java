package administrationpage;

import javafx.scene.control.Button;

public class PopingWindowF_CSS extends PopingWindowFindSS
{
Button button = new Button("�޸�");
	
	public PopingWindowF_CSS()
	{
		super();
		gridpane.add(button, 3, 3);
	}
	public void setHeaderText()
	{
		alert.setHeaderText("���û�����,\n��Ҫ�޸���Ϣ��չ������ʾ������Ϣ��");
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
