package administrationpage;

import javafx.scene.control.Button;

public class PopingWindowF_CMem extends PopingWindowFindMem{
	Button button = new Button("�޸�");
	
	
	public PopingWindowF_CMem()
	{
		super();
		// TODO Auto-generated constructor stub
	}
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
