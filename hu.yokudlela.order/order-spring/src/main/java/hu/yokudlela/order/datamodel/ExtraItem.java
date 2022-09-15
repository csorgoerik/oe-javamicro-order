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
/**
 *
 * @author oe
 */
@Data
@EqualsAndHashCode()
@NoArgsConstructor
public class ExtraItem {
    
    private String name;
    private int amount;
    private int price;
    private boolean available;
    
    @Builder
    public ExtraItem(String name, int amount, int price, boolean available) {
        this.name = name;
        this.amount = amount;
        this.price = price;
        this.available = available;
    }
}
