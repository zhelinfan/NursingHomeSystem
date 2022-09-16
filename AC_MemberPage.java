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
	Text title = new Text("��ӻ�Ա");
    Text text1 = new Text("����");
    Text text2 = new Text("�Ա�");
    Text text3 = new Text("�绰");
    Text text4 = new Text("���֤��");
    Text text5 = new Text("��������");
    Text text6 = new Text("��Ա����");
    Text text7 = new Text("��ϵ��");
    Text text8 = new Text("��ע");
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
	Button button1 = new Button("ȷ��");
	Button button2 = new Button("�˳�");
	
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
			
			textField5.setPromptText("����2022-01-01");
			textField7.setPromptText("��ϵ������");
			textField8.setPromptText("��ϵ���Ա�");
			textField9.setPromptText("��ϵ�˵绰");
			textField10.setPromptText("��ϵ�����֤��");
			
		//add buttons
			gridpane.add(button1,4, 12);
			gridpane.add(button2,5, 12);
			
			
			gridpane.setStyle("-fx-background-color: FFFACD;");
		    gridpane.setAlignment(Pos.TOP_CENTER);
		   
		    gridpane.setVgap(15);
		    gridpane.setHgap(10);
		    gridpane.setPadding(new Insets(40,25,10,0));
		    
		    stage.setScene(scene);
		    stage.setTitle("��Ա����ҳ��"); 
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
