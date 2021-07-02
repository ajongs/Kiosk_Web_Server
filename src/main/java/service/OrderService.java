package service;

import domain.OrderList;
import domain.Product;

import java.util.List;
import java.util.Map;

public interface OrderService {
    void orderProduct(List<Product> product);
    int orderList(List<Product> list);
    List<OrderList> showOrderList();
    void complete(List<Integer> no);
}
