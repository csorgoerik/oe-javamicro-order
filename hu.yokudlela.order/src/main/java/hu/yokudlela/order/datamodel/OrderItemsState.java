/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.yokudlela.order.datamodel;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode()
@NoArgsConstructor
public class OrderItemsState {
    private OrderItem[] orders;
    private OrderStateEnum status;
    
    @Builder
    public OrderItemsState(OrderItem[] orders, OrderStateEnum status) {
        this.orders = orders;
        this.status = status;
    }
}
