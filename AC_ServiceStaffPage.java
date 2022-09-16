package administrationpage;

import entity.ServiceStaff;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.geometry.HPos;
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

public abstract class AC_ServiceStaffPage
{
	ObservableList<ServiceStaff> list;
	Stage stage = new Stage();
	Text title = new Text("添加服务人员");
	Text text1 = new Text("账号");
    Text text2 = new Text("密码");
	Text text3 = new Text("姓名");
    Text text4 = new Text("性别");
    Text text5 = new Text("电话");
    Text text6 = new Text("身份证号");
    Text text7 = new Text("权限");
    
    TextField textField1 = new TextField(); 
    TextField textField2 = new TextField(); 
    TextField textField3 = new TextField(); 
    TextField textField4 = new TextField(); 
    TextField textField5 = new TextField(); 
    TextField textField6 = new TextField(); 
    TextField textField7 = new TextField(); 
    TextField textField8 = new TextField(); 
    TextField textField9 = new TextField();
    
    final ToggleGroup tg = new ToggleGroup();
    RadioButton rButton1 = new RadioButton("超级管家");
    RadioButton rButton2 = new RadioButton("生活管家");
    RadioButton rButton3 = new RadioButton("后勤管家");
    
    GridPane gridpane = new GridPane();
	Scene scene = new Scene(gridpane); 
	Button button1 = new Button("确定");
	Button button2 = new Button("退出");
	
	public AC_ServiceStaffPage(ObservableList<ServiceStaff> list)
	{
		this.list = list;
	}
	
	protected void iniStage()
	{
		   
		   title.setFont(Font.font("HeiTi", FontWeight.BOLD, FontPosture.REGULAR, 25));
		   textField7.setPromptText("例：万科城 1号楼 101");
		   textField8.setPromptText("例：001路");
		   textField9.setPromptText("老人姓名");
			rButton1.setSelected(true);
			rButton1.setToggleGroup(tg);
			rButton2.setToggleGroup(tg);
			rButton3.setToggleGroup(tg);
			textField1.setPrefWidth(120);
			textField2.setPrefWidth(120);
			textField3.setPrefWidth(120);
			textField4.setPrefWidth(120);
			textField5.setPrefWidth(120);
			textField7.setPrefWidth(100);
			textField9.setPrefWidth(25);
			textField8.setPrefWidth(4);
		//add title
			gridpane.add(title, 0, 0,3,1);
			
		//add text1
			gridpane.add(text1, 1, 1);
			gridpane.add(text2, 1, 2);
			gridpane.add(text3, 1, 3);
			gridpane.add(text4, 1, 4);
			gridpane.add(text5, 1, 5);
			gridpane.add(text6, 1, 6);
			gridpane.add(text7, 1, 7);

			
		//add text field and set prompt
			gridpane.add(textField1,2, 1,2,1);
			gridpane.add(textField2,2, 2,2,1);
			gridpane.add(textField3,2, 3,2,1);
			gridpane.add(textField4,2, 4,2,1);
			gridpane.add(textField5,2, 5,2,1);
			gridpane.add(textField6,2, 6,2,1);
			
			gridpane.add(rButton1, 2, 7,3,1);
			gridpane.add(rButton2, 2, 8,3,1);
			gridpane.add(rButton3, 2, 9,3,1);
			
			
			rButton1.selectedProperty().addListener(new ChangeListener<Boolean>()
			{

				@Override
				public void changed(ObservableValue<? extends Boolean> arg0, Boolean arg1, Boolean arg2)
				{
					gridpane.getChildren().removeAll(textField7,textField8,textField9);
				}
				
			});
			
			rButton2.selectedProperty().addListener(new ChangeListener<Boolean>()
			{

				@Override
				public void changed(ObservableValue<? extends Boolean> arg0, Boolean arg1, Boolean arg2)
				{
					//if(gridpane.getChildren().contains(textField8))
					gridpane.getChildren().removeAll(textField7,textField8,textField9);
					gridpane.add(textField9, 3, 8,1,1);
					gridpane.add(textField7, 4, 8,10,1);
					
				}
				
			});
			rButton3.selectedProperty().addListener(new ChangeListener<Boolean>()
			{

				@Override
				public void changed(ObservableValue<? extends Boolean> arg0, Boolean arg1, Boolean arg2)
				{
					//if(gridpane.getChildren().contains(textField7))
					gridpane.getChildren().removeAll(textField7,textField8,textField9);

					gridpane.add(textField8, 3, 9,1,1);
					
				}
				
			});

			
		//add buttons
			gridpane.add(button1,9, 10);
			gridpane.add(button2,10, 10);
			GridPane.setHalignment(button1, HPos.RIGHT);
			new CloseButton(button2, stage).close();
			
			gridpane.setStyle("-fx-background-color: FFF5EE;");
		    gridpane.setAlignment(Pos.TOP_CENTER);
		   
		    gridpane.setVgap(15);
		    gridpane.setHgap(5);
		    gridpane.setPadding(new Insets(20,25,10,25));
		    
		    stage.setScene(scene);
		    stage.setTitle("会员管理页面"); 
		    stage.setWidth(450);
		    stage.setHeight(500);    
		    stage.centerOnScreen();
		    stage.show();
	}
	
	
    public void start()
    {	
		iniStage();
//	    gridpane.setGridLinesVisible(true);   
	    new CloseButton(button2, stage).close();
	    addOrChange();

	}
    
    
    public Text getTitle()
    {
    	return title;
    }
    abstract public void addOrChange();
}
