package administrationpage;

import javafx.scene.control.Button;

public class PopingWindowF_RMem extends PopingWindowFindMem
{
	Button button = new Button("ɾ��");

	public void setHeaderText()
	{
		alert.setHeaderText("�û�Ա����,\n��Ҫ�޸���Ϣ��չ������ʾ������Ϣ��");
	}

	public void hide()
	{
		alert.hide();
	}

	public Button getButton()
	{
		gridpane.add(button, 3, 3);
		return button;
	}
}