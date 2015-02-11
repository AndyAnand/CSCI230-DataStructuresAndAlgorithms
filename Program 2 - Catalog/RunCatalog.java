package library;

public class RunCatalog {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		XMLToBookParser parser = null;
		try {
			parser = new XMLToBookParser("catalog.xml");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		SinglyLinkedList<Book> books = parser.retrieveBooks();
		
		
		try {
			books.addLast(new Book("aaaaa", "aaaaa", "aaaaa", 20.0f, new SimpleDateFormat("yyyy-mm-dd", Locale.ENGLISH).parse("2005-08-12"), "aaaaaaaaaaaaaaaaaaaaaaaaaa"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		BookToXMLParser parserBack = new BookToXMLParser("catalog.xml");
		parserBack.writeBooksInXML(books);
		*/
		
		//Catalog catalog = new Catalog("catalog.xml");
		//catalog.loadBooks();
		//catalog.removeABook(title)
		//System.out.println("Number of books in the catalog: "+catalog.removeABook("aaaaa"));
		//System.out.println("Number of books in the catalog: "+catalog.search("aaaaaa"));
		
		UI userInterface = new UI("catalog.xml");
		userInterface.run();
	}

}
