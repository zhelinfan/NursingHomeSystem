package administrationpage;

import java.util.Date;

import Management.LivingManagement;
import Management.MemberManagement;
import entity.Member;
import entity.Person;
import entity.PersonCheckIn;
import javafx.collections.ObservableList;
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

public class ChangeMemberPage extends AC_MemberPage
{	
	Stage stage1 = new Stage();
	GridPane gridpane1 = new GridPane();
	Scene scene1 = new Scene(gridpane1);
	Text title1 = new Text("查找会员是否存在");
	Text text9 = new Text("提示：先查找会员存在与否后修改");
	TextField textField12 = new TextField();
	final ToggleGroup tg1 = new ToggleGroup();
	RadioButton buttonMemNum1 = new RadioButton("会员编号");
	RadioButton buttonTeleNum1 = new RadioButton("电话号码");
	Button button3 = new Button("确定");
	Button button4 = new Button("退出");
    
	Member member = null;
	MemberManagement m = MemberManagement.getMemberManagement();
	LivingManagement LM = LivingManagement.getLivingManagement();
	LivingManagementPage LMP = LivingManagementPage.getLivingManagementPage();
	public ChangeMemberPage(ObservableList<Member> list)
	{
		super(list);
		getTitle().setText("修改信息");
		
	}



	public void start()
	{
		iniStage1();
		new CloseButton(button2, stage).close();
		
		addOrChange();


	}
    
	@Override
	public void addOrChange()
	{
		button3.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>()
		{

			@Override
			public void handle(MouseEvent arg0)
			{
				if (textField11.getText() == null)
					PopingWindowNonExist.getPopingWindow().initial();
				else
				{
					
					
					PopingWindowF_CMem ppwfc = new PopingWindowF_CMem();
					if (buttonMemNum1.isSelected())
					{
						member = MemberManagement.findMemberMemNum(Integer.parseInt(textField12.getText()));
						
					} else if (buttonTeleNum1.isSelected())
					{
						member = MemberManagement.findMemberTeleNum(textField12.getText());	
					} 
					if(member == null)
					{
						PopingWindowNonExist.getPopingWindow().initial();
					}
					else
					{
						ppwfc.initial();
						ppwfc.show(member);
						stage1.hide();
						changeinfor(member, ppwfc);
					}

				}

			}
		});

	}
	private void changeinfor(Member member,PopingWindowF_CMem ppwfc)
	{
		Button buttonppwfc = ppwfc.getButton();

		buttonppwfc.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>()
		{
			public void handle(MouseEvent arg0)
			{
				ppwfc.hide();
				iniStage();
				textField1.setText(member.getName());
				textField2.setText(member.getGender());
				textField3.setText(member.getTeleNum());
				textField4.setText(member.getIDNum());
				textField5.setText(member.getBirthDate().toString());
				textField6.setText(member.getTypeOfMember());
				textField7.setText(member.getContact().getName());
				textField8.setText(member.getContact().getGender());
				textField9.setText(member.getContact().getTeleNum());
				textField10.setText(member.getContact().getIDNum());
				textField11.setText(member.getNote());
				
				button1.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>()
						{

							@Override
							public void handle(MouseEvent arg0)
							{
								int index = list.indexOf(member);
		
								
								if(!textField1.getText().equals(member.getName()))
									   m.changeName(member,textField1.getText());
								if(!textField2.getText().equals(member.getGender()))
									   m.changeGender(member, textField2.getText());
								if(!textField3.getText().equals(member.getTeleNum()))
									   m.changeTeleNum(member, textField3.getText());
								if(!textField4.getText().equals(member.getIDNum()))
									   m.changeID(member, textField4.getText());
								if(!textField5.getText().equals(member.getBirthDate().toString()))
									   m.changeBirthDate(member,new Date(textField5.getText()));
								if(!textField6.getText().equals(member.getTypeOfMember()))
									   m.changeTypeOfMember(member, textField6.getText());
								if(!textField7.getText().equals(member.getContact().getName())
									||!textField8.getText().equals(member.getContact().getGender())
									||!textField9.getText().equals(member.getContact().getTeleNum())
									||!textField10.getText().equals(member.getContact().getIDNum()))
									  
									   m.changeContact(member,new PersonCheckIn(textField7.getText(),textField8.getText(),
											                             textField9.getText(),textField10.getText()));
								if(!textField11.getText().equals(member.getNote()))
									   member.setNote(textField11.getText());
								
								list.set(index, member);
								m.save();
								LM.changeMem(member);
								LM.save();
								
								stage.hide();
								new PopingWindowSuccess().initial();
							}
					
						});
			}

		});

	}
	private void iniStage1() {
		title1.setFont(Font.font("HeiTi", FontWeight.BOLD, FontPosture.REGULAR, 20));
		buttonMemNum1.setSelected(true);
		buttonMemNum1.setToggleGroup(tg1);
		buttonTeleNum1.setToggleGroup(tg1);
		textField12.setPromptText("会员编号/电话号码");
		 new CloseButton(button4, stage1).close();
		
		gridpane1.add(title1, 0, 0, 4, 1);
		gridpane1.add(text9, 1, 1,2,1);
		gridpane1.add(buttonMemNum1, 2, 2);
		gridpane1.add(buttonTeleNum1, 2, 3);
		gridpane1.add(textField12, 2, 4, 2, 1);
		gridpane1.add(button3, 3, 5);
		gridpane1.add(button4, 4, 5);

		gridpane1.setVgap(10);
		gridpane1.setHgap(10);
		gridpane1.setPadding(new Insets(10, 5, 10, 5));
		gridpane1.setStyle("-fx-background-color: FFFACD;");
		gridpane1.setAlignment(Pos.CENTER);
		stage1.setScene(scene1);
		stage1.setTitle("会员管理页面");
		stage1.setWidth(350);
		stage1.setHeight(250);
		stage1.show();
		
//		gridpane1.setGridLinesVisible(true);

	}
}
