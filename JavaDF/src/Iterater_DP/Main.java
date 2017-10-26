package Iterater_DP;

public class Main {
	public static void main(String[] args){
		BookShelf bookShelf = new BookShelf();
		bookShelf.appendBook(new Book("A book"));
		bookShelf.appendBook(new Book("B book"));
		bookShelf.appendBook(new Book("C book"));
		bookShelf.appendBook(new Book("D book"));
		bookShelf.appendBook(new Book("E book"));
		bookShelf.appendBook(new Book("F book"));
		bookShelf.appendBook(new Book("G book"));
		
		Iterators it = bookShelf.iterator();
		while(it.hasNext()){
			Book book = (Book) it.next();
			System.out.println(book.getName());
		}
	}
}
