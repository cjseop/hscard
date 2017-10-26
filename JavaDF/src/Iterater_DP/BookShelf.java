package Iterater_DP;
import java.util.ArrayList;
import java.util.List;

public class BookShelf implements Aggregate {
//private Book[] books;
private int last = 0;
private List<Book> bookList; 

public BookShelf(){
	//this.books = new Book[maxsize];
	this.bookList = new ArrayList<Book>();
}

public Book getBookAt(int index){
	//return books[index];
	return bookList.get(index);
}

public void appendBook(Book book){
	//this.books[last] = book;
	bookList.add(book);
	last++;
}

public int getLength(){
	return last;
}

@Override
public Iterators iterator() {	
	return new BookShelfIterator(this);
}


}
