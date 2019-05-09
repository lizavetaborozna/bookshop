package daoImplBoroznaES;

import configBoroznaES.ConnectionManager;
import daoBoroznaES.BookDAO;
import modelBoroznaES.Book;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookDaoImpl implements BookDAO {
    private static BookDaoImpl instance;

    private BookDaoImpl() {
    }

    public static BookDaoImpl getInstance() {
        if (instance == null) {
            instance = new BookDaoImpl();
        }
        return instance;
    }

    private ConnectionManager connectionManager = ConnectionManager.getInstance();

    @Override
    public List<Book> getBooksList() {
        List<Book> books = new ArrayList<>();
        Connection connection = null;
        try {
            connection = connectionManager.getConnection();
            if (connection != null) {
                try (PreparedStatement statement = connection.prepareStatement(
                        "SELECT * FROM book")) {
                    ResultSet resultSet = statement.executeQuery();
                    while (resultSet.next()) {
                        books.add(Book.newBuilder()
                                .idbook(resultSet.getInt("idbook"))
                                .name(resultSet.getString("name"))
                                .author(resultSet.getString("author"))
                                .genre(resultSet.getString("genre"))
                                .price(resultSet.getDouble("price"))
                                .imageName(resultSet.getString("imageName"))
                                .build()
                        );
                    }
                } catch (SQLException e) {
                    System.out.println(e.getMessage());
                    e.printStackTrace();
                }
                return books;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
        return null;
    }

    @Override
    public List<Book> getBooksListSort() {
        List<Book> books = new ArrayList<>();
        Connection connection = null;
        try {
            connection = connectionManager.getConnection();
            if (connection != null) {
                try (PreparedStatement statement = connection.prepareStatement(
                        "SELECT * FROM book order by price")) {
                    ResultSet resultSet = statement.executeQuery();
                    while (resultSet.next()) {
                        books.add(Book.newBuilder()
                                .idbook(resultSet.getInt("idbook"))
                                .name(resultSet.getString("name"))
                                .author(resultSet.getString("author"))
                                .genre(resultSet.getString("genre"))
                                .price(resultSet.getDouble("price"))
                                .imageName(resultSet.getString("imageName"))
                                .build()
                        );
                    }
                } catch (SQLException e) {
                    System.out.println(e.getMessage());
                    e.printStackTrace();
                }
                return books;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
        return null;
    }

//    @Override
//    public List<Book> getBooksListSale() {
//        List<Book> books = new ArrayList<>();
//        Connection connection = null;
//        try {
//            connection = connectionManager.getConnection();
//            if (connection != null) {
//                try (PreparedStatement statement = connection.prepareStatement(
//                        "SELECT * FROM book  order by price ASC limit 2")) {
//                    ResultSet resultSet = statement.executeQuery();
//                    while (resultSet.next()) {
//                        books.add(Book.newBuilder()
//                                .idbook(resultSet.getInt("idbook"))
//                                .name(resultSet.getString("name"))
//                                .author(resultSet.getString("author"))
//                                .genre(resultSet.getString("genre"))
//                                .price(resultSet.getDouble("price"))
//                                .imageName(resultSet.getString("imageName"))
//                                .build()
//                        );
//                    }
//                } catch (SQLException e) {
//                    System.out.println(e.getMessage());
//                    e.printStackTrace();
//                }
//                return books;
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } finally {
//            if (connection != null) {
//                try {
//                    connection.close();
//                } catch (SQLException e) {
//                    System.out.println(e.getMessage());
//                }
//            }
//        }
//        return null;
//    }
@Override
public List <Book> getBooksListSale() {
    List<Book> books = new ArrayList<>();
    Connection connection = null;
    try {
        connection = connectionManager.getConnection();
        if (connection != null) {
            try (PreparedStatement statement = connection.prepareStatement(
                    "SELECT * FROM book  order by price DESC limit 1")) {
                ResultSet resultSet = statement.executeQuery();
                while (resultSet.next()) {
                   books.add(Book.newBuilder()
                            .idbook(resultSet.getInt("idbook"))
                            .name(resultSet.getString("name"))
                            .author(resultSet.getString("author"))
                            .genre(resultSet.getString("genre"))
                            .price(resultSet.getDouble("price"))
                            .imageName(resultSet.getString("imageName"))
                            .build());
                }
            } catch (SQLException e) {
                System.out.println(e.getMessage());
                e.printStackTrace();
            }
            return books;
        }
    } catch (SQLException e) {
        e.printStackTrace();
    } finally {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
    }
    return null;
}
    @Override
    public Book getBooksListSearch(String name) {
        Connection connection = null;
        try {
            connection = connectionManager.getConnection();
            if (connection != null) {
                try (PreparedStatement statement = connection.prepareStatement(
                        "SELECT * FROM book  where name=?")) {
                    statement.setString(1, name);
                    ResultSet resultSet = statement.executeQuery();
                    if (resultSet.next()) {
                        Book book = Book.newBuilder()
                                .idbook(resultSet.getInt("idbook"))
                                .name(resultSet.getString("name"))
                                .author(resultSet.getString("author"))
                                .genre(resultSet.getString("genre"))
                                .price(resultSet.getDouble("price"))
                                .imageName(resultSet.getString("imageName"))
                                .build();
                        System.out.println(book.toString());
                        return book;
                    }
                } catch (SQLException e) {
                    System.out.println(e.getMessage());
                    e.printStackTrace();
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
        return null;
    }


    @Override
    public Book getBookByImageName(String bookImageName) {
        Connection connection = null;
        try {
            connection = connectionManager.getConnection();
            if (connection != null) {
                try (PreparedStatement statement = connection.prepareStatement(
                        "SELECT * FROM book WHERE imageName=?")) {
                    statement.setString(1, bookImageName);
                    ResultSet resultSet = statement.executeQuery();
                    if (resultSet.next()) {
                        return Book.newBuilder()
                                .idbook(resultSet.getInt("idbook"))
                                .name(resultSet.getString("name"))
                                .author(resultSet.getString("author"))
                                .genre(resultSet.getString("genre"))
                                .price(resultSet.getDouble("price"))
                                .imageName(resultSet.getString("imageName"))
                                .build();
                    }
                } catch (SQLException e) {
                    System.out.println(e.getMessage());
                    e.printStackTrace();
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
        return null;
    }

    @Override
    public Book getBookByID(Integer id) {
        Connection connection = null;
        try {
            connection = connectionManager.getConnection();
            if (connection != null) {
                try (PreparedStatement statement = connection.prepareStatement(
                        "SELECT * FROM book WHERE idbook=?")) {
                    statement.setInt(1, id);
                    ResultSet resultSet = statement.executeQuery();
                    if (resultSet.next()) {
                        return Book.newBuilder()
                                .idbook(resultSet.getInt("idbook"))
                                .name(resultSet.getString("name"))
                                .author(resultSet.getString("author"))
                                .genre(resultSet.getString("genre"))
                                .price(resultSet.getDouble("price"))
                                .imageName(resultSet.getString("imageName"))
                                .build();
                    }
                } catch (SQLException e) {
                    System.out.println(e.getMessage());
                    e.printStackTrace();
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
        return null;
    }

    @Override
    public Double getBookRoman() {
        Connection connection = null;
        try {
            connection = connectionManager.getConnection();
            if (connection != null) {
                try (PreparedStatement statement = connection.prepareStatement(
                        "select sum(price) as allprice from book where genre=\"roman\"")) {
                    ResultSet resultSet = statement.executeQuery();
                    if (resultSet.next()) {
                        Double price = resultSet.getDouble("allprice");
                        System.out.println(price);
                        return price;
                    }
                } catch (SQLException e) {
                    System.out.println(e.getMessage());
                    e.printStackTrace();
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
        return null;
    }

    @Override
    public Double getBookDrama() {
        Connection connection = null;
        try {
            connection = connectionManager.getConnection();
            if (connection != null) {
                try (PreparedStatement statement = connection.prepareStatement(
                        "select sum(price) as allprice from book where genre=\"drama\"")) {
                    ResultSet resultSet = statement.executeQuery();
                    if (resultSet.next()) {
                        Double price = resultSet.getDouble("allprice");
                        System.out.println(price);
                        return price;
                    }
                } catch (SQLException e) {
                    System.out.println(e.getMessage());
                    e.printStackTrace();
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
        return null;
    }

    @Override
    public Double getBookScience() {
        Connection connection = null;
        try {
            connection = connectionManager.getConnection();
            if (connection != null) {
                try (PreparedStatement statement = connection.prepareStatement(
                        "select sum(price) as allprice from book where genre=\"science\"")) {
                    ResultSet resultSet = statement.executeQuery();
                    if (resultSet.next()) {
                        Double price = resultSet.getDouble("allprice");
                        System.out.println(price);
                        return price;
                    }
                } catch (SQLException e) {
                    System.out.println(e.getMessage());
                    e.printStackTrace();
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
        return null;
    }

    @Override
    public boolean addBook(Book infoBook) {
        System.out.println("adddao");
        Connection connection = null;
        try {
            connection = connectionManager.getConnection();
            if (connection != null) {
                try (PreparedStatement preparedStatement = connection.prepareStatement(
                        "INSERT  INTO book( name, author, genre, price, imageName) " +
                                "VALUES( ?, ?, ?, ?, ?);", PreparedStatement.RETURN_GENERATED_KEYS
                )) {
                    connection.setAutoCommit(false);
                    preparedStatement.setString(1, infoBook.getName());
                    preparedStatement.setString(2, infoBook.getAuthor());
                    preparedStatement.setString(3, infoBook.getGenre());
                    preparedStatement.setDouble(4, infoBook.getPrice());
                    preparedStatement.setString(5, infoBook.getImageName());
                    preparedStatement.executeUpdate();
                }
                connection.commit();
                return true;
            }
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
        } finally {
            try {
                connection.setAutoCommit(true);
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;
    }
}
