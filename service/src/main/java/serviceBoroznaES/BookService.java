package serviceBoroznaES;

import dtoBoroznaES.BookDTO;

import java.util.List;

public interface BookService {
    List<BookDTO> getBooks();
    List<BookDTO> getBooksSort();
    List<BookDTO> getBooksSale();
    BookDTO getBooksSearch(String name);
    List<Double> getSum(List<BookDTO> list);
    List<String> getCategory(List<BookDTO> list);
    BookDTO getBookByImageName(String imageName);
    void addBook(BookDTO bookDTO);
}
