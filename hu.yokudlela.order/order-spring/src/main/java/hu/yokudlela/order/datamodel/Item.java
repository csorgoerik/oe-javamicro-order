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
public class Item {
    
    private String name;
    private double price;
    private boolean available;
    
    @Builder
    public Item(String name, double price, boolean available) {
        this.name = name;
        this.price = price;
        this.available = available;
    }
}
