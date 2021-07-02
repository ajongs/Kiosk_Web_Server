package controller;

import domain.OrderList;
import domain.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import service.OrderService;

import java.util.ArrayList;
import java.util.List;

@Controller
public class OrderController {

    @Autowired
    OrderService orderService;

    @ResponseBody
    @RequestMapping(value="/orderProduct", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
    public String order(@RequestBody List<Product> product){
        orderService.orderProduct(product);
        int id = orderService.orderList(product);
        return "주문번호 "+id+"\n결제가 완료 되었습니다.";
    }
    @ResponseBody
    @RequestMapping(value="/orderList", method = RequestMethod.GET)
    public List<OrderList> showOrderList(){
        return orderService.showOrderList();
    }

    @ResponseBody
    @RequestMapping(value="/orderComplete", method=RequestMethod.POST, produces = "application/json; charset=utf-8")
    public String complete(@RequestBody List<Integer> no){
        orderService.complete(no);
        return "주문 완료";
    }
}
