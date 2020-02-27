package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.CheckOutList;
import model.bookList;

/**
 * Servlet implementation class listNavigationServlet
 */
@WebServlet("/listNavigationServlet")
public class listNavigationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public listNavigationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		CheckOutListHelper coh = new CheckOutListHelper();
		String act = request.getParameter("doThisToItem");
		
		if(act == null)
		{
			getServletContext().getRequestDispatcher("/viewAllListsServlet").forward(request, response);
		}
		else if(act.equals("delete"))
		{
			try
			{
				Integer tempId = Integer.parseInt(request.getParameter("id"));
				CheckOutList listToDelete = coh.searchForListById(tempId);
				coh.deleteItem(listToDelete);
			}
			catch(NumberFormatException e)
			{
				System.out.println("Forgot to click a button");
			}
			finally
			{
				getServletContext().getRequestDispatcher("/viewAllListsServlet").forward(request, response);
			}
		}
		else if(act.equals("edit"))
		{
			try
			{
				Integer tempId = Integer.parseInt(request.getParameter("id"));
				CheckOutList listToEdit = coh.searchForListById(tempId);
				BookHelper bh = new BookHelper();
				List<bookList>allItems = bh.showAllItems();
				List<bookList>currentListItems = listToEdit.getBookList();
				
				System.out.println("---New Items---");
				for(int i = 0; i < allItems.size(); i++)
				{
					for(int j = 0; j < currentListItems.size(); j++)
					{
						if(allItems.get(i).getId() == currentListItems.get(j).getId())
						{
							allItems.remove(i);
						}
					}
				}
				
				request.setAttribute("listToEdit", listToEdit);
				request.setAttribute("allItemsToAdd", allItems);
				getServletContext().getRequestDispatcher("/edit-list.jsp").forward(request, response);
			}
			catch(NumberFormatException e)
			{
				getServletContext().getRequestDispatcher("/viewAllListsServlet").forward(request, response);
			}
		}
		else if(act.equals("add"))
		{
			getServletContext().getRequestDispatcher("/addBooksForListServlet").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
