/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.yokudlela.order.spring;

import hu.yokudlele.order.datamodel.OrderItem;
import hu.yokudlele.order.datamodel.OrderItemsState;
import hu.yokudlele.order.datamodel.OrderStateEnum;
import hu.yokudlele.order.store.OrderItemStore;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author oe
 */
public class OrderApplication {
    public static void main(String[] args) {
        
        OrderItem tmp = OrderItem.builder()
                .groupName("teszt")
                .foodid("1")
                .orderid("3")
                .quantity(3)
                .note4all(false)
                .note("2 hideg")
                .build();
        OrderItem tmp1 = OrderItem.builder()
                .groupName("teszt")
                .foodid("4")
                .orderid("4")
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
        
        OrderItemStore store = new OrderItemStore();
        
        store.init();
        System.out.println("INIT:");
        System.out.println(store.GetAll("A1"));
        System.out.println("---------------------------------------------");
        
        store.Add("A1", list);
        System.out.println("ADD TO A1:");
        System.out.println(store.GetAll("A1"));
        System.out.println("---------------------------------------------");
        
        store.Add("B1", list);
        System.out.println("ADD TO B1:");
        System.out.println(store.GetAll("B1"));
        System.out.println("---------------------------------------------");
        
        String[] orders = {"1"};
        store.ModifyState(orders, OrderStateEnum.Paid);
        System.out.println("MODIFY ORDER 1:");
        System.out.println(store.GetAll("A1"));
        System.out.println("---------------------------------------------");
        
        store.Delete(orders);
        System.out.println("DELETE ORDER 1:");
        System.out.println(store.GetAll("A1"));
        System.out.println("---------------------------------------------");
        
        store.Clear("A1");
        System.out.println("CLEAR A1 TABLE:");
        System.out.println(store.GetAll("A1"));
        System.out.println("---------------------------------------------");
        
    }
}
