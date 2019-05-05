package daoBoroznaES;

import modelBoroznaES.Order;
import modelBoroznaES.OrderItem;

import java.util.List;

public interface OrderDAO {
    boolean addToOrder(int userId, List<Integer> booksId, Double price);

    List<Order> getOrders(List<OrderItem> orderItemList);

    List<OrderItem> getOrderItemForUser(int userId);

    void deleteOrder(int orderId);

    List<OrderItem> getOrderItemForAllUser();

    Double getOrderStatus();
    Double getOrderStatusWaiting();

    void updateStatusOrder(int orderId);
}
