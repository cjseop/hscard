package Iterater_DP;

public class BookShelfIterator implements Iterators {
private BookShelf bookshelf;
private int index;

public BookShelfIterator(BookShelf bookShelf){
	this.bookshelf = bookShelf;
	this.index = 0;
}
	@Override
	public boolean hasNext() {
		if(index < bookshelf.getLength()){
			return true;
		}else{
			return false;
		}
	}

	@Override
	public Object next() {
		Book book = bookshelf.getBookAt(index);
		index++;
		return book;
	}

}
