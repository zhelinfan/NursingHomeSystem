package administrationpage;

import entity.Member;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public abstract class AC_MemberPage {
	
	ObservableList<Member> list;
	Stage stage = new Stage();
	Text title = new Text("添加会员");
    Text text1 = new Text("姓名");
    Text text2 = new Text("性别");
    Text text3 = new Text("电话");
    Text text4 = new Text("身份证号");
    Text text5 = new Text("出生日期");
    Text text6 = new Text("会员类型");
    Text text7 = new Text("联系人");
    Text text8 = new Text("备注");
    TextField textField1 = new TextField(); 
    TextField textField2 = new TextField(); 
    TextField textField3 = new TextField(); 
    TextField textField4 = new TextField(); 
    TextField textField5 = new TextField(); 
    TextField textField6 = new TextField(); 
    TextField textField7 = new TextField(); 
    TextField textField8 = new TextField(); 
    TextField textField9 = new TextField(); 
    TextField textField10 = new TextField(); 
    TextField textField11 = new TextField(); 
    GridPane gridpane = new GridPane();
	Scene scene = new Scene(gridpane); 
	Button button1 = new Button("确定");
	Button button2 = new Button("退出");
	
	public AC_MemberPage(ObservableList<Member> list)
	{
		this.list = list;
	}
	
	protected void iniStage()
	{
		   title.setFont(Font.font("HeiTi", FontWeight.BOLD, FontPosture.REGULAR, 25));
		   
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
			gridpane.add(text8, 1, 11);
			
		//add text field and set prompt
			gridpane.add(textField1,2, 1,4,1);
			gridpane.add(textField2,2, 2,4,1);
			gridpane.add(textField3,2, 3,4,1);
			gridpane.add(textField4,2, 4,4,1);
			gridpane.add(textField5,2, 5,4,1);
			gridpane.add(textField6,2, 6,4,1);
			gridpane.add(textField7,2, 7,4,1);
			gridpane.add(textField8,2, 8,4,1);
			gridpane.add(textField9,2, 9,4,1);
			gridpane.add(textField10,2, 10,4,1);
			gridpane.add(textField11,2, 11,4,1);
			
			textField5.setPromptText("例：2022-01-01");
			textField7.setPromptText("联系人姓名");
			textField8.setPromptText("联系人性别");
			textField9.setPromptText("联系人电话");
			textField10.setPromptText("联系人身份证号");
			
		//add buttons
			gridpane.add(button1,4, 12);
			gridpane.add(button2,5, 12);
			
			
			gridpane.setStyle("-fx-background-color: FFFACD;");
		    gridpane.setAlignment(Pos.TOP_CENTER);
		   
		    gridpane.setVgap(15);
		    gridpane.setHgap(10);
		    gridpane.setPadding(new Insets(40,25,10,0));
		    
		    stage.setScene(scene);
		    stage.setTitle("会员管理页面"); 
		    stage.setWidth(300);
		    stage.setHeight(600);    
		    stage.centerOnScreen();
		    stage.show();
	}
	
	
    public void start()
    {	
		iniStage();
	   // gridpane.setGridLinesVisible(true);   
	    new CloseButton(button2, stage).close();
	    addOrChange();

	}
    
    
    public Text getTitle()
    {
    	return title;
    }
    abstract public void addOrChange();
    
}
