package administrationpage;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import Management.MemberManagement;
import entity.Member;
import entity.Person;
import entity.PersonCheckIn;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class AddMemberPage extends AC_MemberPage{

	public AddMemberPage(ObservableList<Member> list) {
		super(list);
	}

	public void addOrChange()
	{
		int orginsize = list.size();
		
		
		button1.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {

				@Override
				public void handle(MouseEvent arg0) {
					Date date = null;
					try {
						date = new SimpleDateFormat("yyyy-MM-dd").parse(textField5.getText());
					} catch (ParseException e) {
						
						e.printStackTrace();
					}
					 Member member = new Member(textField1.getText(), textField2.getText(), textField3.getText(), textField4.getText(),
							                   list.get(orginsize-1).getMemNum()+1, date , textField6.getText(),
							                   new PersonCheckIn(textField7.getText(),textField8.getText(),textField9.getText(),textField10.getText()) 
							                   , textField11.getText());
					
					 MemberManagement m = MemberManagement.getMemberManagement();
					if(m.addMember(member))
					{
						m.save();
						list.add(member);
					}
					else
						PopingWindowExist.getPopingWindow();
						stage.close();
				}
				
		    });
	}
}
