package serviceImpl;

import domain.OrderList;
import domain.Product;
import mapper.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.OrderService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    OrderMapper orderMapper;

    @Override
    public void orderProduct(List<Product> product) {
        orderMapper.orderProduct();
    }
    @Override
    public int orderList(List<Product> list){
        int id = orderMapper.findMaxId();
        Map<String, Object> orderList = new HashMap<>();
        orderList.put("id", id);
        orderList.put("list", list);
        orderMapper.orderList(orderList);
        return id;
    }

    @Override
    public List<OrderList> showOrderList() {
        return orderMapper.showOrderList();
    }

    @Override
    public void complete(List<Integer> no) {
        orderMapper.complete(no);
    }
}
