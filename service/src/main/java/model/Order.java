package model;

import java.util.List;

public class Order {
    private Integer id;
    private String user;
    private Double price;
    private String status;
    private List<Book> books;

    public Integer getId() {
        return id;
    }

    public String getUser() {
        return user;
    }

    public Double getPrice() {
        return price;
    }

    public String getStatus() {
        return status;
    }

    public List<Book> getBooks() {
        return books;
    }

    private Order(Builder builder) {
        id = builder.id;
        user = builder.user;
        price = builder.price;
        status = builder.status;
        books = builder.books;
    }

    public static Builder newBuilder() {
        return new Builder();
    }


    public static final class Builder {
        private Integer id;
        private String user;
        private Double price;
        private String status;
        private List<Book> books;

        private Builder() {
        }

        public Builder id(Integer val) {
            id = val;
            return this;
        }

        public Builder user(String val) {
            user = val;
            return this;
        }

        public Builder price(Double val) {
            price = val;
            return this;
        }

        public Builder status(String val) {
            status = val;
            return this;
        }

        public Builder books(List<Book> val) {
            books = val;
            return this;
        }

        public Order build() {
            return new Order(this);
        }
    }
}
