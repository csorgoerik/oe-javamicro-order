/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.yokudlela.order.spring;
import hu.yokudlela.order.datamodel.ExtraItem;
import hu.yokudlela.order.datamodel.Item;
import hu.yokudlela.order.datamodel.Order;
import hu.yokudlela.table.datamodel.Reservation;
import hu.yokudlela.table.datamodel.Table;
import java.time.LocalDateTime;
import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author oe
 */
public class OrderApplication {
    public static void main(String[] args) {
        ExtraItem extra = ExtraItem.builder()
                .name("Sajt")
                .amount(1)
                .price(300)
                .available(true)
                .build();
        
        List<ExtraItem> extras = new ArrayList<>();
        extras.add(extra);
        
        Item item = Item.builder()
                .name("Vasi pecsenye")
                .price(1950)
                .available(true)
                .build(); 
        
        Table tmp = Table.builder()
                .name("A1")
                .capacity((byte)2)
                .build();
        
        Reservation reservation = Reservation.builder()
                .contact("+36301111222")
                .name("Béla")
                .person((byte)3)
                .begin(LocalDateTime.MIN)
                .end(LocalDateTime.MAX)
                .table(tmp)
                .build();
        
        
        Order ord = Order.builder()
                .item(item)
                .extras(extras)
                .comment("Medium rare")
                .reservation(reservation)
                .build();
        System.out.println(ord.getItem().getName());
    }
    
}
