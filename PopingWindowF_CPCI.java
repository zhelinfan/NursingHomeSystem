package administrationpage;

import javafx.scene.control.Button;

public class PopingWindowF_CPCI extends PopingWindowFindPCI
{
	Button button = new Button("�޸�");
	
	public PopingWindowF_CPCI()
	{
		super();
		gridpane.add(button, 3, 3);
	}
	public void setHeaderText()
	{
		alert.setHeaderText("����ס��Ա����,\n��Ҫ�޸���Ϣ��չ������ʾ������Ϣ��");
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
