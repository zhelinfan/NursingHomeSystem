package administrationpage;

import javafx.scene.control.Button;

public class PopingWindowF_RSS extends PopingWindowFindSS
{
   Button button = new Button("删除");

	
	public PopingWindowF_RSS()
	{
		super();
		gridpane.add(button, 3, 3);
	}

	public void setHeaderText()
	{
		alert.setHeaderText("该用户存在,\n若要删除请展开“显示更多信息”");
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
