package entity;

import java.util.Date;

public class Member extends Person
{
	private int MemNum;
	private Date BirthDate;
	private String TypeOfMember;
	private PersonCheckIn Contact;
	private String Note;

	
	public Member(String name, String gender, String teleNum, String iDNum, int memNum, Date birthDate,
			String typeOfMember, PersonCheckIn contact, String note)
	{
		super(name, gender, teleNum, iDNum);
		MemNum = memNum;
		BirthDate = birthDate;
		TypeOfMember = typeOfMember;
		Contact = contact;
		Note = note;
	}


	public Member(String name, String gender, String teleNum, String iDNum, int memNum, Date birthDate,
			String typeOfMember)
	{
		super(name, gender, teleNum, iDNum);
		MemNum = memNum;
		BirthDate = birthDate;
		TypeOfMember = typeOfMember;
		Contact = null;
		Note = "нч";
	}


	// getter and setter of member number
	public int getMemNum()
	{
		return MemNum;
	}

	public void setMemNum(int memNum)
	{
		MemNum = memNum;
	}

	// getter and setter of birth date
	public Date getBirthDate()
	{
		return BirthDate;
	}

	public void setBirthDate(Date birthDate)
	{
		BirthDate = birthDate;
	}

	// getter and setter of the type of member
	public String getTypeOfMember()
	{
		return TypeOfMember;
	}

	public void setTypeOfMember(String typeOfMember)
	{
		TypeOfMember = typeOfMember;
	}

	// getter and setter of the contact
	public PersonCheckIn getContact()
	{
		return Contact;
	}

	// getter and setter of the note of this member
	public void setContact(PersonCheckIn contact)
	{
		Contact = contact;
	}

	public String getNote()
	{
		return Note;
	}

	public void setNote(String note)
	{
		Note = note;
	}
	
}
