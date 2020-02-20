package view;

import java.util.List;
import java.util.Scanner;

import controller.BookHelper;
import model.bookList;

public class mainBookProgram 
{
	static Scanner in = new Scanner(System.in);
	static BookHelper bh = new BookHelper();

		public static void main(String[] args) 
		{
			boolean running = true;
			while (running == true) 
			{
				System.out.println("1 - Add an book");
				System.out.println("2 - Delete a book");
				System.out.println("3 - Edit a book");
				System.out.println("4 - View the list");
				System.out.println("5 - Exit the program");
				System.out.print("Your selection: ");
				int selection = in.nextInt();
				in.nextLine();

				if (selection == 1) 
				{
					addBook();
				} 
				else if (selection == 2) 
				{
					deleteBook();
				} 
				else if (selection == 3) 
				{
					editABook();
				} 
				else if (selection == 4) 
				{
					ListViewer();
				} 
				else 
				{
					bh.cleanUp();
					System.out.println();
					System.out.println("End of program   ");
					running = false;
				}
			}
		}
		
		
		private static void addBook() 
		{
			System.out.print("Enter a title: ");
			String title = in.nextLine();
			System.out.print("Enter an author's last name: ");
			String author = in.nextLine();
			System.out.print("Enter the release year: ");
			int year = in.nextInt();
			bookList Add = new bookList(title,author,year);
			bh.insertBook(Add);

		}

		private static void deleteBook() 
		{
			System.out.print("Enter the title to delete: ");
			String title = in.nextLine();
			System.out.print("Enter the author's last name: ");
			String author = in.nextLine();
			System.out.print("Enter the release year: ");
			int year = in.nextInt();
			bookList remove = new bookList(title,author,year);
			bh.removeBook(remove);

		}

		private static void editABook() 
		{
			System.out.println("Search for-- ");
			System.out.println("1 : Search by Title");
			System.out.println("2 : Search by Author's last name");
			System.out.println("3 : Search by Year released");
			int searchBy = in.nextInt();
			in.nextLine();
			List<bookList> foundItems;
			if (searchBy == 1) 
			{
				System.out.print("Enter the book title: ");
				String title = in.nextLine();
				foundItems=bh.searchForBookByTitle(title);
			} 
			else if(searchBy == 2)
			{
				System.out.print("Enter the author's last name: ");
				String name = in.nextLine();
				foundItems=bh.searchForBookByAuthor(name);
			}
			else
			{
				System.out.print("Enter the year: ");
				int yearReleased = in.nextInt();
				foundItems=bh.searchForBookByYear(yearReleased);
			}

			
			if (foundItems.isEmpty() == false) 
			{
				System.out.println("Results ID's.");
				for (bookList l : foundItems) 
				{
					System.out.println(l.getId() + " : " + l.toString());
				}
				System.out.print("Which ID to edit: ");
				int idToEdit = in.nextInt();

				bookList toEdit = bh.searchForBookById(idToEdit);
				System.out.println("Retrieved " + toEdit.getAuthor() + " author of " + toEdit.getTitle());
				System.out.println("1 : Update Title");
				System.out.println("2 : Update Author");
				System.out.println("3 : Update Year");
				int update = in.nextInt();
				in.nextLine();

				if (update == 1) 
				{
					System.out.print("New Title: ");
					String newTitle = in.nextLine();
					toEdit.setTitle(newTitle);
				} 
				if (update == 2) 
				{
					System.out.print("New Author: ");
					String newAuthor = in.nextLine();
					toEdit.setAuthor(newAuthor);
				}
				else if (update == 3) 
				{
					System.out.print("New Year: ");
					int newYear = in.nextInt();
					toEdit.setYear(newYear);
				}

				bh.updateBook(toEdit);
			} 
			else 
			{
				System.out.println("No results found");
			}
		}
		
		private static void ListViewer() 
		{
			List<bookList>allItems=bh.showAllItems();
			for(bookList item : allItems)
			{
				System.out.println(item.returnItemDetails());
			}
		}

	}
