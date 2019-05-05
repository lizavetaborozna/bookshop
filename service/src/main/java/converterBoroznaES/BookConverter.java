package converterBoroznaES;

import dtoBoroznaES.BookDTO;
import modelBoroznaES.Book;

import java.util.ArrayList;
import java.util.List;


public class BookConverter {
    public BookDTO bookToBookDTO(Book book) {
        BookDTO bookDTO = BookDTO.newBuilder()
                .idbook(book.getIdbook())
                .name(book.getName())
                .author(book.getAuthor())
                .genre(book.getGenre())
                .price(book.getPrice())
                .imageName(book.getImageName())
                .build();
        return bookDTO;
    }

    public Book bookDTOToBook(BookDTO bookDTO) {
        Book book = Book.newBuilder()
                .idbook(bookDTO.getIdbook())
                .name(bookDTO.getName())
                .author(bookDTO.getAuthor())
                .genre(bookDTO.getGenre())
                .price(bookDTO.getPrice())
                .imageName(bookDTO.getImageName())
                .build();
        return book;
    }

    public List<BookDTO> converterBookList(List<Book> bookList) {
        List<BookDTO> bookDTOList = new ArrayList<>();
        for (Book book : bookList) {
            bookDTOList.add(bookToBookDTO(book));
        }
        return bookDTOList;
    }
}
