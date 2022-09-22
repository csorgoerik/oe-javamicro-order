/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.yokudlela.order.spring;

import hu.yokudlele.order.datamodel.OrderItem;

/**
 *
 * @author oe
 */
public class OrderApplication {
    public static void main(String[] args) {
        OrderItem tmp = OrderItem.builder()
                .foodid("1")
                .groupName("Béláék")
                .note("")
                .note4all(true)
                .orderid("12")
                .quantity(2)
                .build();
    }
}
