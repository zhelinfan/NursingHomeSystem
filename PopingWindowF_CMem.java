package administrationpage;

import javafx.scene.control.Button;

public class PopingWindowF_CMem extends PopingWindowFindMem{
	Button button = new Button("修改");
	
	
	public PopingWindowF_CMem()
	{
		super();
		// TODO Auto-generated constructor stub
	}
	public void setHeaderText()
	{
		alert.setHeaderText("该会员存在,\n若要修改信息请展开“显示更多信息”");
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
