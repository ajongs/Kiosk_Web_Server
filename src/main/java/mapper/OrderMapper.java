package mapper;

import domain.OrderList;
import domain.Product;
import domain.User;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface OrderMapper {
    List<Product> order();
    void orderProduct();
    void orderList(Map<String, Object> orderList);
    int findMaxId();
    List<OrderList> showOrderList();
    void complete(List<Integer> no);
}
