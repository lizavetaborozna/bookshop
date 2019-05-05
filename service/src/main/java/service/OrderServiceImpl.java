package service;

import converter.OrderConverter;
import dao.*;
import daoImpl.BookDaoImpl;
import daoImpl.OrderDaoImpl;
import daoImpl.UserDaoImpl;
import dto.OrderDTO;
import iterator.Iterator;

import java.util.ArrayList;
import java.util.List;

public class OrderServiceImpl implements OrderService {
    private static OrderServiceImpl instance;
    int index;
    List<Integer> listIdBook = new ArrayList<>();

    private OrderServiceImpl() {
    }

    public static OrderServiceImpl getInstance() {
        if (instance == null) {
            instance = new OrderServiceImpl();
        }
        return instance;
    }

    private OrderDAO orderDAO = OrderDaoImpl.getInstance();
    private UserDAO userDAO = UserDaoImpl.getInstance();
    private OrderConverter orderConverter = new OrderConverter();
    private BookDAO bookDAO = BookDaoImpl.getInstance();


    @Override
    public void addOrder(String username, String[] booksID) {
        int userId = userDAO.getByUserName(username).getId();
        Double allPrice = 0.0;
        for (String bookID : booksID) {
            listIdBook.add(Integer.parseInt(bookID));
            Double price = bookDAO.getBookByID(Integer.parseInt(bookID)).getPrice();
            allPrice = allPrice + price;
            System.out.println(price + "Добавить в заказ");
        }
        orderDAO.addToOrder(userId, listIdBook, allPrice);
    }

    @Override
    public List<OrderDTO> getListOrderForUser(String username) {
        return orderConverter.converterListOrderToOrderDTO(orderDAO.getOrders(orderDAO.getOrderItemForUser(userDAO.getByUserName(username).getId())));
    }

    @Override
    public void deleteOrder(int idOrder) {
        orderDAO.deleteOrder(idOrder);
    }

    @Override
    public List<OrderDTO> getListAllOrder() {
        return orderConverter.converterListOrderToOrderDTO(orderDAO.getOrders(orderDAO.getOrderItemForAllUser()));
    }

    @Override
    public void updateStatusOrder(int idOrder) {
        orderDAO.updateStatusOrder(idOrder);
    }

    @Override
    public List<Double> getSum(List<OrderDTO> list) {
        Double sum1 = orderDAO.getOrderStatus();
        List<Double> sums = new ArrayList<>();
        sums.add(sum1);
        return sums;
    }

    @Override
    public List<Double> getSumWaiting(List<OrderDTO> list) {
        Double sum1 = orderDAO.getOrderStatusWaiting();
        List<Double> sums = new ArrayList<>();
        sums.add(sum1);
        return sums;
    }
}
