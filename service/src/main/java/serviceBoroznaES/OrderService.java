package serviceBoroznaES;

import dtoBoroznaES.OrderDTO;

import java.util.List;

public interface OrderService {
    void addOrder(String username, String[] booksID);

    List<OrderDTO> getListOrderForUser(String username);

    void deleteOrder(int idOrder);

    List<OrderDTO> getListAllOrder();

    void updateStatusOrder(int idOrder);
    List<Double> getSum(List<OrderDTO> list);
    List<Double> getSumWaiting(List<OrderDTO> list);
}
