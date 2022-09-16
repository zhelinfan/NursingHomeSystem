package administrationpage;

import Management.MemberManagement;
import entity.Member;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;

public class RemoveMemberPage extends FindMemberPage
{
	ObservableList<Member> list;

	public RemoveMemberPage(ObservableList<Member> list)
	{
		this.list = list;

	}

	public void function()
	{

		button1.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>()
		{

			@Override
			public void handle(MouseEvent arg0)
			{
				if (textField1.getText() == null)
					PopingWindowNonExist.getPopingWindow().initial();
				else
				{
					Member member1 = MemberManagement.findMemberMemNum(Integer.parseInt(textField1.getText()));
					Member member2 = MemberManagement.findMemberTeleNum(textField1.getText());
					PopingWindowF_RMem ppwfr = new PopingWindowF_RMem();

					if (buttonMemNum.isSelected() && member1 != null)
					{
						ppwfr.initial();
						ppwfr.show(member1);
						stage.hide();
						removeinfor(member1, ppwfr);

					} else if (buttonTeleNum.isSelected() && member2 != null)
					{
						ppwfr.initial();
						ppwfr.show(member2);
						stage.hide();
						removeinfor(member2, ppwfr);

					} else
					{
						PopingWindowNonExist.getPopingWindow().initial();
					}

				}

			}
		});
		MemberManagement.getMemberManagement().save();

	}

	private void removeinfor(Member member, PopingWindowF_RMem ppwfr)
	{
		Button buttonppwfc = ppwfr.getButton();

		buttonppwfc.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>()
		{

			public void handle(MouseEvent arg0)
			{
				ppwfr.hide();
				list.remove(member);
				MemberManagement.getMemberManagement().removeMember(member);
				MemberManagement.getMemberManagement().delete();
				MemberManagement.getMemberManagement().save();
				new PopingWindowSuccess().initial();
			}
			
		});
		
	}

}
