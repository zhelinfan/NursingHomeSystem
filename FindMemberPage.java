package administrationpage;

import Management.MemberManagement;
import entity.Member;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class FindMemberPage
{
	Stage stage = new Stage();
	GridPane gridpane = new GridPane();
	Scene scene = new Scene(gridpane);
	Text title = new Text("查找会员是否存在");
	TextField textField1 = new TextField();
	final ToggleGroup tg = new ToggleGroup();
	RadioButton buttonMemNum = new RadioButton("会员编号");
	RadioButton buttonTeleNum = new RadioButton("电话号码");
	Button button1 = new Button("确定");
	Button button2 = new Button("退出");
	boolean flag = false;
	Member member = null;

	public void start()
	{
		iniStage();
		function();
		new CloseButton(button2, stage).close();
	}

	private void iniStage()
	{
		title.setFont(Font.font("HeiTi", FontWeight.BOLD, FontPosture.REGULAR, 20));
		buttonMemNum.setSelected(true);
		buttonMemNum.setToggleGroup(tg);
		buttonTeleNum.setToggleGroup(tg);
		textField1.setPromptText("会员编号/电话号码");

		gridpane.add(title, 0, 0, 3, 1);
		gridpane.add(buttonMemNum, 2, 2);
		gridpane.add(buttonTeleNum, 2, 3);
		gridpane.add(textField1, 2, 4, 2, 1);
		gridpane.add(button1, 3, 5);
		gridpane.add(button2, 4, 5);

		gridpane.setVgap(10);
		gridpane.setHgap(10);
		gridpane.setPadding(new Insets(10, 5, 10, 5));
		gridpane.setStyle("-fx-background-color: FFFACD;");
		gridpane.setAlignment(Pos.CENTER);
		stage.setScene(scene);
		stage.setTitle("会员管理页面");
		stage.setWidth(350);
		stage.setHeight(250);
		stage.show();

	}

	public void function()
	{

		button1.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>()
		{

			@Override
			public void handle(MouseEvent arg0)
			{
				// flag = true;
				if (textField1.getText() == null)
					PopingWindowNonExist.getPopingWindow().initial();
				else
				{
					
					
					PopingWindowFindMem ppwf = new PopingWindowFindMem();

					if (buttonMemNum.isSelected() )
					{
						member = MemberManagement.findMemberMemNum(Integer.parseInt(textField1.getText()));
						

					} else if (buttonTeleNum.isSelected() )
					{
						member = MemberManagement.findMemberTeleNum(textField1.getText());
					} 
					
					if(member == null)
						PopingWindowNonExist.getPopingWindow().initial();
					else
					{
						stage.hide();
						ppwf.initial();
						ppwf.show(member);
					}

				}

			}
		});

	}

}
