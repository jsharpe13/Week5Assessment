package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.CheckOutList;
import model.Person;
import model.bookList;

/**
 * Servlet implementation class createNewListServlet
 */
@WebServlet("/createNewListServlet")
public class createNewListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public createNewListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		BookHelper bh = new BookHelper();
		String listName = request.getParameter("listName");
		System.out.println("List Name: " + listName);
		
		String PersonName = request.getParameter("PersonName");
		
		String[] selectedItems = request.getParameterValues("allItemsToAdd");
		List<bookList>selectedBooksInList = new ArrayList<bookList>();
		if(selectedItems != null && selectedItems.length > 0)
		{
			for(int i=0; i < selectedItems.length; i++)
			{
				System.out.println(selectedItems[i]);
				bookList b = bh.searchForBookById(Integer.parseInt(selectedItems[i]));
				selectedBooksInList.add(b);
			}
		}
		
		Person person = new Person(PersonName);
		CheckOutList nco = new CheckOutList(listName, person);
		nco.setBookList(selectedBooksInList);
		CheckOutListHelper coh = new CheckOutListHelper();
		coh.insertNewListDetails(nco);
		
		System.out.println("Success!");
		System.out.println(nco.toString());
		
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
