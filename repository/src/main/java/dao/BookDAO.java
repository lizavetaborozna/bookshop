package dao;

import model.Book;

import java.util.List;

public interface BookDAO {
    List<Book> getBooksList();

    List<Book> getBooksListSort();

    List<Book> getBooksListSale();

    Book getBooksListSearch(String name);

    Book getBookByImageName(String bookImageName);

    Book getBookByID(Integer id);

    Double getBookRoman();

    Double getBookDrama();

    Double getBookScience();
    boolean addBook(Book infoBook);
}
