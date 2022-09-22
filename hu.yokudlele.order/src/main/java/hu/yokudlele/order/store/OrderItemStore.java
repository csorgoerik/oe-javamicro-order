/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.yokudlele.order.store;

import hu.yokudlele.order.datamodel.OrderItem;
import hu.yokudlele.order.datamodel.OrderItemsState;
import hu.yokudlele.order.datamodel.OrderStateEnum;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import javax.annotation.PostConstruct;
import org.springframework.stereotype.Service;
import org.apache.commons.beanutils.BeanUtils;

/**
 *
 * @author oe
 */
@Service
public class OrderItemStore {
    private static final Map<String, List<OrderItemsState>> orders = new HashMap<>();
     
    @PostConstruct
    public void init(){
        OrderItem tmp = OrderItem.builder()
                .groupName("teszt")
                .foodid("1")
                .orderid("1")
                .quantity(3)
                .note4all(false)
                .note("2 hideg")
                .build();
        OrderItem tmp1 = OrderItem.builder()
                .groupName("teszt")
                .foodid("4")
                .orderid("2")
                .quantity(1)
                .note4all(true)
                .note("glutén mentes")
                .build();
        OrderItem[] orderItems = new OrderItem[2];
        orderItems[0] = tmp;
        orderItems[1] = tmp1;
        OrderItemsState one = OrderItemsState.builder()
                .orders(orderItems)
                .status(OrderStateEnum.Ordered)
                .build();
        List<OrderItemsState> list = new ArrayList<>();
        list.add(one);
        orders.put("A1", list);
        System.out.println(orders);
    }
     
    public void Add(String tableid, List<OrderItemsState> orders) {
        if(this.orders.containsKey(tableid)) {
            List<OrderItemsState> ordered = this.orders.get(tableid);
            ordered.addAll(orders);
            this.orders.put(tableid, ordered);
        }
        else {
            this.orders.put(tableid, orders);
        }        
    }
     
    public void ModifyState(String[] orderid, OrderStateEnum state) {
        for(Map.Entry<String, List<OrderItemsState>> entry : orders.entrySet()) {
            List<OrderItemsState> states = entry.getValue();
            for (OrderItemsState value : states) {
                int pos = states.indexOf(value);
                List<OrderItem> orderList = Arrays.asList(value.getOrders());
                if(orderList.stream().filter(x -> Arrays.asList(orderid).contains(x.getOrderid())).count() > 0) {
                    if(!value.getStatus().equals(state)) {
                        value.setStatus(state);
                        states.set(pos, value);
                        entry.setValue(states);
                    }
                }
            }
        }
    }
    /**
     * Rendelések törlése
     * @param orderid -> rendelés azonosítók
     */
    public void Delete(String[] orderid) {
        for(Map.Entry<String, List<OrderItemsState>> entry : orders.entrySet()) {
            List<OrderItemsState> states = entry.getValue();
            for (OrderItemsState value : states) {
                int pos = states.indexOf(value);
                List<OrderItem> orderList = new ArrayList<>(Arrays.asList(value.getOrders()));
                List<String> orderidStr = Arrays.asList(orderid);
                for (String str : orderidStr) {
                    Predicate<OrderItem> condition = x -> x.getOrderid().equals(str);
                    orderList.removeIf(condition);
                }
                OrderItem[] array = new OrderItem[orderList.size()];
                array = orderList.toArray(array);
                value.setOrders(array);
                states.set(pos, value);
                entry.setValue(states);
            }
        }
    }
    
    public void Clear(String tableid) {
        orders.put(tableid, new ArrayList<>());
    }
    
    public List<OrderItemsState> GetAll(String tableid) {
        return orders.get(tableid);
    }
}
