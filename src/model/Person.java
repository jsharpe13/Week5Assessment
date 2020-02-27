package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

//package and import statements
@Entity
@Table(name="person")
public class Person 
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="CARD_ID")
	private int CardId;
	@Column(name="NAME")
	private String PersonName;
	
	public Person()
	{
		super();
		//TODO Auto-generated constructor stub
	}
	public Person(int CardId, String PersonName)
	{
		super();
		this.CardId = CardId;
		this.PersonName = PersonName;
	}
	
	public Person(String PersonName)
	{
		super();
		this.PersonName= PersonName;
	}
	public int getId()
	{
		return CardId;
	}
	public void setId(int id)
	{
		CardId = id;
	}
	public String getPersonName()
	{
		return PersonName;
	}
	public void setPersonName(String Name)
	{
		PersonName = Name;
	}
	@Override
	public String toString()
	{
		return "Person[CardId=" + CardId +", PersonName=" + PersonName +"]";
	}
}
