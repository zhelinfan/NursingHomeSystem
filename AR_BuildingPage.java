package administrationpage;

import Management.BuildingManagement;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public abstract class AR_BuildingPage
{
	Stage stage = new Stage();
	GridPane gridpane = new GridPane();
	Scene scene = new Scene(gridpane); 
	Button button1 = new Button("确定");
	Button button2 = new Button("退出");
	Text title = new Text("新增结点");
	Text text1 = new Text("楼盘");
    Text text2 = new Text("楼号");
	Text text3 = new Text("房间号");
    Text text4 = new Text("房间类型");
    Text text5 = new Text("房间状态");
	TextField textField1 = new TextField(); 
    TextField textField2 = new TextField(); 
    TextField textField3 = new TextField(); 
    TextField textField4 = new TextField(); 
    TextField textField5 = new TextField(); 
	
	final ToggleGroup tg = new ToggleGroup();
	RadioButton rb1 = new RadioButton("楼盘");
	RadioButton rb2 = new RadioButton("楼房");
	RadioButton rb3 = new RadioButton("房屋");
	
	BuildingManagement BM = BuildingManagement.getBuildingManagement();
	BuildingManagementPage BMP = BuildingManagementPage.getBuildingManagementPage();
	

	 
	protected void iniStage()
	{
		   title.setFont(Font.font("HeiTi", FontWeight.BOLD, FontPosture.REGULAR, 25));
		
		   rb1.setToggleGroup(tg);
		   rb2.setToggleGroup(tg);
		   rb3.setToggleGroup(tg);
		   textField1.setPrefSize(100, 10);
		   textField2.setPrefSize(100, 10);
		   textField3.setPrefSize(100, 10);
		   textField4.setPrefSize(100, 10);
		   textField5.setPrefSize(100, 10);
		//add title
			gridpane.add(title, 0, 0,3,1);
			
		//add text1
			gridpane.add(rb1, 1, 1);
			gridpane.add(rb2, 2, 1);
			gridpane.add(rb3, 3, 1);
			
		//add text field and set prompt

			
		//add buttons
			gridpane.add(button1,4, 7);
			gridpane.add(button2,5, 7);
			
			
			gridpane.setStyle("-fx-background-color: CAE1FF;");
		    gridpane.setAlignment(Pos.TOP_CENTER);
		   
		    gridpane.setVgap(10);
		    gridpane.setHgap(12);
		    gridpane.setPadding(new Insets(20,20,10,10));
		    
		    stage.setScene(scene);
		    stage.setTitle("会员管理页面"); 
		    stage.setWidth(350);
		    stage.setHeight(350);    
		    stage.centerOnScreen();
		    stage.show();
		    
		   
		   // gridpane.setGridLinesVisible(true);
	}

	public void start()
	{
		iniStage();
		function();
		new CloseButton(button2, stage).close();
		
	}
	public void function()
	{
		 rb1();
		 rb2();
		 rb3();
		  
	}
	private void rb1()
	{
		rb1.selectedProperty().addListener(new ChangeListener<Boolean>()
		{	
			@Override
			public void changed(ObservableValue<? extends Boolean> arg0, Boolean arg1, Boolean arg2)
			{
				gridpane.getChildren().removeAll(text1,text2,text3,text4,text5,textField1,textField2,textField3,textField4,textField5);
				gridpane.add(text1, 1, 2);
				gridpane.add(textField1, 2, 2,2,1);
				
				AR_Building();				
			}
			
		});
	}
	private void rb2()
	{
		rb2.selectedProperty().addListener(new ChangeListener<Boolean>()
		{

			@Override
			public void changed(ObservableValue<? extends Boolean> arg0, Boolean arg1, Boolean arg2)
			{

				gridpane.getChildren().removeAll(text1,text2,text3,text4,text5,textField1,textField2,textField3,textField4,textField5);
				gridpane.add(text1, 1, 2);
				gridpane.add(textField1, 2, 2,2,1);
				gridpane.add(text2, 1, 3);
				gridpane.add(textField2, 2, 3,2,1);
				
				AR_House();
			}
			
		});
	}
//	private void rb3()
//	{
//		  rb3.selectedProperty().addListener(new ChangeListener<Boolean>()
//			{
//
//				@Override
//				public void changed(ObservableValue<? extends Boolean> arg0, Boolean arg1, Boolean arg2)
//				{
//
//					gridpane.getChildren().removeAll(text1,text2,text3,text4,text5,textField1,textField2,textField3,textField4,textField5);
//					gridpane.add(text1, 1, 2);
//					gridpane.add(textField1, 2, 2,2,1);
//					gridpane.add(text2, 1, 3);
//					gridpane.add(textField2, 2, 3,2,1);
//					gridpane.add(text3, 1, 4);
//					gridpane.add(textField3, 2, 4,2,1);
//					gridpane.add(text4, 1, 5);
//					gridpane.add(textField4, 2, 5,2,1);
//					gridpane.add(text5, 1, 6);
//					gridpane.add(textField5, 2, 6,2,1);
//					textField5.setText("未售出");
//					textField5.setEditable(false);
//					 
//					AR_Room();
//				}
//				
//			});
//	}
	public Text getTile()
	{
		return title;
	}
	abstract public void AR_Building();
	abstract public void AR_House();
	abstract public void AR_Room();
	abstract protected void rb3();
}
