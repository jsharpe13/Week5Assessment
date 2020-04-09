package model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="check_out_list")
public class CheckOutList 
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="LIST_ID")
	private int id;
	@Column(name="LIST_NAME")
	private String listName;
	@ManyToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name="CARD_ID")
	private Person person;
	@OneToMany(cascade=CascadeType.MERGE, fetch=FetchType.EAGER)
		@JoinTable
		(
			name="books_on_list",
			joinColumns= {@JoinColumn(name="LIST_ID", referencedColumnName="LIST_ID") },
			inverseJoinColumns= {@JoinColumn(name="BOOK_ID", referencedColumnName="ID", unique=true) }
		)
	private List<bookList>bookList;
	
	public CheckOutList()
	{
		super();
	}
	public CheckOutList(int id, String listName, Person person, List<bookList>bookList)
	{
		super();
		this.id = id;
		this.listName = listName;
		this.person = person;
		this.bookList = bookList;
	}
	public CheckOutList(String listName, Person person, List<bookList>bookList)
	{
		super();
		this.listName = listName;
		this.person = person;
		this.bookList = bookList;
	}
	public CheckOutList(String listName, Person person)
	{
		super();
		this.listName = listName;
		this.person = person;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getListName() {
		return listName;
	}
	public void setListName(String listName) {
		this.listName = listName;
	}
	public Person getPerson() {
		return person;
	}
	public void setPerson(Person person) {
		this.person = person;
	}
	public List<bookList> getBookList() {
		return bookList;
	}
	public void setBookList(List<bookList> bookList) {
		this.bookList = bookList;
	}
	@Override
	public String toString() {
		return "CheckOutList [id=" + id + ", listName=" + listName + ", person=" + person + ", bookList=" + bookList
				+ "]";
	}
	
}
