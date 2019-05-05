package serviceBoroznaES;

import converterBoroznaES.BookConverter;
import daoBoroznaES.BookDAO;
import daoImplBoroznaES.BookDaoImpl;
import dtoBoroznaES.BookDTO;

import java.util.ArrayList;
import java.util.List;

public class BookServiceImpl implements BookService {
    private static BookServiceImpl instance;

    private BookServiceImpl() {
    }

    public static BookServiceImpl getInstance() {
        if (instance == null) {
            instance = new BookServiceImpl();
        }
        return instance;
    }

    private BookDAO bookDAO = BookDaoImpl.getInstance();
    private BookConverter bookConverter = new BookConverter();

    @Override
    public List<BookDTO> getBooks() {
        return bookConverter.converterBookList(bookDAO.getBooksList());
    }

    @Override
    public List<BookDTO> getBooksSort() {
        return bookConverter.converterBookList(bookDAO.getBooksListSort());
    }

    @Override
    public List<BookDTO> getBooksSale() {
        return bookConverter.converterBookList(bookDAO.getBooksListSale());
    }

    @Override
    public BookDTO getBooksSearch(String name) {
        return bookConverter.bookToBookDTO(bookDAO.getBooksListSearch(name));
    }

    @Override
    public List<Double> getSum(List<BookDTO> list) {
        Double sum1=bookDAO.getBookRoman();
        Double sum2=bookDAO.getBookDrama();
        Double sum3=bookDAO.getBookScience();
        List<Double> sums=new ArrayList<>();
        sums.add(sum1);
        sums.add(sum2);
        sums.add(sum3);
        System.out.println(sums.toString());
        return sums;
    }

    @Override
    public List<String> getCategory(List<BookDTO> list) {
        List<String> categories = new ArrayList<>();
        for (int i = 0; i <list.size() ; i++) {
            categories.add(list.get(i).getGenre());
        }
        System.out.println(categories.toString());
        return categories;
    }

    @Override
    public BookDTO getBookByImageName(String imageName) {
        return bookConverter.bookToBookDTO(bookDAO.getBookByImageName(imageName));
    }

    @Override
    public void addBook(BookDTO bookDTO) {
            bookDAO.addBook(bookConverter.bookDTOToBook(bookDTO));
        }
}
