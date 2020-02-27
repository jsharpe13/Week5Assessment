package view;

import java.util.ArrayList;
import java.util.List;

import controller.CheckOutListHelper;
import controller.PersonHelper;
import model.CheckOutList;
import model.Person;
import model.bookList;

public class ReadingTester 
{
	public static void main(String[] args)
	{
		Person Mara = new Person("Mara");
		
		CheckOutListHelper clh = new CheckOutListHelper();
		
		bookList tolkien1 = new bookList("The Hobbit", "Tolkien", 1937);
		bookList tolkien2 = new bookList("The two towers", "Tolkien", 1954);
		
		List<bookList>MarasBooks = new ArrayList<bookList>();
		MarasBooks.add(tolkien1);
		MarasBooks.add(tolkien2);
		
		CheckOutList MarasList = new CheckOutList("Mara's List", Mara);
		MarasList.setBookList(MarasBooks);
		
		clh.insertNewListDetails(MarasList);
		
		List<CheckOutList>allLists = clh.getLists();
		for(CheckOutList a: allLists)
		{
			System.out.println(a.toString());
		}
	}
}
