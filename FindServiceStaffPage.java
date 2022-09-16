package administrationpage;

import Management.ServiceStaffManagement;
import entity.ServiceStaff;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
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

public class FindServiceStaffPage
{
	Stage stage = new Stage();
	GridPane gridpane = new GridPane();
	Scene scene = new Scene(gridpane);
	Text title = new Text("查找用户是否存在");
	TextField textField1 = new TextField();
	TextField textField2 = new TextField();
	TextField textField3 = new TextField();
	final ToggleGroup tg = new ToggleGroup();
	RadioButton rb2 = new RadioButton("电话号码");
	RadioButton rb1 = new RadioButton("用户账号");
	Button button1 = new Button("确定");
	Button button2 = new Button("退出");

	ServiceStaff serviceStaff;
	ServiceStaffManagement SSM = ServiceStaffManagement.getServiceStaffManagement();
	public void start()
	{
		iniStage();
		function();
//		gridpane.setGridLinesVisible(true);
	}

	private void iniStage()
	{
		new CloseButton(button2, stage).close();
		
		title.setFont(Font.font("HeiTi", FontWeight.BOLD, FontPosture.REGULAR, 20));
		rb1.setToggleGroup(tg);
		rb2.setToggleGroup(tg);
		rb1.setSelected(true);
		textField1.setPromptText("电话号码/用户账号");


		gridpane.add(title, 0, 0, 3, 1);
		gridpane.add(rb1, 2, 1);
		gridpane.add(rb2, 2, 2);
		gridpane.add(button1, 2, 5);
		gridpane.add(button2, 3, 5);
		gridpane.add(textField1, 2, 3);
		GridPane.setHalignment(button1, HPos.RIGHT);
		
		gridpane.setVgap(10);
		gridpane.setHgap(10);
		gridpane.setPadding(new Insets(10, 5, 10, 5));
		gridpane.setStyle("-fx-background-color: FFF5EE;");
		gridpane.setAlignment(Pos.CENTER);
		stage.setScene(scene);
		stage.setTitle("用户管理页面");
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
					 PopingWindowFindSS ppwfss = new PopingWindowFindSS();

					if (rb1.isSelected())
					{
						serviceStaff = SSM.findServiceStaff5(Integer.parseInt(textField1.getText()));
					} else if (rb2.isSelected())
					{
						serviceStaff = SSM.findServiceStaff4(textField1.getText());
					} 
					
					if(serviceStaff != null)
					{
						ppwfss.show(serviceStaff);
						ppwfss.initial();
						stage.close();
					}
					else
					{
						PopingWindowNonExist.getPopingWindow().initial();
					}

				}

			}
		});

	}



}
