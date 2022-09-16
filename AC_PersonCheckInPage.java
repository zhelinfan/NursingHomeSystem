package administrationpage;

import entity.PersonCheckIn;
import javafx.collections.ObservableList;
import javafx.geometry.HPos;
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

public abstract class AC_PersonCheckInPage
{
	ObservableList<PersonCheckIn> list;
	Stage stage = new Stage();
	Text title = new Text("�û��Ǽ�");
    Text text1 = new Text("����");
    Text text2 = new Text("�Ա�");
    Text text3 = new Text("�绰");
    Text text4 = new Text("���֤��");
    Text text5 = new Text("��ϵ��Ա���");
    Text text6 = new Text("��ϵ�����Ա��");
    Text text7 = new Text("��ס¥��");
    Text text8 = new Text("��ס¥��");
    Text text9 = new Text("��ס����");
    Text text10 = new Text("��ס��ʼʱ��");
    Text text11 = new Text("��ס����ʱ��");
    Text text12 = new Text("��ס����");
    
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
    TextField textField12 = new TextField(); 
    GridPane gridpane = new GridPane();
	Scene scene = new Scene(gridpane); 
	Button button1 = new Button("ȷ��");
	Button button2 = new Button("�˳�");
	
	public AC_PersonCheckInPage(ObservableList<PersonCheckIn> list)
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
			gridpane.add(text7, 5, 1);
			gridpane.add(text8, 5, 2);
			gridpane.add(text9, 5, 3);
			gridpane.add(text10, 5, 4);
			gridpane.add(text11, 5, 5);
			gridpane.add(text12, 5, 6);
		//add text field and set prompt
			gridpane.add(textField1,2, 1,2,1);
			gridpane.add(textField2,2, 2,2,1);
			gridpane.add(textField3,2, 3,2,1);
			gridpane.add(textField4,2, 4,2,1);
			gridpane.add(textField5,2, 5,2,1);
			gridpane.add(textField6,2, 6,2,1);
			gridpane.add(textField7,6, 1,2,1);
			gridpane.add(textField8,6, 2,2,1);
			gridpane.add(textField9,6, 3,2,1);
			gridpane.add(textField10,6, 4,2,1);
			gridpane.add(textField11,6, 5,2,1);
			gridpane.add(textField12,6, 6,2,1);
			textField7.setPrefSize(120, 15);
			textField8.setPrefSize(120, 15);
			textField9.setPrefSize(120, 15);
			textField10.setPrefSize(120, 15);
			textField11.setPrefSize(120, 15);
			textField12.setPrefSize(120, 15);

			
		//add buttons
			gridpane.add(button1,7, 8);
			gridpane.add(button2,7, 8);
			GridPane.setHalignment(button2, HPos.RIGHT);
			new CloseButton(button2, stage).close();
			
			gridpane.setStyle("-fx-background-color: F0FFF0;");
		    gridpane.setAlignment(Pos.TOP_CENTER);
		   
		    gridpane.setVgap(15);
		    gridpane.setHgap(10);
		    gridpane.setPadding(new Insets(40,25,10,25));
		    
		    stage.setScene(scene);
		    stage.setTitle("�û�����ҳ��"); 
		    stage.setWidth(500);
		    stage.setHeight(450);    
		    stage.centerOnScreen();
		    stage.show();
	}
	
	
    public void start()
    {	
		iniStage();
//	   gridpane.setGridLinesVisible(true);   

	    addOrChange();

	}
    
    
    public Text getTitle()
    {
    	return title;
    }
    abstract public void addOrChange();
}
