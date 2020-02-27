package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.NoResultException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.CheckOutList;
import model.Person;
import model.bookList;

/**
 * Servlet implementation class editExistingListServlet
 */
@WebServlet("/editExistingListServlet")
public class editExistingListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public editExistingListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		CheckOutListHelper coh = new CheckOutListHelper();
		BookHelper bh = new BookHelper();
		PersonHelper ph = new PersonHelper();
		
		int idToEdit = Integer.parseInt(request.getParameter("id"));
		CheckOutList toEdit = coh.searchForListById(idToEdit);
		
		String listName = request.getParameter("listName");
		System.out.println("List Name: " + listName);
		toEdit.setListName(listName);
		
		String PersonName = request.getParameter("PersonName");
		Person person;
		try
		{
			person = ph.searchForPersonByName(PersonName);
		}
		catch(NoResultException ex)
		{
			person = new Person(PersonName);
		}
		catch(Exception ex)
		{
			person = new Person(PersonName);
		}
		
		toEdit.setPerson(person);
		
		List<bookList>previousListOfItems = toEdit.getBookList();
		
		String[] selectedItems = request.getParameterValues("itemsToAdd");
		List<bookList>selectedItemsInList = new ArrayList<bookList>();
		
		if(selectedItems !=null && selectedItems.length > 0)
		{
			for(int i = 0; i < selectedItems.length; i++)
			{
				System.out.println(selectedItems[i]);
				bookList b = bh.searchForBookById(Integer.parseInt(selectedItems[i]));
				selectedItemsInList.add(b);
			}
			
			previousListOfItems.addAll(selectedItemsInList);
		}
		
		toEdit.setBookList(previousListOfItems);
		
		coh.updateList(toEdit);
		
		System.out.println("Success!");
		System.out.println(toEdit.toString());
		
		getServletContext().getRequestDispatcher("/viewAllListsServlet").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
